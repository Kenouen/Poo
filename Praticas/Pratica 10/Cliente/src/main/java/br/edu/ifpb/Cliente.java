package br.edu.ifpb;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    private static ObjetoRemoto_IF stub;
    private static Registry registry;


    public static void main(String[] args) {
        String ip = (args.length < 1) ? "localhost" : args[0];
        try{
            registry = LocateRegistry.getRegistry(ip);
            ObjetoRemoto_IF stub = (ObjetoRemoto_IF) registry.lookup("Airports");
            System.out.println("oi");
            System.out.println(stub.CadastrarAeroporto("Tal", "Campina Grande"));
            System.out.println(stub.removerAeroporto("Tal"));

        } catch (Exception e) {
            System.err.println("Erro ao rodar o programa, Erro: " + e.toString());;
        }
    }
}
