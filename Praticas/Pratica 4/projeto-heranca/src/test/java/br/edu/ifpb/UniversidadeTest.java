package br.edu.ifpb;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class UniversidadeTest
{
    @Test
    public void adicionarFuncionarioDandoCerto(){
        //desde que

        Universidade u = new Universidade();

        // quando

        Professor p1 = new Professor(555,"ana",1200.99, 20);
        Professor pClone = new Professor(555,"ana",1200.99, 20);
        Gerente g1 = new Gerente(777,"pedro",3000,500);
        Gerente gnull = null;

        // entao

        Assert.assertTrue(u.adicionarFuncionário(p1));
        Assert.assertTrue(u.adicionarFuncionário(g1));
        Assert.assertFalse(u.adicionarFuncionário(pClone));
        Assert.assertFalse(u.adicionarFuncionário(gnull));
    }


}
