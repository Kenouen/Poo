package br.edu.ifpb;

public class runner {
    public static void main(String[] args) {
        Citybd bd = new Citybd("files/cities.txt");
        bd.writesetofcities("files/final.txt");

    }
}
