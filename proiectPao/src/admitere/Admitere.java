package admitere;
import admitere.candidat.*;
import admitere.candidat.date.Adresa;
import admitere.candidat.date.Contact;
import admitere.candidat.date.Date;
import admitere.candidat.date.Istoric_scolar;
import admitere.facultate.*;
import admitere.facultate.sub.Specializare;
import admitere.toate.Specializari;

import java.util.Scanner;
public class Admitere {
    protected Candidat[] candidat = new Candidat[105];
    protected int numar_candidati;
    protected Facultati[] facultati = new Facultati[105];
    protected  int numar_facultati;

    public Candidat[] getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat[] candidat) {
        this.candidat = candidat;
    }

    public int getNumar_candidati() {
        return numar_candidati;
    }

    public Facultati[] getFacultati() {
        return facultati;
    }

    public void setFacultati(Facultati[] facultati) {
        this.facultati = facultati;
    }

    public int getNumar_facultati() {
        return numar_facultati;
    }

    public void setNumar_facultati(int numar_facultati) {
        this.numar_facultati = numar_facultati;
    }

    public void setNumar_candidati(int numar_candidati) {
        this.numar_candidati = numar_candidati;
    }

    public Candidat adauga_candidat(){
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
        Istoric_scolar istoric = new Istoric_scolar(liceu,mediel);

        Date_personale Date_stud = new Date_personale(contact,adresa1,date,nume,prenume,istoric);
        this.numar_candidati++;
        int numar_candidati = this.numar_candidati;
        candidat[numar_candidati] = new Candidat();
        candidat[numar_candidati].setDate_candidat(Date_stud);
        candidat[numar_candidati].setID(numar_candidati);
        System.out.println("Cate optiuni?");
        int optiuni = scan.nextInt();
        int nr = 0;
        Optiuni[] Opt= new Optiuni[105];
        candidat[numar_candidati].setNumar_optiuni(optiuni);
        while(optiuni != 0){
            optiuni--;
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
            Opt[nr].setNume_facultate(numef);

        }
        Candidat candidat= new Candidat(Date_stud,numar_candidati,Opt,optiuni);
        this.candidat[numar_candidati] = candidat;
        this.numar_candidati = numar_candidati;
        return this.candidat[numar_candidati];

    }
    //afiseaza candidatii cu prima optiune a acestora
    public void afiseaza_candidati(Candidat candidat[]) {
        int i;
        for (i = 1; i <= this.numar_candidati; i++) {
            System.out.print("ID: ");
            System.out.println(candidat[i].getID());
            System.out.print("Nume:");
            System.out.println(candidat[i].getDate_candidat().getNume());
            System.out.print("Prenume:");
            System.out.println(candidat[i].getDate_candidat().getPrenume());
            System.out.print("Prima optiune:");
            System.out.println(candidat[i].getOptiuni1(1).getNume_facultate());
            System.out.println();
        }
    }


     //afiseaza candidatii unei facultati date de la tastatura
    public void afiseaza_candidati_facultate(Candidat[] candidat,String nume_facultate) {
        for (int i = 1; i <= this.numar_candidati; i++) {
            for (int j = 1; j <= candidat[i].getNumar_optiuni(); j++) {
                if (candidat[i].getOptiuni1(j).getNume_facultate().equals(nume_facultate)) {
                    System.out.print("ID: ");
                    System.out.println(candidat[i].getID());
                    System.out.print("Nume:");
                    System.out.println(candidat[i].getDate_candidat().getNume());
                    System.out.print("Prenume:");
                    System.out.println(candidat[i].getDate_candidat().getPrenume());
                    System.out.print("Nota:");
                    System.out.println(candidat[i].getOptiuni1(j).getProfil().getMedie_examen());
                    System.out.println();
                }
            }
        }
    }

    //calculam media de admitere
    public Double medie_de_admitere(double medie_examen,double medie_bac){
        // Media de admitere va fi 25% medie bac, 75% medie examen
        double medie = ((25*medie_bac)/100) + ((75*medie_examen)/100);
        return medie;

    }

    //seteam media de admitere pentru toti candidatii
    public Candidat[] calculeaza_media_admitere(Candidat[] candidat){
        for(int i=1;i<=this.getNumar_candidati();i++){
            for(int j=1;j<=candidat[i].getNumar_optiuni();j++){
            double mediel= candidat[i].getDate_candidat().getIstoric().getMedie_liceu();
            double mediee= candidat[i].getOptiuni1(j).getProfil().getMedie_examen();
            double medie =  medie_de_admitere(mediee,mediel);
            candidat[i].getOptiuni1(j).getProfil().setMedie_admitere(medie);
        }
        }
        this.candidat = candidat;
        return this.candidat;
    }
   //afiseaza mediile de admitere ale candidatilor pentru o facultate data
    public void afiseaza_medii(Candidat[] candidat,String nume_facultate) {
        for (int i = 1; i <= this.numar_candidati; i++) {
            for (int j = 1; j <= candidat[i].getNumar_optiuni(); j++) {
                if (candidat[i].getOptiuni1(j).getNume_facultate().equals(nume_facultate)) {
                    System.out.print("ID: ");
                    System.out.println(candidat[i].getID());
                    System.out.print("Nume: ");
                    System.out.println(candidat[i].getDate_candidat().getNume());
                    System.out.print("Prenume: ");
                    System.out.println(candidat[i].getDate_candidat().getPrenume());
                    System.out.print("Specializare: ");
                    System.out.println(candidat[i].getOptiuni1(j).getProfil().getNume_profil());
                    System.out.print("Medie: ");
                    System.out.println(candidat[i].getOptiuni1(j).getProfil().getMedie_admitere());

                }
            }
        }
    }
     //lista cu facultatite si specializarile acestora plus numarul de locuri pentru fiecare
    public void afiseaza_facultati(Facultati[] f,int nr){
        for(int i=1;i<= nr;i++){
            System.out.print(i);
            System.out.println(". ");
            System.out.println(f[i].getNume_facultate());
            System.out.println("Specializari: ");
            for(int j=1;j<=f[i].getNumar_specializari();j++) {
                System.out.println(f[i].getAlegeri(j).getNume_specializare());
                System.out.println("Locuri:");
                System.out.println(f[i].getAlegeri(j).getNumar_locuri());
            }
        }
    }
      //calculeaza numar total locuri
    public int calculeaza_locuri(Facultati f){
        int nr=0;
        for(int i=1;i<=f.getNumar_specializari();i++){
            nr += f.getAlegeri(i).getNumar_locuri();
        }
        return nr;
    }



    //afiseaza numar total locuri
     public void afiseaza_nrtot_locuri(Facultati[] f, int nr){
        for(int i=1;i<=nr;i++){
            f[i].setNumar_total_locuri(calculeaza_locuri(f[i]));
            System.out.println(f[i].getNume_facultate());
            System.out.println("Numar locuri:");
            System.out.println(f[i].getNumar_total_locuri());
        }
     }

     //afisam candidatii respinsi
     public void afiseaza_respinsi(Candidat[] candidat) {
         for (int i = 1; i <= this.numar_candidati; i++) {
             for (int j = 1; j <= candidat[i].getNumar_optiuni(); j++) {
                 if (candidat[i].getOptiuni1(j).getProfil().getMedie_admitere() < 5.0) {
                     System.out.print("ID: ");
                     System.out.println(candidat[i].getID());
                     System.out.print("Nume:");
                     System.out.println(candidat[i].getDate_candidat().getNume());
                     System.out.print("Prenume:");
                     System.out.println(candidat[i].getDate_candidat().getPrenume());
                     System.out.println("Respins:");
                     System.out.print(candidat[i].getOptiuni1(j).getNume_facultate());
                     System.out.print(", specializarea:");
                     System.out.println(candidat[i].getOptiuni1(j).getProfil().getNume_profil());
                     System.out.println();
                 }
             }
         }
     }


    public void afiseaza_cand_specializare(Candidat[] candidat,String nume) {
        for (int i = 1; i <= this.numar_candidati; i++) {
            for (int j = 1; j <= candidat[i].getNumar_optiuni(); j++) {
                if (candidat[i].getOptiuni1(j).getProfil().getNume_profil().equals(nume)) {
                    System.out.print("ID: ");
                    System.out.println(candidat[i].getID());
                    System.out.print("Nume:");
                    System.out.println(candidat[i].getDate_candidat().getNume());
                    System.out.print("Prenume:");
                    System.out.println(candidat[i].getDate_candidat().getPrenume());
                    System.out.print("Nota:");
                    System.out.println(candidat[i].getOptiuni1(j).getProfil().getMedie_examen());
                    System.out.println();
                }
            }
        }
    }

   //adauga la inceputul proramului 3 candidati
    public Candidat adaugate(int numar_candidati){
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
        Istoric_scolar istoric = new Istoric_scolar(liceu,mediel,facultate,medief);

        Date_personale Date_stud = new Date_personale(contact,adresa1,date,nume,prenume,istoric);

        numar_candidati++;
        this.candidat= new Candidat[105];
        this.candidat[numar_candidati]= new Candidat();
        this.candidat[numar_candidati]= new Candidat();
        this.candidat[numar_candidati].setDate_candidat(Date_stud);
        this.candidat[numar_candidati].setID(numar_candidati);
        int optiun = 1;
        int nr = 0;
        Optiuni[] Opt =new Optiuni[105];
        candidat[numar_candidati].setNumar_optiuni(optiun);
        while(optiun != 0){
            nr++;
            String numef = " Facultatea_de_matematica_si_informatica";
            String numes = " Informatica";
            double mediee = 6.5;
            Specializare Spec = new Specializare(numes,"-",mediee);
            Opt[nr]=new Optiuni(numef,Spec);
            optiun--;

        }
        candidat[numar_candidati].setOptiuni(Opt);
        this.candidat[numar_candidati] = candidat[numar_candidati];
        this.numar_candidati = numar_candidati;
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
         istoric = new Istoric_scolar(liceu,mediel,facultate,medief);

         Date_stud = new Date_personale(contact,adresa1,date,nume,prenume,istoric);

         numar_candidati ++;
         this.candidat[numar_candidati]= new Candidat();
        this.candidat[numar_candidati].setDate_candidat(Date_stud);
        this.candidat[numar_candidati].setID(numar_candidati);
        optiun = 1;
         nr = 0;
         Opt =new Optiuni[105];
        candidat[numar_candidati].setNumar_optiuni(optiun);
        while(optiun != 0){
            nr++;
            String numef = " Facultatea_de_matematica_si_informatica";
            String numes = " Informatica";
            double mediee = 2.2;
            Specializare Spec = new Specializare(numes,"-",mediee);

            Opt[nr]=new Optiuni(numef,Spec);
            optiun--;

        }
        candidat[numar_candidati].setOptiuni(Opt);
        this.candidat[numar_candidati] = candidat[numar_candidati];
        this.numar_candidati = numar_candidati;
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
        istoric = new Istoric_scolar(liceu,mediel,facultate,medief);

        Date_stud = new Date_personale(contact,adresa1,date,nume,prenume,istoric);

        numar_candidati ++;
        this.candidat[numar_candidati]= new Candidat();
        this.candidat[numar_candidati].setDate_candidat(Date_stud);
        this.candidat[numar_candidati].setID(numar_candidati);
        optiun = 1;
        nr = 0;
        Opt =new Optiuni[105];
        candidat[numar_candidati].setNumar_optiuni(optiun);
        while(optiun != 0){
            nr++;
            String numef = " Facultatea_de_biologie";
            String numes = "Biochimie";
            double mediee = 8.2;
            Specializare Spec = new Specializare(numes,"-",mediee);

            Opt[nr]=new Optiuni(numef,Spec);
            optiun--;

        }
        candidat[numar_candidati].setOptiuni(Opt);
        this.candidat[numar_candidati] = candidat[numar_candidati];
        this.numar_candidati = numar_candidati;
        return this.candidat[numar_candidati];
    }


    //adauga la inceputul programului 2 facultati a cate 2 specializari
    public Facultati[] adaugate1(int numar_facultati){
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
        this.numar_facultati = numar_facultati;
        this.numar_facultati ++;
        Facultati fac = new Facultati(nume_fac,Spec, numar_spec);
        this.facultati[this.numar_facultati] = fac;

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
        this.numar_facultati ++;
        fac = new Facultati(nume_fac,Spec, numar_spec);
        this.facultati[this.numar_facultati] = fac;

        return this.facultati;

    }

}
