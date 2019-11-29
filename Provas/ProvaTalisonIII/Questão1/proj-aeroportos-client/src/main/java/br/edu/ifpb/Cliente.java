package br.edu.ifpb;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Usar localhost, ou adicionar IP?" + "\n" +
                            "1 - localhost" + "\n" +
                            "2 - adicionar IP");

        int decisao_ip = s.nextInt();
        String ip = "";
        if (decisao_ip == 1) ip = "localhost";
        else{
            System.out.print("Digite o ip: ");
            ip = s.next();
        }
        try{
            Registry registry = LocateRegistry.getRegistry(ip);
            ObjetoRemoto_IF stub = (ObjetoRemoto_IF) registry.lookup("Airports");

            while (true){

                System.out.println("Operações disponibilizadas:" + "\n\n" +
                        "0 - Listar Aeroportos por inicial do ID" + "\n" +
                        "1 - Receber nome apartir do ID" + "\n" +
                        "2 - editar o nome de um aeroporto" + "\n" +
                        "3 - Sair");

                int a = s.nextInt();
                if (a == 0) {
                    System.out.print("Letra:");
                    String b = s.next();
                    System.out.println(stub.listarAeroportosPor(b));

                }else if(a == 1) {
                    System.out.println("ID: ");
                    String b = s.next();
                    System.out.println(stub.getNomeAeroporto(b));

                }else if(a == 2) {
                    System.out.println("ID (espaço) novonome exemplo: 'TES Teste': ");
                    String b = s.next();
                    String c = s.nextLine();
                    System.out.println(stub.editarNomeAeroporto(b, c));

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
