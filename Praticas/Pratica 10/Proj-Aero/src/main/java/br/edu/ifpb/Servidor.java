package br.edu.ifpb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class Servidor implements ObjetoRemoto_IF {
    private Map<String, String> mapa;
    private Path p;

    public Servidor() {
        this.mapa = new TreeMap<>();
        this.p = Paths.get("/home/kenin/Desktop/poo/Praticas/Pratica 10/Proj-Aero/files/airports.txt");
        InputStream inputStream = Servidor.class.getResourceAsStream("/files/airports.txt");
        System.out.println("1");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream); // ponte
        System.out.println("2");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("3");
        List<String> aux = bufferedReader.lines().collect(Collectors.toList());
        System.out.println(Path.of(String.valueOf(inputStream)));
        for (String s : aux) {
            List<String> aux2 = Arrays.asList(s.split(","));
            mapa.put(aux2.get(0), aux2.get(1));
        }

    }
    public static void main(String[] args) {
        try {
            Servidor a = new Servidor();
            ObjetoRemoto_IF stub = (ObjetoRemoto_IF) UnicastRemoteObject.exportObject(a, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Airports", stub);
            System.out.println("Servidor Pronto :)");
        } catch (Exception o) {
            System.err.println("Deu ruim1 :( Erro: " + o.toString());
        }
    }

    @Override
    public String CadastrarAeroporto(String id, String Cidade) throws RemoteException {
        if (id.equals("") || Cidade.equals("")) {
            return "Cadastro Invalido";
        }
        mapa.put(id, Cidade);

        if (this.atualizarTXT()) return "Cadastro concluido major :)";
        return "Não cadastrado";
    }

    @Override
    public String removerAeroporto(String id) throws RemoteException {
        if (!mapa.containsKey(id))return "Erro ao remover :(" + mapa.get(id);

        mapa.remove(id);
        if (this.atualizarTXT()) ;
        return "Removido major :)";
    }

    @Override
    public String buscar(String id) throws RemoteException {
        if (mapa.containsKey(id)) {
            return "Não existe :(";
        }
        return mapa.get(id);
    }

    private Boolean atualizarTXT() {
        try {
            Files.deleteIfExists(p);
            for (String s : mapa.keySet()) {
                String linha = "";
                try {
                    linha += s;
                    linha += mapa.get(s);
                    Files.write(p,
                            linha.lines().collect(Collectors.toUnmodifiableSet()),
                            Charset.defaultCharset(),
                            StandardOpenOption.CREATE,
                            StandardOpenOption.APPEND,
                            StandardOpenOption.WRITE);

                } catch (IOException e) {
                    System.err.println("Erro ao gravar o arquivo :(");
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
