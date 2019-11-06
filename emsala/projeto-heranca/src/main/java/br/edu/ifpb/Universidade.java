package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Universidade {

    List<Funcionário> lista = new ArrayList<>();

    public boolean adicionarFuncionário(Funcionário func) {
        if (Objects.isNull(func)) return false;

        for (Funcionário temp : lista) {
            if (temp.getMatrícula() == func.getMatrícula()){ return false; } //clone!
        }

        //pode adicionar
        return lista.add(func);
    }
}
