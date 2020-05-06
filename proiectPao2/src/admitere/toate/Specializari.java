package admitere.toate;

import admitere.Facultati;

public class Specializari extends Facultati {
    private int aniStudii;
    private String numeSpecializare;
    private int numarLocuri;
    private double ultimaMedie;

    public Specializari() {
    }

    public Specializari(int aniStudii, String numeSpecializare, int numeLocuri) {
        this.aniStudii = aniStudii;
        this.numeSpecializare = numeSpecializare;
        this.numarLocuri = numeLocuri;
    }

    public int getAniStudii() {
        return aniStudii;
    }

    public void setAniStudii(int aniStudii) {
        this.aniStudii = aniStudii;
    }

    public String getNumeSpecializare() {
        return numeSpecializare;
    }

    public void setNumeSpecializare(String numeSpecializare) {
        this.numeSpecializare = numeSpecializare;
    }

    public int getNumarLocuri() {
        return numarLocuri;
    }

    public void setNumarLocuri(int numeLocuri) {
        this.numarLocuri = numeLocuri;
    }

    public double getUltimaMedie() {
        return ultimaMedie;
    }

    public void setUltimaMedie(double ultimaMedie) {
        this.ultimaMedie = ultimaMedie;
    }
}
