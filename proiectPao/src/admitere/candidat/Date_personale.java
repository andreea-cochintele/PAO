package admitere.candidat;

import admitere.candidat.date.Adresa;
import admitere.candidat.date.Contact;
import admitere.candidat.date.Date;
import admitere.candidat.date.Istoric_scolar;


public class Date_personale {
    private Contact contact1;
    private Adresa adresa1;
    private Date date1;
    protected String nume;
    protected String prenume;
    private Istoric_scolar istoric;

    public Date_personale() {
    }

    public Date_personale(Contact contact1, Adresa adresa1, Date date1, String nume, String prenume, Istoric_scolar istoric) {
        this.contact1 = contact1;
        this.adresa1 = adresa1;
        this.date1 = date1;
        this.nume = nume;
        this.prenume = prenume;
        this.istoric = istoric;
    }

    public Contact getContact1() {
        return contact1;
    }

    public void setContact1(Contact contact1) {
        this.contact1 = contact1;
    }

    public Adresa getAdresa1() {
        return adresa1;
    }

    public void setAdresa1(Adresa adresa1) {
        this.adresa1 = adresa1;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Istoric_scolar getIstoric() {
        return istoric;
    }

    public void setIstoric(Istoric_scolar istoric) {
        this.istoric = istoric;
    }
}
