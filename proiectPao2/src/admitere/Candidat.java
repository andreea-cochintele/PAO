package admitere;

import admitere.candidat.DatePersonale;
import admitere.facultate.Optiuni;

public class Candidat {
    private DatePersonale dateCandidat;
    private int ID ;
    private Optiuni[] optiuni;
    private int numarOptiuni;

    public Candidat() {
    }

    public Candidat(DatePersonale dateCandidat, int ID, Optiuni[] optiuni, int numarOptiuni) {
        this.dateCandidat = dateCandidat;
        this.ID = ID;
        this.optiuni = optiuni;
        this.numarOptiuni = numarOptiuni;
    }
    public int getNumarOptiuni() {
        return numarOptiuni;
    }

    public void setNumarOptiuni(int numarOptiuni) {
        this.numarOptiuni = numarOptiuni;
    }

    public DatePersonale getDateCandidat() {
        return dateCandidat;
    }

    public void setDateCandidat(DatePersonale dateCandidat) {
        this.dateCandidat = dateCandidat;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Optiuni[] getOptiuni() {
        return optiuni;
    }

    public void setOptiuni(Optiuni[] optiuni) {
        this.optiuni = optiuni;
    }
    public void setOptiuni1(Optiuni optiuni,int i){
        this.optiuni[i] = optiuni;
    }
    public Optiuni getOptiuni1(int i) {
        return optiuni[i];
    }
}
