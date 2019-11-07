package br.edu.ifpb;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class citybd {
    private Set<City> cityset;
    private Path filepath;

    public citybd() {
        this.cityset = new HashSet<>();
        this.filepath = this.buildfilepath();
    }

    private Path buildfilepath() {

    }
}
