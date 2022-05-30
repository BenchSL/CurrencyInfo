package projectfiles.currencyinfo.Models;

public class CurrencyModel
{
    //private fields, not meant for user interaction
    String datum;
    String oznaka;
    String sifra;
    double value;


    //public properties made for user interaction
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "datum='" + datum + '\'' +
                ", oznaka='" + oznaka + '\'' +
                ", sifra='" + sifra + '\'' +
                ", value=" + value +
                '}';
    }
}
