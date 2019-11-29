package br.edu.ifpb;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements ObjetoRemoto_IF{
    private RepoAeroportosTXT repo;

    public Servidor() throws IOException {
        repo = new RepoAeroportosTXT();
    }

    @Override
    public String listarAeroportosPor(String letra) throws RemoteException {return repo.listarAeroportosPor(letra); }

    @Override
    public String getNomeAeroporto(String ID) throws RemoteException { return repo.getNomeAeroporto(ID);}

    @Override
    public String editarNomeAeroporto(String ID, String novoNome) throws RemoteException, IOException { return repo.editarNomeAeroporto(ID, novoNome);}


    public static void main(String[] args) {
        try {
            Servidor a = new Servidor();
            ObjetoRemoto_IF stub = (ObjetoRemoto_IF) UnicastRemoteObject.exportObject(a, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Airports", stub);
            System.out.println("Servidor Pronto :)");

        } catch (Exception o) {
            System.err.println("Deu ruim :( Erro: " + o.toString());
        }
    }


}
