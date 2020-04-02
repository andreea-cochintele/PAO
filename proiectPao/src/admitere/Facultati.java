package admitere;

import admitere.toate.Specializari;

public class Facultati {
    private String nume_facultate;
    private Specializari alegeri[];
    private int numar_specializari;
    private int numar_total_locuri;

    public Facultati() {
    }

    public Facultati(String nume_facultate, Specializari[] alegeri, int numar_specializari) {
        this.nume_facultate = nume_facultate;
        this.alegeri = alegeri;
        this.numar_specializari = numar_specializari;
    }

    public int getNumar_specializari() {
        return numar_specializari;
    }

    public void setNumar_specializari(int numar_specializari) {
        this.numar_specializari = numar_specializari;
    }

    public int getNumar_total_locuri() {
        return numar_total_locuri;
    }

    public void setNumar_total_locuri(int numar_total_locuri) {
        this.numar_total_locuri = numar_total_locuri;
    }

    public String getNume_facultate() {
        return nume_facultate;
    }

    public void setNume_facultate(String nume_facultate) {
        this.nume_facultate = nume_facultate;
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
