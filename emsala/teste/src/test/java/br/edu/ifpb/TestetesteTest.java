package br.edu.ifpb;

import org.junit.Before;
import org.junit.Test;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TestetesteTest {

    @Test
    public static void main(String[] args) {
        Teste t1 = new Teste(3,5);
        Teste t2 = new Teste(4,7);
        Teste t3 = new Teste(5,52);
        Teste t4 = new Teste(2,520);

        NavigableSet<Teste> tree = new TreeSet<>(Teste::compareTo);
        tree.add(t1);
        tree.add(t2);
        tree.add(t3);
        tree.add(t4);
        System.out.println(tree);
    }
}
