package admitere.candidat.date;

public class IstoricScolar {
    private String liceu;
    private double medieLiceu;


    public IstoricScolar(String liceu, double medieLiceu, String facultate, double medie_facultate) {
        this.liceu = liceu;
        this.medieLiceu = medieLiceu;

    }

    public IstoricScolar() {
    }

    public IstoricScolar(String liceu, double medieLiceu) {
        this.liceu = liceu;
        this.medieLiceu = medieLiceu;
    }

    public String getLiceu() {
        return liceu;
    }

    public void setLiceu(String liceu) {
        this.liceu = liceu;
    }

    public double getMedieLiceu() {
        return medieLiceu;
    }

    public void setMedieLiceu(double medieLiceu) {
        this.medieLiceu = medieLiceu;
    }

}
