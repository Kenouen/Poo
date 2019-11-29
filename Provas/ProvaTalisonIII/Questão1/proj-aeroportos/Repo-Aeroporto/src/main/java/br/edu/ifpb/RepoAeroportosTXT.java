package br.edu.ifpb;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class RepoAeroportosTXT {
    private Path path;
    private Map<String, String> mapa;



    public RepoAeroportosTXT() throws IOException {
        mapa = new TreeMap<>();
        path = Paths.get("airports.txt");


        List<String> aux = Files.readAllLines(path, Charset.defaultCharset());

        for (String s : aux) {
            List<String> aux2 = Arrays.asList(s.split(","));
            mapa.put(aux2.get(0), aux2.get(1));
        }

    }

    public String listarAeroportosPor(String letra) {
        if (letra.isEmpty() || letra.isBlank()) return "Erro: letra invalida. Entrada: " + letra;

        List<String> aux = List.copyOf(mapa.keySet());

        List<String> aux2 = new ArrayList<>();

        for (String s : aux) {
            if (s.startsWith(letra))
                aux2.add(mapa.get(s));
        }

        if (aux2.isEmpty()) return "Erro: nenhum aeroporto foi encontrado!";

        String ret = "";
        for (String s : aux2) {
            ret = ret.concat(s + "\n");
        }

        return ret;
    }

    public String CadastrarAeroporto(String id, String Cidade) throws IOException {
        if (id.equals("") || Cidade.equals("")) {
            return "Cadastro Invalido";
        }
        if (Cidade.charAt(0) == ' ') {
            Cidade = Cidade.substring(1);
        }
        mapa.put(id, Cidade);

        if (this.atualizarTXT()) return "Cadastro concluido major :)";
        return "Não cadastrado";
    }

    public String removerAeroporto(String id) throws IOException {
        if (!mapa.containsKey(id)) return "Erro ao remover :(" + mapa.get(id);

        mapa.remove(id);
        if (this.atualizarTXT()) ;
        return "Removido major :)";
    }
    public String getNomeAeroporto(String ID) {
        if (!mapa.containsKey(ID)) return "Erro: nenhum aeroporto foi encontrado! :(";
        return mapa.get(ID);
    }

    public String editarNomeAeroporto(String ID, String novoNome) throws IOException {

        if (novoNome.isEmpty() || ID.isEmpty() || !mapa.containsKey(ID)) return "Erro: Não foi possível editar o nome!";

        mapa.replace(ID, novoNome);
        atualizarTXT();

        return "Nome do aeroporto foi atualizado com sucesso!";
    }

    private boolean atualizarTXT() throws IOException {
        Files.deleteIfExists(path);
        for (String s : mapa.keySet()) {
            String linha = "";
            linha += s + ",";
            linha += mapa.get(s);
            Files.write(path,
                    linha.lines().collect(Collectors.toUnmodifiableSet()),
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

        }
        return true;
    }

}
