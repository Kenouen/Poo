package br.edu.ifpb.poo;

import java.nio.file.Path;
import java.util.Comparator;

public class ProcessadorDemo {
    public static void main(String[] args) {
        ProcessadorClientes processador = new ProcessadorClientes("files/50-customers.txt");
        processador.salvarClientesOrdenadosPor(Path.of("files/ordenado.txt"), Comparator.comparing(Cliente::getIdade));
        //processador.salvarClientesOrdenadosPor(Path.of("files/ordenado.txt"), Comparator.comparing(Cliente::getNome));
        //processador.salvarClientesOrdenadosPor(Path.of("files/ordenado.txt"), Comparator.comparing(Cliente::getEstado));
        processador.getMaioresDezoito();
        processador.salvarClientes(Path.of("files/clientes.txt"));
        processador.agruparClientesPorIdade();
        processador.gravarMapaClientes(Path.of("files/mapa.txt"));
    }
}
