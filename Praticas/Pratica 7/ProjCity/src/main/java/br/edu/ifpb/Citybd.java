package br.edu.ifpb;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Citybd implements Iterable<City>{
    private Set<City> cityset;
    private Path filepath;

    public Citybd(String path) {
        this.cityset = new TreeSet<>();
        this.filepath = this.buildfilepath(Paths.get(path));
    }

    private Path buildfilepath(Path path) {

        try{
            List<String> linhas = Files.readAllLines(path, Charset.defaultCharset());

            for (String linha : linhas) {
                String lin[] = linha.split(", ");
                this.cityset.add(new City(lin[0], lin[1], lin[2]));
            }
            return path;

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo :(");
        }
        return null;
    }

    public boolean writesetofcities(String destino) {
        try {
            Path saida = Paths.get(destino);
            List<City> a = List.copyOf(this.cityset);
            Files.write(saida,
                        cityset.stream().map(City :: toString).collect(Collectors.toSet()),
                        Charset.defaultCharset(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException o) {
            System.err.println("Erro ao escrever o arquivo.");
            return false;
        }
    }

    @Override
    public Iterator<City> iterator() {
        return cityset.iterator();
    }
}
