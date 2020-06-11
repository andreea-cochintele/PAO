package admitere.candidat.date;

public class Date {
    private String dataNasterii;
    private String CNP;

    public Date() {
    }

    public Date(String dataNasterii, String CNP) {
        this.dataNasterii = dataNasterii;
        this.CNP = CNP;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
}
