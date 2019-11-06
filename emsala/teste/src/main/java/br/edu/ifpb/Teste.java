package br.edu.ifpb;

import java.util.Objects;

public class Teste implements Comparable<Teste>{
    private int inteiro;
    private double doublee;

    public Teste(int inteiro, double doublee) {
        this.inteiro = inteiro;
        this.doublee = doublee;
    }

    public Teste() {
        this.inteiro = 1;
        this.doublee = 1;
    }

    public int getInteiro() {
        return inteiro;
    }

    public void setInteiro(int inteiro) {
        this.inteiro = inteiro;
    }

    public double getDoublee() {
        return doublee;
    }

    public void setDoublee(double doublee) {
        this.doublee = doublee;
    }

    @Override
    public String toString() {
        return "Teste{" +
                "inteiro=" + inteiro +
                ", doublee=" + doublee +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Teste teste = (Teste) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(inteiro, teste.inteiro)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(inteiro)
                .toHashCode();
    }

    @Override
    public int compareTo(Teste o) {
        return this.inteiro;
    }
}
