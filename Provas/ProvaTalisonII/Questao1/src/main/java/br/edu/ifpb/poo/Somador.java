package br.edu.ifpb.poo;

public class Somador {
    public static void main(String[] args) {
        int soma = 0;
        for (String s : args) {
            try {
                if (Integer.decode(s) < 0) {
                    throw new NumberFormatException();
                }
                soma += Integer.decode(s);

            } catch (NumberFormatException nfe) {
                System.err.printf("Erro: A entrada \"%s\" é invalida. Será desprezada.\n", s);
            }
        }
        System.out.println("O resultado da soma: " + soma);

    }
}
