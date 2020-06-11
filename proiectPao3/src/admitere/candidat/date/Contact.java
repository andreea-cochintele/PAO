package admitere.candidat.date;

public class Contact {
    private String mail;
    private String telefon;

    public Contact() {
    }

    public Contact(String mail, String telefon) {
        this.mail = mail;
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
