package admitere.facultate;


import admitere.facultate.sub.Specializare;

public class Optiuni {
    private String numeFacultate;
    private Specializare profil;

    public Optiuni() {
    }

    public Optiuni(String numeFacultate, Specializare profil) {
        this.numeFacultate = numeFacultate;
        this.profil = profil;
    }

    public String getNumeFacultate() {
        return numeFacultate;
    }

    public void setNumeFacultate(String numeFacultate) {
        this.numeFacultate = numeFacultate;
    }

    public Specializare getProfil() {
        return profil;
    }

    public void setProfil(Specializare profil) {
        this.profil = profil;
    }

}
