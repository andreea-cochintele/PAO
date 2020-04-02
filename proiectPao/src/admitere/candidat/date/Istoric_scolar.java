package admitere.candidat.date;

public class Istoric_scolar {
    private String liceu;
    private double medie_liceu;


    public Istoric_scolar(String liceu, double medie_liceu, String facultate, double medie_facultate) {
        this.liceu = liceu;
        this.medie_liceu = medie_liceu;

    }

    public Istoric_scolar() {
    }

    public Istoric_scolar(String liceu, double medie_liceu) {
        this.liceu = liceu;
        this.medie_liceu = medie_liceu;
    }

    public String getLiceu() {
        return liceu;
    }

    public void setLiceu(String liceu) {
        this.liceu = liceu;
    }

    public double getMedie_liceu() {
        return medie_liceu;
    }

    public void setMedie_liceu(double medie_liceu) {
        this.medie_liceu = medie_liceu;
    }

}
