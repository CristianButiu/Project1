package Model;

import Model.Monom;
import Model.Polinom;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii {
    public Operatii()
    {

    }
    public Monom inmultireMonom(Monom m1, Monom m2)
    {
        Monom monomNou = new Monom(m1.getCoeficient() * m2.getCoeficient(), m1.getPutere() + m2.getPutere());
        return monomNou;
    }
    public Monom impartireMonom(Monom m1, Monom m2)
    {
        Monom monomNou = new Monom(m1.getCoeficient() / m2.getCoeficient(), m1.getPutere() - m2.getPutere());
        return monomNou;
    }
    public Polinom stringToPolinom(String s) {
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(s);
        Polinom returnat = new Polinom();
        try {
            while (matcher.find()) {
                String monom = matcher.group(1);
                String[] parti = monom.split("\\^");
                String pparte = parti[0];
                pparte = pparte.substring(0, pparte.length() - 1);
                String sparte = parti[1];
                Monom m = new Monom(Double.parseDouble(pparte), Integer.parseInt(sparte));
                returnat.adaugaMonom(m);

            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Introduceti polinoame valide");
        }
        return returnat;
    }
    public  Polinom adunareSauScadare(Polinom p1, Polinom p2, int nr)
    {
        Polinom intermediar = new Polinom();
        int i = 0, j = 0;
        while(i < p1.getListaMonoame().size() && j < p2.getListaMonoame().size())
        {
            Monom m1 = p1.getListaMonoame().get(i);
            Monom m2 = p2.getListaMonoame().get(j);
            Monom m3 = new Monom(0, m2.getPutere());
            if(nr == 0)
                m3.setCoeficient(m1.getCoeficient() + m2.getCoeficient());
            else
                m3.setCoeficient(m1.getCoeficient() - m2.getCoeficient());
            if(m1.getPutere() > m2.getPutere())
            {
                intermediar.adaugaMonom(m1);
                i++;
            }
            if(m1.getPutere() == m2.getPutere())
            {
                if(m3.getCoeficient() != 0)
                    intermediar.adaugaMonom(m3);
                i++;
                j++;
            }
            if(m1.getPutere() < m2.getPutere())
            {
                if(nr == 1)
                    m2.setCoeficient(-m2.getCoeficient());
                intermediar.adaugaMonom(m2);
                j++;
            }
        }
        while(i < p1.getListaMonoame().size()) {
            intermediar.adaugaMonom(p1.getListaMonoame().get(i));
            i++;
        }
        while(j < p2.getListaMonoame().size()) {
            if(nr == 1)
                p2.getListaMonoame().get(j).setCoeficient(-p2.getListaMonoame().get(j).getCoeficient());
            intermediar.adaugaMonom(p2.getListaMonoame().get(j));
            j++;
        }
        return intermediar;
    }
    public  Polinom  integrare(Polinom p)
    {
        Polinom intermediar = new Polinom();
        for(Monom monom:p.getListaMonoame())
        {

            Monom nou = new Monom(-1, -1);
            nou.setCoeficient(monom.getCoeficient() * 1.0 / (monom.getPutere() + 1));
            nou.setPutere(monom.getPutere() + 1);
            intermediar.adaugaMonom(nou);
        }
        return intermediar;
    }

    public Polinom derivare(Polinom p) {
        Polinom intermediar = new Polinom();
        for (Monom monom : p.getListaMonoame()) {
            Monom monomNou = new Monom(-1, -1);
            monomNou.setCoeficient(monom.getCoeficient() * (monom.getPutere()));
            monomNou.setPutere(monom.getPutere() - 1);
            if (monomNou.getPutere() >= 0)
                intermediar.adaugaMonom(monomNou);

        }
        return intermediar;
    }


    public Polinom inmultire(Polinom p1, Polinom p2)
    {

        Polinom rezultat = new Polinom();
        for(Monom monom1:p1.getListaMonoame()) {
            Polinom intermediar = new Polinom();
            for (Monom monom2 : p2.getListaMonoame()) {
                intermediar.adaugaMonom(inmultireMonom(monom1, monom2));
            }
            rezultat = adunareSauScadare(rezultat, intermediar, 0);
        }
        return rezultat;
    }
    public ArrayList<Polinom> impartire(Polinom p1, Polinom p2)
    {
        ArrayList<Polinom> listaPolinoame = new ArrayList<>();
        Polinom rezultat = new Polinom();
        Polinom rest = new Polinom();
        while(true)
        {
            if(p1.getListaMonoame().get(0).getPutere() < p2.getListaMonoame().get(0).getPutere())
                break;
            else
            {
                Polinom monomy = new Polinom();
                Monom nou = impartireMonom(p1.getListaMonoame().get(0), p2.getListaMonoame().get(0));
                rezultat.adaugaMonom(nou);
                monomy.adaugaMonom(nou);
                p1 = adunareSauScadare(p1, inmultire(monomy, p2), 1);
            }
        }
        rest = adunareSauScadare(p1, inmultire(rezultat, p2), 1);
        listaPolinoame.add(rezultat);
        listaPolinoame.add(p1);
        return listaPolinoame;
    }


}
