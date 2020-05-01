/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorbicicletas;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Servidor extends UnicastRemoteObject implements interfaceServidor {

    private ArrayList<Bicicleta> bicicletas;

    public Servidor() throws RemoteException {
        super();

        //Tratamos da persistência de dados
        //Lemos as bicicletas que já estavam registadas
        File backup = new File("bicicletas.dat");

        //Caso o ficheiro não exista, criamos um novo ficheiro bicicletas.dat
        if (!backup.exists()) {
            bicicletas = new ArrayList<>();
            backup = new File("bicicletas.dat");
        } //Caso o ficheiro  exista, vamos ler os objetos bicicletas que nele estão contidas
        else {

            //Abrimos o ficheiro
            try {

                FileInputStream aux_in = new FileInputStream("bicicletas.dat");
                ObjectInputStream oos = new ObjectInputStream(aux_in);

                //Lemos os objetos bicicleta
                ArrayList<Bicicleta> bicicletas_guardadas = (ArrayList) oos.readObject();
                oos.close();
                aux_in.close();

                //Caso o ficheiro não es vazio
                if (bicicletas_guardadas.isEmpty()) {
                    this.bicicletas = new ArrayList<>();
                } //Caso contrário
                else {
                    this.bicicletas = bicicletas_guardadas;

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //Metemos o servidor a fucnionar
    public static void main(String args[]) throws RemoteException {

        try {

            Registry reg = LocateRegistry.createRegistry(2222);
            reg.rebind("servidor", new Servidor());
            System.out.println("Servidor Online! ");

        } catch (RemoteException e) {
            System.out.println(e);
        }

    }

    @Override
    public void mostraBicicletas() throws RemoteException {

    }

    @Override
    public void devolverBicicleta() throws RemoteException {

    }

    @Override
    public String adicionarBicicleta(int dono, String quadro, String rodas, String transmissao, String travoes, String espigao, String guiador, String descricao) throws RemoteException {

        try {
            Bicicleta b = new Bicicleta(dono, quadro, rodas, transmissao, travoes, espigao, guiador, descricao);
            bicicletas.add(b);
            //System.out.println(bicicletas);
        } catch (Exception e) {
            return "error";
        }
        return "succ";
    }

    @Override
    public void requisitarBicicleta() throws RemoteException {

    }

    @Override
    public ArrayList procurarKeyword(String keyword) throws RemoteException {
        //System.out.println("Entrei aqui");

        ArrayList<Bicicleta> aux = new ArrayList<>();
        for (int i = 0; bicicletas.size() > i; i++) {
            String des = bicicletas.get(i).getDescricao();
            
            if (des.contains(keyword)) {
                aux.add(bicicletas.get(i));
            }

        }

        return aux;
    }

    @Override
    public ArrayList getListaRecursos() throws RemoteException {
          return bicicletas;
    }
}
