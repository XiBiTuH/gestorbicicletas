/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorbicicletas;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author nosco
 */
public interface interfaceServidor extends java.rmi.Remote   {
    
    public void mostraBicicletas() throws RemoteException;
    
    public String adicionarBicicleta(int dono, String quadro, String rodas, String transmissao, String travoes, String espigao, String guiador,String descricao) throws RemoteException;
    
    public void requisitarBicicleta() throws RemoteException;
    
    public void devolverBicicleta() throws RemoteException;
    
    public ArrayList procurarKeyword(String keyword) throws RemoteException;
    
}
