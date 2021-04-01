package Model;

import Model.Monom;

import java.util.ArrayList;
import java.util.List;

public class Polinom{

    private List<Monom> listaMonoame = new ArrayList<>();
    public Polinom()
    {
    }
    public List<Monom> getListaMonoame()
    {
        return listaMonoame;
    };
    public void setListaMonoame(List<Monom>  polinom)
    {
        listaMonoame = polinom;
    }
    public void adaugaMonom(Monom monomNou)
    {
        listaMonoame.add(monomNou);
    }

    @Override
    public String toString() {
        String afisare = new String();
        for(Monom monom:listaMonoame)
            afisare = afisare + monom.toString();
        return afisare;
    }
}
