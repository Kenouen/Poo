package br.edu.ifpb.poo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessadorClientes implements Comparator<Cliente>{
    private Set<Cliente> clienteSet;

    public ProcessadorClientes(String path) {
        this.clienteSet = lerTodosClientes(Paths.get(path));
    }


    public Set<Cliente> lerTodosClientes(Path pathOrigem){
        try {
            List<String> aux = Files.readAllLines(pathOrigem, Charset.defaultCharset());
            Set<Cliente> aux2 = new HashSet<>();
            for (String s : aux) {
                String[] c = s.split(";");
                aux2.add(new Cliente(Integer.decode(c[0]), c[1], c[2], Integer.decode(c[3]),
                        c[4], c[5], c[6], c[7]));
            }
            return aux2;
        }catch (IOException o){
            System.err.println("Erro ao ler o arquivo! :(");
        }
        return null;
    }


    public void salvarClientesOrdenadosPor(Path pathdestino, Comparator<Cliente> comparator){
        try{
            NavigableSet<Cliente> aux = new TreeSet<>(comparator);
            aux.addAll(this.clienteSet);
            Files.write(pathdestino,
                        aux.stream().map(Cliente::toString).collect(Collectors.toUnmodifiableList()),
                        Charset.defaultCharset(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING,
                        StandardOpenOption.WRITE);
            System.out.println("Tudo Pronto :)");
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo! :(");
        }
    }

    public Set<Cliente> getMaioresDezoito(){
        Set<Cliente> a = new HashSet<>();
        for (Cliente cliente : clienteSet) {
            if(cliente.getIdade() >= 18){
                a.add(cliente);
            }
        }
        return a;
    }

    public void salvarClientes(Path pathdestino){
        try {
            Files.write(pathdestino,
                    this.clienteSet.stream().map(Cliente::toString).collect(Collectors.toUnmodifiableSet()),
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
            System.out.println("Tudo Pronto :)");
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo :(");
        }
    }

    public Map<Integer, List<Integer>> agruparClientesPorIdade(){
        HashMap<Integer, List<Integer>> mapa = new HashMap<>();
        for (Cliente cliente : clienteSet) {
            if(!mapa.containsKey(cliente.getIdade())){
                List<Integer> aux = new ArrayList<>();
                aux.add(cliente.getCodigo());
                mapa.put(cliente.getIdade(), aux);
            }else {
                List<Integer> aux = mapa.get(cliente.getIdade());
                aux.add(cliente.getCodigo());
            }
        }
        System.out.println("Tudo Pronto :)");
        return mapa;
    }

    public void gravarMapaClientes(Path pathdestino){
        Map<Integer, List<Integer>> aux = agruparClientesPorIdade();
        List<String> a = new ArrayList<>();
        for (Integer integer : aux.keySet()) {
            String linha = "";
            try {
                linha += (String.format("%d; ", integer));
                linha += (aux.get(integer).toString());
                Files.write(pathdestino,
                        linha.lines().collect(Collectors.toUnmodifiableSet()),
                        Charset.defaultCharset(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND,
                        StandardOpenOption.WRITE);

            } catch (IOException e) {
                System.err.println("Erro ao gravar o arquivo :(");
            }
        }
        System.out.println("Tudo Pronto :)");
    }




    @Override
    public String toString() {
        for (Cliente cliente : clienteSet) {
            System.out.println(cliente.toString());
        }
        return null;
    }

    @Override
    public int compare(Cliente o1, Cliente o2) {
        return Integer.compare(o1.getIdade(), o2.getIdade());
    }
}
