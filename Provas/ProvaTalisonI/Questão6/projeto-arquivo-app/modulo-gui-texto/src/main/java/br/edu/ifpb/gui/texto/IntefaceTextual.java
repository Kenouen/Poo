package br.edu.ifpb.gui.texto;

import br.edu.ifpb.processador.ProcessadorArquivo;

import java.sql.SQLOutput;
import java.util.*;
public class IntefaceTextual {
    public static void main(String[] args) {
        ProcessadorArquivo pa = new ProcessadorArquivo();
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo: ");
        String path = input.nextLine();
        pa.setPath(path);
        ArrayList<ArrayList> dados = pa.processa();

        String extensao = "";
        int cond = 0;
        System.out.println("Resultado do processamento:");
        System.out.print("Extensão = ");
        System.out.println(dados.get(0));
        System.out.print("Nome = ");
        System.out.println(dados.get(1));
        System.out.print("Path = ");
        System.out.println(dados.get(2));

    }
}
