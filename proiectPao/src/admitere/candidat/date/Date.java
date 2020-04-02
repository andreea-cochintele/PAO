package admitere.candidat.date;

public class Date {
    private String data_nasterii;
    private String CNP;

    public Date() {
    }

    public Date(String data_nasterii, String CNP) {
        this.data_nasterii = data_nasterii;
        this.CNP = CNP;
    }

    public String getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(String data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
}
