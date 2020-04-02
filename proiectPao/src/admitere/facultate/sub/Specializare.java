package admitere.facultate.sub;

public class Specializare {
    private String nume_profil;
    private String situatie_admitere;
    private double medie_examen;
    private double medie_admitere;

    public double getMedie_admitere() {
        return medie_admitere;
    }

    public void setMedie_admitere(double medie_admitere) {
        this.medie_admitere = medie_admitere;
    }

    public double getMedie_examen() {
        return medie_examen;
    }

    public Specializare() {
    }

    public Specializare(String nume_profil, String situatie_admitere, double medie_examen) {
        this.nume_profil = nume_profil;
        this.situatie_admitere = situatie_admitere;
        this.medie_examen = medie_examen;
    }

    public void setMedie_examen(double medie_examen) {
        this.medie_examen = medie_examen;
    }

    public String getSituatie_admitere() {
        return situatie_admitere;
    }

    public void setSituatie_admitere(String situatie_admitere) {
        this.situatie_admitere = situatie_admitere;
    }


    public String getNume_profil() {
        return nume_profil;
    }

    public void setNume_profil(String nume_profil) {
        this.nume_profil = nume_profil;
    }


}
