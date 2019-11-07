package br.edu.ifpb;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Citybd {
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

    @Override
    public String toString() {
        for (City city : cityset) {
            System.out.println(city.toString());
        }
        return null;
    }
}
