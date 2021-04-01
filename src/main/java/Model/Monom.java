package Model;

public class Monom {
    private double coeficient;
    private int putere;
    public Monom(double coeficient, int putere)
    {
        this.putere = putere;
        this.coeficient = coeficient;
    }
    public int getPutere()
    {
        return this.putere;
    }
    public double getCoeficient()
    {
        return this.coeficient;
    }
    public void setCoeficient(double coeficient)
    {
        this.coeficient = coeficient;
    }
    public void setPutere(int putere)
    {
        this.putere = putere;
    }

    @Override
    public String toString() {
        if(coeficient > 0)
            return "+" + coeficient + "x^" + putere;
        return + coeficient + "x^" + putere;
    }



}
