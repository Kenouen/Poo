package br.edu.ifpb;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetoRemoto_IF extends Remote {
    String listarAeroportosPor(String letra) throws RemoteException;

    String getNomeAeroporto(String ID) throws RemoteException;

    String editarNomeAeroporto(String ID, String novoNome) throws RemoteException, IOException;

}
