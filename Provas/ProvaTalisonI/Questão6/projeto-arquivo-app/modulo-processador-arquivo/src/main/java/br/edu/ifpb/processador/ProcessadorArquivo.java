package br.edu.ifpb.processador;

import java.util.*;

public class ProcessadorArquivo {
    private String path;
    private ArrayList<ArrayList> dados;

    public ProcessadorArquivo() {
        this.path = "";
        dados = new ArrayList<ArrayList>();
    }

    public void setPath(String path) {
        this.path = path;
        dados = new ArrayList<>();
    }

    public ArrayList<ArrayList> processa() {

        ArrayList<Character> extensao = new ArrayList<>();
        ArrayList<Character> nome = new ArrayList<>();
        ArrayList<Character> pathh = new ArrayList<>();
        int cond = 0, cont = 0;
        for (int i = 0; i < path.length(); i++) {
            if (cond == 1 | path.charAt(i) == '.') {
                extensao.add(path.charAt(i));
                cond = 1;
            }
            if (path.charAt(i) == '/') {
                cont = i;
            }
        }

        for (int i = cont; i < path.length(); i++) {
            if (path.charAt(i) == '.') {
                break;
            }
            nome.add(path.charAt(i));
        }

        for (int i = 0; i < cont; i++) {
            pathh.add(path.charAt(i));
        }


        dados.add(extensao);
        dados.add(nome);
        dados.add(pathh);

        return dados;
    }
}