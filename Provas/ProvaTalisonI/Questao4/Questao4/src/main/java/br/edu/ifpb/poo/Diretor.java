package br.edu.ifpb.poo;

public class Diretor extends Empregado {
    private String departamento;

    public Diretor(String nome, int idade, double salário, String departamento) {
        super(nome, idade, salário);
        this.departamento = departamento;
    }

    public Diretor(String nome, String departamento) {
        super(nome);
        this.departamento = departamento;
    }
}
