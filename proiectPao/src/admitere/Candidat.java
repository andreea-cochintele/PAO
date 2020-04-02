package admitere;

import admitere.candidat.Date_personale;
import admitere.facultate.Optiuni;

public class Candidat {
    private Date_personale date_candidat;
    private int ID ;
    private Optiuni optiuni[] ;
    private int numar_optiuni;

    public Candidat() {
    }

    public Candidat(Date_personale date_candidat, int ID, Optiuni[] optiuni, int numar_optiuni) {
        this.date_candidat = date_candidat;
        this.ID = ID;
        this.optiuni = optiuni;
        this.numar_optiuni = numar_optiuni;
    }
    public int getNumar_optiuni() {
        return numar_optiuni;
    }

    public void setNumar_optiuni(int numar_optiuni) {
        this.numar_optiuni = numar_optiuni;
    }

    public Date_personale getDate_candidat() {
        return date_candidat;
    }

    public void setDate_candidat(Date_personale date_candidat) {
        this.date_candidat = date_candidat;
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
