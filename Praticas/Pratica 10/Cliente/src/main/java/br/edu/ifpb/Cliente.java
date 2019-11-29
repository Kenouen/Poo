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

            Scanner s = new Scanner(System.in);
            while (true){

                System.out.println("Operações disponibilizadas:" + "\n" +
                                    "0 - Cadastrar Aeroporto" + "\n" +
                                    "1 - Remover Aeroporto" + "\n" +
                                    "2 - Buscar por Sigla" + "\n" +
                                    "3 - Sair");

                int a = s.nextInt();

                if (a == 0) {
                    System.out.println("ID (espaço) Aeroporto: ");
                    String b = s.next();
                    String c = s.nextLine();
                    System.out.println(stub.CadastrarAeroporto(b, c));

                }else if(a == 1) {
                    System.out.println("ID: ");
                    String d = s.next();
                    System.out.println(stub.removerAeroporto(d));

                }else if(a == 2) {
                    System.out.println("ID: ");
                    String e = s.next();
                    System.out.println(stub.buscar(e));

                }else if(a == 3){
                    System.out.println("Saindo...");
                    break;

                }else System.out.println("Valor invalido");
            }
        } catch (Exception e) {
            System.err.println("Erro ao rodar o programa, Erro: " + e.toString());;
        }
    }
}
