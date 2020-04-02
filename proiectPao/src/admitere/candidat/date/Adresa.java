package admitere.candidat.date;

public class Adresa {
    private String localitate;
    private String judet;
    private String tara;

    public Adresa() {
    }

    public Adresa(String localitate, String judet, String tara) {
        this.localitate = localitate;
        this.judet = judet;
        this.tara = tara;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }
}
