package admitere;
import admitere.candidat.*;
import admitere.candidat.date.Adresa;
import admitere.candidat.date.Contact;
import admitere.candidat.date.Date;
import admitere.candidat.date.IstoricScolar;
import admitere.facultate.*;
import admitere.facultate.sub.Specializare;
import admitere.toate.Specializari;

import java.io.IOException;
import java.util.Scanner;

public class Admitere {
    protected Candidat[] candidat = new Candidat[105];
    protected int numarCandidati;
    protected Facultati[] facultati = new Facultati[105];
    protected  int numarFacultati;

    public Candidat[] getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat[] candidat) {
        this.candidat = candidat;
    }

    public int getNumarCandidati() {
        return numarCandidati;
    }

    public Facultati[] getFacultati() {
        return facultati;
    }

    public void setFacultati(Facultati[] facultati) {
        this.facultati = facultati;
    }

    public int getNumarFacultati() {
        return numarFacultati;
    }

    public void setNumarFacultati(int numarFacultati) {
        this.numarFacultati = numarFacultati;
    }

    public void setnumarCandidati(int numarCandidati) {
        this.numarCandidati = numarCandidati;
    }

    public Candidat adaugaCandidat() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nume de familie:");
        String nume= scan.next();
        System.out.println("Prenume:");
        String prenume=scan.next();

        System.out.println("Mail:");
        String mail = scan.next();
        System.out.println("Telefon:");
        String telefon = scan.next();
        Contact contact = new Contact(mail,telefon);

        System.out.println("Localitate:");
        String localitate = scan.next();
        System.out.println("Judet:");
        String judet = scan.next();
        System.out.println("Tara:");
        String tara = scan.next();
        Adresa adresa1 = new Adresa(localitate,judet,tara);

        System.out.println("Data nasterii:");
        String data = scan.next();
        System.out.println("CNP");
        String CNP = scan.next();
        Date date;
        date = new Date(CNP,data);

        System.out.println("Liceu:");
        String liceu = scan.next();
        System.out.println("Medie liceu:");
        double mediel = scan.nextDouble();
        IstoricScolar istoric = new IstoricScolar(liceu,mediel);

        DatePersonale Date_stud = new DatePersonale(contact,adresa1,date,nume,prenume,istoric);
        this.numarCandidati++;
        int numarCandidati = this.numarCandidati;
        candidat[numarCandidati] = new Candidat();
        candidat[numarCandidati].setDateCandidat(Date_stud);
        candidat[numarCandidati].setID(numarCandidati);
        System.out.println("Cate optiuni?");
        int optiuni = Integer.parseInt(scan.next());
        int nr = 0;
        Optiuni[] Opt= new Optiuni[105];
        candidat[numarCandidati].setNumarOptiuni(optiuni);
        while(nr < optiuni){
            nr++;
            System.out.println("Nume facultate:");
            String numef = scan.next();
            System.out.println("Nume specializare:");
            String numes = scan.next();
            System.out.println("Medie examen:");
            double mediee = scan.nextDouble();
            Specializare Spec = new Specializare(numes,"-",mediee);
            Opt[nr] = new Optiuni();
            Opt[nr].setProfil(Spec);
            Opt[nr].setNumeFacultate(numef);

        }
        candidat[numarCandidati].setOptiuni(Opt);
        Candidat candidat= new Candidat(Date_stud,numarCandidati,Opt,optiuni);
        this.candidat[numarCandidati] = candidat;
        this.numarCandidati = numarCandidati;
        //adauga in csv
        Scriere.adaugaCandidat(this.candidat[numarCandidati]);
        return this.candidat[numarCandidati];

    }
    //afiseaza candidatii cu prima optiune a acestora
    public void afiseazaCandidati(Candidat[] candidat) {
        int i;
        for (i = 1; i <= this.numarCandidati; i++) {
            System.out.print("ID: ");
            System.out.println(candidat[i].getID());
            System.out.print("Nume:");
            System.out.println(candidat[i].getDateCandidat().getNume());
            System.out.print("Prenume:");
            System.out.println(candidat[i].getDateCandidat().getPrenume());
            System.out.print("Prima optiune:");
            System.out.println(candidat[i].getOptiuni1(1).getNumeFacultate());
            System.out.println();
        }
    }


     //afiseaza candidatii unei facultati date de la tastatura
    public void afiseazaCandidatiFacultate(Candidat[] candidat,String nume_facultate) {
        for (int i = 1; i <= this.numarCandidati; i++) {
            for (int j = 1; j <= candidat[i].getNumarOptiuni(); j++) {
                if (candidat[i].getOptiuni1(j).getNumeFacultate().equals(nume_facultate)) {
                    System.out.print("ID: ");
                    System.out.println(candidat[i].getID());
                    System.out.print("Nume:");
                    System.out.println(candidat[i].getDateCandidat().getNume());
                    System.out.print("Prenume:");
                    System.out.println(candidat[i].getDateCandidat().getPrenume());
                    System.out.print("Nota:");
                    System.out.println(candidat[i].getOptiuni1(j).getProfil().getMedieExamen());
                    System.out.println();
                }
            }
        }
    }

    //calculam media de admitere
    public Double medieAdmitere(double medie_examen,double medie_bac){
        // Media de admitere va fi 25% medie bac, 75% medie examen
        double medie = ((25*medie_bac)/100) + ((75*medie_examen)/100);
        return medie;

    }

    //seteam media de admitere pentru toti candidatii
    public Candidat[] calculeazaMedieAdmitere(Candidat[] candidat){
        for(int i=1;i<=this.getNumarCandidati();i++){
            for(int j=1;j<=candidat[i].getNumarOptiuni();j++){
            double mediel= candidat[i].getDateCandidat().getIstoric().getMedieLiceu();
            double mediee= candidat[i].getOptiuni1(j).getProfil().getMedieExamen();
            double medie =  medieAdmitere(mediee,mediel);
            candidat[i].getOptiuni1(j).getProfil().setMedieAdmitere(medie);
        }
        }
        this.candidat = candidat;
        return this.candidat;
    }
   //afiseaza mediile de admitere ale candidatilor pentru o facultate data
    public void afiseazaMedii(Candidat[] candidat,String nume_facultate) {
        for (int i = 1; i <= this.numarCandidati; i++) {
            for (int j = 1; j <= candidat[i].getNumarOptiuni(); j++) {
                if (candidat[i].getOptiuni1(j).getNumeFacultate().equals(nume_facultate)) {
                    System.out.print("ID: ");
                    System.out.println(candidat[i].getID());
                    System.out.print("Nume: ");
                    System.out.println(candidat[i].getDateCandidat().getNume());
                    System.out.print("Prenume: ");
                    System.out.println(candidat[i].getDateCandidat().getPrenume());
                    System.out.print("Specializare: ");
                    System.out.println(candidat[i].getOptiuni1(j).getProfil().getNumeProfil());
                    System.out.print("Medie: ");
                    System.out.println(candidat[i].getOptiuni1(j).getProfil().getMedieAdmitere());

                }
            }
        }
    }
     //lista cu facultatite si specializarile acestora plus numarul de locuri pentru fiecare
    public void afiseazaFacultatiLocuri(Facultati[] f,int nr){
        for(int i = 1; i <= nr; i++){
            System.out.print(i);
            System.out.println(". ");
            System.out.println(f[i].getNumeFacultate());
            System.out.println("Specializari: ");
            for(int j = 1; j <= f[i].getNumarSpecializari(); j++) {
                System.out.println(f[i].getAlegeri(j).getNumeSpecializare());
                System.out.println("Locuri:");
                System.out.println(f[i].getAlegeri(j).getNumarLocuri());
            }
        }
    }
      //calculeaza numar total locuri
    public int calculeazaLocuri(Facultati f){
        int nr=0;
        for(int i = 1; i <= f.getNumarSpecializari(); i++){
            nr += f.getAlegeri(i).getNumarLocuri();
        }
        return nr;
    }



    //afiseaza numar total locuri
     public void afiseazaNumarTotalLocuri(Facultati[] f, int nr){
        for(int i=1;i<=nr;i++){
            f[i].setNumarTotalLocuri(calculeazaLocuri(f[i]));
            System.out.println(f[i].getNumeFacultate());
            System.out.println("Numar locuri:");
            System.out.println(f[i].getNumarTotalLocuri());
        }
     }

     //afisam candidatii respinsi
     public void afiseazaRespinsi(Candidat[] candidat) {
         for (int i = 1; i <= this.numarCandidati; i++) {
             for (int j = 1; j <= candidat[i].getNumarOptiuni(); j++) {
                 if (candidat[i].getOptiuni1(j).getProfil().getMedieAdmitere() < 5.0) {
                     System.out.print("ID: ");
                     System.out.println(candidat[i].getID());
                     System.out.print("Nume:");
                     System.out.println(candidat[i].getDateCandidat().getNume());
                     System.out.print("Prenume:");
                     System.out.println(candidat[i].getDateCandidat().getPrenume());
                     System.out.println("Respins:");
                     System.out.print(candidat[i].getOptiuni1(j).getNumeFacultate());
                     System.out.print(", specializarea:");
                     System.out.println(candidat[i].getOptiuni1(j).getProfil().getNumeProfil());
                     System.out.println();
                 }
             }
         }
     }


    public void afiseazaCandidatiSpecializare(Candidat[] candidat,String nume) {
        for (int i = 1; i <= this.numarCandidati; i++) {
            for (int j = 1; j <= candidat[i].getNumarOptiuni(); j++) {
                if (candidat[i].getOptiuni1(j).getProfil().getNumeProfil().equals(nume)) {
                    System.out.print("ID: ");
                    System.out.println(candidat[i].getID());
                    System.out.print("Nume:");
                    System.out.println(candidat[i].getDateCandidat().getNume());
                    System.out.print("Prenume:");
                    System.out.println(candidat[i].getDateCandidat().getPrenume());
                    System.out.print("Nota:");
                    System.out.println(candidat[i].getOptiuni1(j).getProfil().getMedieExamen());
                    System.out.println();
                }
            }
        }
    }

   //adauga la inceputul proramului 3 candidati
    public Candidat adaugate(int numarCandidati){
        String nume= "Ionescu";
        String prenume="Marius";
        String mail = "ionescu.marius@gmail.com";
        String telefon = "0725846356";
        Contact contact = new Contact(mail,telefon);

        String localitate = "Suceava";
        String judet = "Suceava";
        String tara = "Romania";
        Adresa adresa1 = new Adresa(localitate,judet,tara);

        String data = "05/03/1999";
        String CNP = "1990305373537";
        Date date;
        date = new Date(CNP,data);

        String liceu = "Liceu_nr.67";
        double mediel = 9.4;
        String facultate = " ";
        double medief = 0;
        IstoricScolar istoric = new IstoricScolar(liceu,mediel,facultate,medief);

        DatePersonale Date_stud = new DatePersonale(contact,adresa1,date,nume,prenume,istoric);

        numarCandidati++;
        this.candidat= new Candidat[105];
        this.candidat[numarCandidati]= new Candidat();
        this.candidat[numarCandidati]= new Candidat();
        this.candidat[numarCandidati].setDateCandidat(Date_stud);
        this.candidat[numarCandidati].setID(numarCandidati);
        int optiun = 1;
        int nr = 0;
        Optiuni[] Opt =new Optiuni[105];
        candidat[numarCandidati].setNumarOptiuni(optiun);
        while(optiun != 0){
            nr++;
            String numef = " Facultatea_de_matematica_si_informatica";
            String numes = " Informatica";
            double mediee = 6.5;
            Specializare Spec = new Specializare(numes,"-",mediee);
            Opt[nr]=new Optiuni(numef,Spec);
            optiun--;

        }
        candidat[numarCandidati].setOptiuni(Opt);
        this.candidat[numarCandidati] = candidat[numarCandidati];
        this.numarCandidati = numarCandidati;
         nume= "Popescu";
        prenume="Ioana";
        mail = "popescu.ioana@gmail.com";
         telefon = "0725786356";
         contact = new Contact(mail,telefon);

         localitate = "Ramnicu-Valcea";
         judet = "Valcea";
         tara = "Romania";
         adresa1 = new Adresa(localitate,judet,tara);

         data = "08/09/1999";
         CNP = "1990908348537";
        date = new Date(CNP,data);

         liceu = "Liceu_1nr.40";
         mediel = 6.2;
         facultate = " ";
         medief = 0;
         istoric = new IstoricScolar(liceu,mediel,facultate,medief);

         Date_stud = new DatePersonale(contact,adresa1,date,nume,prenume,istoric);

         numarCandidati ++;
         this.candidat[numarCandidati]= new Candidat();
        this.candidat[numarCandidati].setDateCandidat(Date_stud);
        this.candidat[numarCandidati].setID(numarCandidati);
        optiun = 1;
         nr = 0;
         Opt =new Optiuni[105];
        candidat[numarCandidati].setNumarOptiuni(optiun);
        while(optiun != 0){
            nr++;
            String numef = " Facultatea_de_matematica_si_informatica";
            String numes = " Informatica";
            double mediee = 2.2;
            Specializare Spec = new Specializare(numes,"-",mediee);

            Opt[nr]=new Optiuni(numef,Spec);
            optiun--;

        }
        candidat[numarCandidati].setOptiuni(Opt);
        this.candidat[numarCandidati] = candidat[numarCandidati];
        this.numarCandidati = numarCandidati;
        nume= "Popa";
        prenume="Raluca";
        mail = "popa.raluca@gmail.com";
        telefon = "0725778896";
        contact = new Contact(mail,telefon);

        localitate = "Bucuresti";
        judet = "Bucuresti";
        tara = "Romania";
        adresa1 = new Adresa(localitate,judet,tara);

        data = "02/01/2000";
        CNP = "2000102348457";
        date = new Date(CNP,data);

        liceu = "Liceu_nr.73";
        mediel = 9.0;
        facultate = " ";
        medief = 0;
        istoric = new IstoricScolar(liceu,mediel,facultate,medief);

        Date_stud = new DatePersonale(contact,adresa1,date,nume,prenume,istoric);

        numarCandidati ++;
        this.candidat[numarCandidati]= new Candidat();
        this.candidat[numarCandidati].setDateCandidat(Date_stud);
        this.candidat[numarCandidati].setID(numarCandidati);
        optiun = 1;
        nr = 0;
        Opt =new Optiuni[105];
        candidat[numarCandidati].setNumarOptiuni(optiun);
        while(optiun != 0){
            nr++;
            String numef = " Facultatea_de_biologie";
            String numes = "Biochimie";
            double mediee = 8.2;
            Specializare Spec = new Specializare(numes,"-",mediee);

            Opt[nr]=new Optiuni(numef,Spec);
            optiun--;

        }
        candidat[numarCandidati].setOptiuni(Opt);
        this.candidat[numarCandidati] = candidat[numarCandidati];
        this.numarCandidati = numarCandidati;
        return this.candidat[numarCandidati];
    }


    //adauga la inceputul programului 2 facultati a cate 2 specializari
    public Facultati[] adaugate1(int numarFacultati){
        String nume_specializare = "Informatica";
        int numar_ani_stud = 3;
        int numar = 20;
        String nume_fac = " Facultatea_de_matematica_si_informatica";

        Specializari[] Spec = new Specializari[10];
        Spec[1]= new Specializari(numar_ani_stud,nume_specializare,numar);
        nume_specializare = "Matematica";
        numar_ani_stud = 3;
        numar = 10;
        Spec[2]= new Specializari(numar_ani_stud,nume_specializare,numar);
        int numar_spec = 2;
        this.numarFacultati = numarFacultati;
        this.numarFacultati ++;
        Facultati fac = new Facultati(nume_fac,Spec, numar_spec);
        this.facultati[this.numarFacultati] = fac;

         nume_specializare = "Biologie";
         numar_ani_stud = 3;
         numar = 15;
         nume_fac = " Facultatea_de_biologie";

         Spec = new Specializari[10];
        Spec[1]= new Specializari(numar_ani_stud,nume_specializare,numar);
        nume_specializare = "Biochimie";
        numar_ani_stud = 3;
        numar = 5;
        Spec[2]= new Specializari(numar_ani_stud,nume_specializare,numar);
        numar_spec = 2;
        this.numarFacultati ++;
        fac = new Facultati(nume_fac,Spec, numar_spec);
        this.facultati[this.numarFacultati] = fac;

        return this.facultati;

    }
    //citeste din CSV la pornirea programului
    public Facultati[] readCsvFacultate(String File, int numarFacultati){
        if(numarFacultati == 0)
            this.facultati = new Facultati[105];
        numarFacultati++;
        this.numarFacultati= numarFacultati;
        Citire obiect = new Citire();
        this.facultati[this.numarFacultati] = new Facultati();
        this.facultati[this.numarFacultati] = obiect.citireFacultatiFile(File);
        return this.facultati;
    }
    //citeste din CSV la pornirea programului
    public Candidat[] readCsvCandidati(String File, int numarCandidati) {
        this.candidat = new Candidat[105];
        Citire obiect = new Citire();
        Candidat[] temp = new Candidat[105];
        temp[1] = new Candidat();
        temp = obiect.citireCandidatiFile(File);
        this.numarCandidati = numarCandidati;
        while (true) {
            this.numarCandidati++;
            this.candidat[this.numarCandidati] = new Candidat();
            this.candidat[this.numarCandidati] = temp[this.numarCandidati];
            if(temp[this.numarCandidati + 1].getID() == -1){
                break;
            }
        }
        return this.candidat;
    }
}
