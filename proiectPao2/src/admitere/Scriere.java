package admitere;

import com.opencsv.CSVWriter;

import java.io.*;

public class Scriere {
        // static variable single_instance of type Singleton
        private static Scriere single_instance = null;

        // variable of type String
        public String s;
        private Scriere(){

        }

        // private constructor restricted to this class itself
       public static void adaugaCandidat(Candidat candidat) throws IOException {
                   
           try {
               FileWriter output = new FileWriter("candidati.csv",true);
               BufferedWriter file = new BufferedWriter(output);

               // Value
               //String[] data3 = { candidat.getDateCandidat().getNume(), candidat.getDateCandidat().getPrenume(),
               // candidat.getDateCandidat().getContact1().getMail(), candidat.getDateCandidat().getContact1().getTelefon()
               // , candidat.getDateCandidat().getAdresa1().getLocalitate(),candidat.getDateCandidat().getAdresa1().getJudet()
               // ,candidat.getDateCandidat().getAdresa1().getTara(),candidat.getDateCandidat().getDate1().getDataNasterii()
               // ,candidat.getDateCandidat().getDate1().getCNP(),candidat.getDateCandidat().getIstoric().getLiceu(),
               // String.valueOf(candidat.getDateCandidat().getIstoric().getMedieLiceu()) };
               //write.writeNext(data3);
               //write.close();
               file.write(candidat.getDateCandidat().getNume());
               file.write(",");
               file.write(candidat.getDateCandidat().getPrenume());
               file.write(",");
               file.write(candidat.getDateCandidat().getContact1().getMail());
               file.write(",");
               file.write(candidat.getDateCandidat().getContact1().getTelefon());
               file.write(",");
               file.write(candidat.getDateCandidat().getAdresa1().getLocalitate());
               file.write(",");
               file.write(candidat.getDateCandidat().getAdresa1().getJudet());
               file.write(",");
               file.write(candidat.getDateCandidat().getAdresa1().getTara());
               file.write(",");
               file.write(candidat.getDateCandidat().getDate1().getDataNasterii());
               file.write(",");
               file.write(candidat.getDateCandidat().getDate1().getCNP());
               file.write(",");
               file.write(candidat.getDateCandidat().getIstoric().getLiceu());
               file.write(",");
               file.write(String.valueOf(candidat.getDateCandidat().getIstoric().getMedieLiceu()));
               file.write(",");
               file.write(String.valueOf(candidat.getNumarOptiuni()));
               file.write(",");
               int nr = candidat.getNumarOptiuni();
               for(int i = 1; i <= nr; i ++) {
                   file.write(candidat.getOptiuni1(i).getNumeFacultate());
                   file.write(",");
                   file.write(candidat.getOptiuni1(i).getProfil().getNumeProfil());
                   file.write(",");
                   file.write(String.valueOf(candidat.getOptiuni1(i).getProfil().getMedieExamen()));
                   file.write(",");
                   file.write("-1");
               }
               file.newLine();
               file.close();

           } catch (NullPointerException | IOException e) {
               e.printStackTrace();
           }

        }

        // static method to create instance of Singleton class
        public static Scriere getInstance()
        {
            if (single_instance == null)
                single_instance = new Scriere();

            return single_instance;
        }
}
