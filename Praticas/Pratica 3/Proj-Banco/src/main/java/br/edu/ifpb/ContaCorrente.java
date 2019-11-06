package br.edu.ifpb;

import jdk.jfr.Unsigned;

public class ContaCorrente {
    private Integer numero;
    private String titular;
    private Double saldo;

    public ContaCorrente(Integer numero) {
        this.numero = numero;
        this.titular="Sem nome";
        this.saldo = 0.00;
    }

    public ContaCorrente(Integer numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.00;
    }

    public ContaCorrente(Integer numero, String titular, Double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double consultar() {
        return saldo;
    }

    public boolean sacar(Double valor) {
        if (valor < 0 | valor > saldo){
            return false;
        }
        this.saldo -= valor;
        descontarCPMF();
        return true;
    }

    public boolean depositar(Double valor){
        if(valor < 0){
            return false;
        }

        this.saldo += valor;
        return true;
    }

    public double calcularCPMF(){
        return (1*saldo)/100;
    }

    public boolean descontarCPMF(){
        this.saldo -= calcularCPMF();
        return true;
    }

    public double extrato(){

    }
}
