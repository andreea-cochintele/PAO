package admitere;

import admitere.candidat.DatePersonale;
import admitere.candidat.date.Adresa;
import admitere.candidat.date.Contact;
import admitere.candidat.date.Date;
import admitere.candidat.date.IstoricScolar;
import admitere.facultate.Optiuni;
import admitere.facultate.sub.Specializare;
import admitere.toate.Specializari;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//clasa singleton pentru citire
public class Citire {
    private static Citire instanta_citire = null;
    public String read;

    public Citire(){

    }

     public Facultati citireFacultatiFile(String File) {
         // Virgula este separator
         String csvFile = File;
         BufferedReader br = null;
         String line = "";
         String cvsSplitBy = ",";
         String nume_fac = " ";
         Specializari[] Spec = new Specializari[10];
         int numar_spec = 1;
         try {

             br = new BufferedReader(new FileReader(csvFile));
             while ((line = br.readLine()) != null) {

                 String[] temp = line.split(cvsSplitBy);
                 String nume_specializare = temp[0];
                 String tmp = temp[1];
                 int numar_ani_stud = Integer.parseInt(tmp);
                 tmp = temp[2];
                 int numar = Integer.parseInt(tmp);
                 nume_fac = temp[3];
                 Spec[numar_spec] = new Specializari(numar_ani_stud, nume_specializare, numar);
                 numar_spec++;
             }
             numar_spec--;
             Facultati fac = new Facultati(nume_fac, Spec, numar_spec);
             return fac;

         } catch (FileNotFoundException e) {
             e.printStackTrace();
             return null;
         } catch (IOException e) {
             e.printStackTrace();
             return null;
         } finally {
             if (br != null) {
                 try {
                     br.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }

     }
    public Candidat[] citireCandidatiFile(String File) {
        // Virgula este separator
        String csvFile = File;
        BufferedReader br = null;
        String line = "";
        //String[] cvsSplitBy = (",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        Candidat[] candidat = new Candidat[105];
        int numarCandidati = 1;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                String nume= temp[0];
                String prenume= temp[1];
                String mail = temp[2];
                String telefon = temp[3];
                Contact contact = new Contact(mail ,telefon );

                String localitate = temp[4];
                String judet = temp[5];
                String tara = temp[6];
                Adresa adresa1 = new Adresa(localitate ,judet ,tara );

                String data = temp[7];
                String CNP = temp[8];
                Date date;
                date = new Date(CNP ,data );

                String liceu = temp[9];
                String tempo = temp[10];
                double mediel = Double.parseDouble(tempo );

                IstoricScolar istoric = new IstoricScolar(liceu ,mediel,"" ,0);

                DatePersonale Date_stud = new DatePersonale(contact,adresa1,date,nume ,prenume ,istoric);
                candidat[numarCandidati]= new Candidat();
                candidat[numarCandidati].setDateCandidat(Date_stud);
                candidat[numarCandidati].setID(numarCandidati);
                tempo = temp[11];
                int optiun = Integer.parseInt(tempo );
                int nr = 0;
                int num = 12;
                Optiuni[] Opt = new Optiuni[105];
                candidat[numarCandidati].setNumarOptiuni(optiun);
                while(optiun != 0){
                    nr++;
                    String numef = temp[num++];
                    String numes = temp[num++];
                    tempo = temp[num++];
                    double mediee = Double.parseDouble(tempo );
                    Specializare Spec = new Specializare(numes ,"-",mediee);
                    Opt[nr]=new Optiuni(numef ,Spec);
                    optiun--;

                }
                candidat[numarCandidati].setOptiuni(Opt);
                numarCandidati++;
            }
            candidat[numarCandidati] = new Candidat();
            candidat[numarCandidati].setID(-1) ;
            return candidat;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void afisareGeneralFacultatiFile(String File) {
        // Virgula este separator
        String csvFile = File;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String nume_fac = "";
        int num= 0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                int nr = 0;
                num++;
                String[] temp = line.split(cvsSplitBy);
                String nume= temp[nr];
                System.out.println(num + ".");
                System.out.println(nume );
                nr++;
                String tmp = temp[nr];
                int numar_specializari = Integer.parseInt(tmp );
                System.out.println("Specializari:");
                nr++;
                for(int i = 1; i <= numar_specializari; i++){
                     nume = temp[nr];
                    nr++;
                    System.out.println(nume );
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static Citire getInstance(){
        if(instanta_citire == null)
            instanta_citire = new Citire();
        return instanta_citire;
    }

}
