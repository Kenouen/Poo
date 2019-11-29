package br.edu.ifpb;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetoRemoto_IF extends Remote {
    String CadastrarAeroporto(String id, String Cidade) throws RemoteException;

    String removerAeroporto(String id) throws RemoteException;

    String buscar(String d) throws RemoteException;
}
