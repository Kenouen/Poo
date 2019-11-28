package br.edu.ifpb.poo;

public class Produto {

    private int codigo;
    private String descrição;
    private String origem;
    private double preço;
    private int quant;


    public Produto(int codigo, String descrição, String origem) {
        this.codigo = codigo;
        this.descrição = descrição;
        this.origem = origem;
        this.preço = 0.0;
        this.quant = 0;
    }

    public Produto(int codigo, String descrição, String origem, double preço, int quant) {
        this.codigo = codigo;
        this.descrição = descrição;
        this.origem = origem;
        this.preço = preço;
        this.quant = quant;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getCodigo() {
        return codigo;
    }


}
