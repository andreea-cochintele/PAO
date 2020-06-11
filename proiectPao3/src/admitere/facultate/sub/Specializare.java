package admitere.facultate.sub;

public class Specializare {
    private String numeProfil;
    private String situatieAdmitere;
    private double medieExamen;
    private double medieAdmitere;

    public double getMedieAdmitere() {
        return medieAdmitere;
    }

    public void setMedieAdmitere(double medieAdmitere) {
        this.medieAdmitere = medieAdmitere;
    }

    public double getMedieExamen() {
        return medieExamen;
    }

    public Specializare() {
    }

    public Specializare(String numeProfil, String situatieAdmitere, double medieExamen) {
        this.numeProfil = numeProfil;
        this.situatieAdmitere = situatieAdmitere;
        this.medieExamen = medieExamen;
    }

    public void setMedieExamen(double medieExamen) {
        this.medieExamen = medieExamen;
    }

    public String getSituatieAdmitere() {
        return situatieAdmitere;
    }

    public void setSituatieAdmitere(String situatieAdmitere) {
        this.situatieAdmitere = situatieAdmitere;
    }


    public String getNumeProfil() {
        return numeProfil;
    }

    public void setNumeProfil(String numeProfil) {
        this.numeProfil = numeProfil;
    }


}
