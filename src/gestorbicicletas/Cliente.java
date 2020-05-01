/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorbicicletas;

import static java.lang.System.exit;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Cliente {

    public static void main(String args[]) throws RemoteException, NotBoundException {
        Cliente cliente = new Cliente();
        cliente.connectRemote();

    }

    public void mostrarMenu() {
        System.out.println(" Escolha uma das seguintes opções ");
        System.out.println(" 1 - Desejo adicionar uma bicicleta ");
        System.out.println(" 2 - Desejo consultar bicicletas ");
        System.out.println(" 3 - Desejo requisitar uma bicicleta  ");
        System.out.println(" 4 - Desejo devolver uma bicicleta  ");
        System.out.println(" 5 - Desejo ver todas as bicicletas listadas ");
        System.out.println(" 0 - Desejo sair");

    }

    private void connectRemote() throws RemoteException, NotBoundException {
        try {

            //Scanner e registo
            Scanner sc = new Scanner(System.in);
            Registry reg = LocateRegistry.getRegistry("localhost", 2222);
            interfaceServidor servidor = (interfaceServidor) reg.lookup("servidor");
            System.out.println(" Bem vindo ao melhor sítio para trocar ou vender Bicicletas ");
            System.out.println("Indique o seu numero de aluno: ");
            int id = sc.nextInt();

            int choice;
            while (true) {

                //Mostramos menu
                mostrarMenu();
                choice = sc.nextInt();

                //Escolha do utilizador
                switch (choice) {
                    case 0:
                        exit(1);

                    //Adicionar bicicleta
                    case 1:

                        while (true) {

                            System.out.println("Para inserir uma bicicleta terá de nos forcener alguns dados.");
                            sc.nextLine();
                            System.out.print("Quadro : ");
                            String quadro = sc.nextLine();

                            System.out.print("Rodas : ");
                            String rodas = sc.nextLine();

                            System.out.print("Transmissão : ");
                            String transm = sc.nextLine();

                            System.out.print("Travões : ");
                            String travoes = sc.nextLine();

                            System.out.print("Espigão : ");
                            String espigao = sc.nextLine();

                            System.out.print("Guiador : ");
                            String guiador = sc.nextLine();
                            
                            
                            System.out.print("Insira uma breve descrição da bicicleta : ");
                            String descricao = sc.nextLine();

                            //Caso esteja um campo empty
                            if (quadro.isEmpty() || rodas.isEmpty() || transm.isEmpty() || travoes.isEmpty() || espigao.isEmpty() || guiador.isEmpty() || descricao.isEmpty()) {
                                System.out.println("Houve um erro na recolha dos dados, por favor, preencha todos os campos ! ");

                                //Caso esteja tudo bem, chamamos o metodo do servidor que insere uma bicicleta
                            } else {

                                //Criamos uma bicicleta com os dados fornecidos
                                //System.out.println("olaolaolaol");
                                String res = servidor.adicionarBicicleta(id, quadro, rodas, transm, travoes, espigao, guiador,descricao);

                                if (res.equals("succ")) {
                                    System.out.println("Bicicleta inserida com sucesso");
                                    System.out.println("");
                                    break;
                                } else {
                                    System.out.println("Erro na inserção da bicicleta");
                                    }
                                }
                            
                            
                            }
                        
                        
                        break;
                        

                    case 2:
                        
                            System.out.println("Que 'keyword' pretende pesquisar ? ");
                            String keyword = sc.next();
                            ArrayList<Bicicleta> bics = servidor.procurarKeyword(keyword);
                            
                        
                        
                        
                             
                }

            }

        } catch (NotBoundException | RemoteException e) {
            System.out.println(e);

        }

    }
}
