package br.edu.ifpb;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    private static ObjetoRemotoSignos_IF stub;
    private static Registry registry;


    public static void main(String[] args) {
        String host = (args.length < 1) ? "localhost" : args[0];
        try{
            registry = LocateRegistry.getRegistry(host);
            stub = (ObjetoRemotoSignos_IF) registry.lookup("signos");
            Scanner s = new Scanner(System.in);
            String signo = s.next();

            while (!signo.equals("sair")){
                System.out.println(stub.getMsgSigno(signo));
                signo = s.next();

            }

        } catch (NotBoundException e) {
            System.err.println("Erro ao rodar o programa, Erro: " + e.toString());;
        }catch (RemoteException e){
            System.err.println(e.toString());
        }
    }

}
