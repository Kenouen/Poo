package br.edu.ifpb.poo;

public class Empregado
{
    private String nome;
    private int idade;
    private double salário;

    public Empregado(String nome, int idade, double salário) {
        this.nome = nome;
        this.idade = idade;
        this.salário = salário;
    }

    public Empregado(String nome) {
        this.nome = nome;
    }

    public Empregado(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
