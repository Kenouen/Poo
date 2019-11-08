package br.edu.ifpb;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class City implements Comparable<City>{
    private String nome;
    private String sigla;
    private String codigo;

    public City(String nome, String sigla, String codigo) {
        this.nome = nome;
        this.sigla = sigla;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return nome.equals(city.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public int compareTo(City o) {
        return this.getNome().compareTo(o.getNome());
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", getNome(), getSigla(), getCodigo());
    }
}
