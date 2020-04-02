package admitere.toate;

public class Specializari {
    private int ani_studii;
    private String nume_specializare;
    private int numar_locuri;
    private double ultima_medie;

    public Specializari() {
    }

    public Specializari(int ani_studii, String nume_specializare, int numar_locuri) {
        this.ani_studii = ani_studii;
        this.nume_specializare = nume_specializare;
        this.numar_locuri = numar_locuri;
    }

    public int getAni_studii() {
        return ani_studii;
    }

    public void setAni_studii(int ani_studii) {
        this.ani_studii = ani_studii;
    }

    public String getNume_specializare() {
        return nume_specializare;
    }

    public void setNume_specializare(String nume_specializare) {
        this.nume_specializare = nume_specializare;
    }

    public int getNumar_locuri() {
        return numar_locuri;
    }

    public void setNumar_locuri(int numar_locuri) {
        this.numar_locuri = numar_locuri;
    }

    public double getUltima_medie() {
        return ultima_medie;
    }

    public void setUltima_medie(double ultima_medie) {
        this.ultima_medie = ultima_medie;
    }
}
