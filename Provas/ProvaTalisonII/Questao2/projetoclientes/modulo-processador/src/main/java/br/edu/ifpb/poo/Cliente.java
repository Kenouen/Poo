package br.edu.ifpb.poo;

import java.util.Objects;

public class Cliente implements Comparable<Cliente>{
    private int codigo;
    private String nome;
    private String sobrenome;
    private int idade;
    private String endereco;
    private String cidade;
    private String estado;
    private String CodigoPostal;

    public Cliente(int codigo,
                   String nome,
                   String sobrenome,
                   int idade,
                   String endereco,
                   String cidade,
                   String estado,
                   String codigoPostal){
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.CodigoPostal = codigoPostal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        CodigoPostal = codigoPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return this.getCodigo() == cliente.getCodigo();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.getCodigo());
    }

    @Override
    public int compareTo(Cliente o) {
        return Integer.compare(this.getCodigo(), o.getCodigo());
    }


    @Override
    public String toString() {
        return String.format("%d;%s;%s;%d;%s;%s;%s;%s",getCodigo(),
                                                getNome(),
                                                getSobrenome(),
                                                getIdade(),
                                                getEndereco(),
                                                getCidade(),
                                                getEstado(),
                                                getCodigoPostal());
    }
}
