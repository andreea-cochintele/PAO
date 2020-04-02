package admitere.facultate;


import admitere.facultate.sub.Specializare;

public class Optiuni {
    private String nume_facultate;
    private Specializare profil;

    public Optiuni() {
    }

    public Optiuni(String nume_facultate, Specializare profil) {
        this.nume_facultate = nume_facultate;
        this.profil = profil;
    }

    public String getNume_facultate() {
        return nume_facultate;
    }

    public void setNume_facultate(String nume_facultate) {
        this.nume_facultate = nume_facultate;
    }

    public Specializare getProfil() {
        return profil;
    }

    public void setProfil(Specializare profil) {
        this.profil = profil;
    }

}
