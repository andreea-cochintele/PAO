package admitere;

import admitere.toate.Specializari;

public class Facultati {
    private String numeFacultate;
    private Specializari alegeri[];
    private int numarSpecializari;
    private int numarTotalLocuri;

    public Facultati() {
    }

    public Facultati(String numeFacultate, Specializari[] alegeri, int numarSpecializari) {
        this.numeFacultate = numeFacultate;
        this.alegeri = alegeri;
        this.numarSpecializari = numarSpecializari;
    }

    public int getNumarSpecializari() {
        return numarSpecializari;
    }

    public void setNumarSpecializari(int numarSpecializari) {
        this.numarSpecializari = numarSpecializari;
    }

    public int getNumarTotalLocuri() {
        return numarTotalLocuri;
    }

    public void setNumarTotalLocuri(int numarTotalLocuri) {
        this.numarTotalLocuri = numarTotalLocuri;
    }

    public String getNumeFacultate() {
        return numeFacultate;
    }

    public void setNumeFacultate(String numeFacultate) {
        this.numeFacultate = numeFacultate;
    }

    public Specializari[] getAlegeri() {
        return alegeri;
    }
    public Specializari getAlegeri(int i) {
        return alegeri[i];
    }
    public void setAlegeri(Specializari[] alegeri) {
        this.alegeri = alegeri;
    }

}
