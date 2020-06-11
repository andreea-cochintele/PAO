package admitere;

import admitere.Admitere;
import admitere.Candidat;
import admitere.Facultati;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Add {

    public static void adaugaCandidat3(Admitere lista, int numar){
            String d1URL = "jdbc:oracle:thin@localhost:8080:xe";
            String username = "SYS";
            String password = "papaiaro1";
        try {
            Connection connection= DriverManager.getConnection(d1URL,username,password);
            Candidat candidat = new Candidat();
            candidat = lista.getCandidat(numar);
            String sql = "INSERT INTO contact" + "VALUES(" + numar+ ","+ candidat.getDateCandidat().getContact1().getMail() +"," + candidat.getDateCandidat().getContact1().getTelefon()+");";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0) { System.out.println("contact updated");}
            statement.close();
            connection.close();


            sql = "INSERT INTO adresa" + "VALUES(" + numar+ ","+ candidat.getDateCandidat().getAdresa1().getLocalitate()+ ","+ candidat.getDateCandidat().getAdresa1().getJudet() + ","+ candidat.getDateCandidat().getAdresa1().getTara()+");";
            statement = connection.createStatement();
            rows = statement.executeUpdate(sql);
            if(rows > 0) { System.out.println("adresa updated");}
            statement.close();
            connection.close();

            sql = "INSERT INTO dates" + "VALUES(" + numar+ ","+ candidat.getDateCandidat().getDate1().getDataNasterii() + "," + candidat.getDateCandidat().getDate1().getCNP() + ");";
            statement = connection.createStatement();
            rows = statement.executeUpdate(sql);
            if(rows > 0) { System.out.println("dates updated");}
            statement.close();
            connection.close();

            sql = "INSERT INTO istoric" + "VALUES(" + numar+ ","+candidat.getDateCandidat().getIstoric().getLiceu()+ "," + candidat.getDateCandidat().getIstoric().getMedieLiceu() + ");";
            statement = connection.createStatement();
            rows = statement.executeUpdate(sql);
            if(rows > 0) { System.out.println("istoric updated");}
            statement.close();
            connection.close();

            for(int i = 0 ; i < candidat.getNumarOptiuni(); i++) {
                sql = "INSERT INTO specializari" + "VALUES(" + i + "," +numar +"," + candidat.getOptiuni1(i).getProfil().getNumeProfil()+"," +candidat.getOptiuni1(i).getProfil().getSituatieAdmitere() +"," + candidat.getOptiuni1(i).getProfil().getMedieExamen()+"," + candidat.getOptiuni1(i).getProfil().getMedieAdmitere()+");";
                statement = connection.createStatement();
                rows = statement.executeUpdate(sql);
                if (rows > 0) {
                    System.out.println("specializari updated");
                }
                statement.close();
                connection.close();


                sql = "INSERT INTO optiuni" + "VALUES(" + numar + "," + candidat.getOptiuni1(i).getNumeFacultate()+");";
                statement = connection.createStatement();
                rows = statement.executeUpdate(sql);
                if (rows > 0) {
                    System.out.println("optiuni updated");
                }
                statement.close();
                connection.close();
            }


            sql = "INSERT INTO candidat" + "VALUES(" + numar+ "," + candidat.getNumarOptiuni() + "," + candidat.getDateCandidat().getNume() + "," + candidat.getDateCandidat().getPrenume()+");";
            statement = connection.createStatement();
            rows = statement.executeUpdate(sql);
            if(rows > 0) { System.out.println("candidat updated");}
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void adaugaFacultate3(Admitere lista, int numarf, int numars) {
            String d1URL = "jdbc:oracle:thin@localhost:8080:xe";
            String username = "SYS";
            String password = "papaiaro1";
            try {
                Connection connection = DriverManager.getConnection(d1URL, username, password);
                Facultati facultate = new Facultati();
                facultate = lista.getFacultati(numarf);
                String sql = "INSERT INTO facultati" + "VALUES(" + numarf + "," + facultate.getNumeFacultate()+ "," + facultate.getNumarSpecializari()+ ");";
                Statement statement = connection.createStatement();
                int rows = statement.executeUpdate(sql);
                if (rows > 0) {
                    System.out.println("contact updated");
                }
                statement.close();
                connection.close();


                sql = "INSERT INTO alegeri" + "VALUES(" + numarf + "," +numars + "," + facultate.getAlegeri(numars).getAniStudii()+ "," + facultate.getAlegeri(numars).getNumeSpecializare() + "," + facultate.getAlegeri(numars).getNumarLocuri()+ "," + facultate.getAlegeri(numars).getUltimaMedie()+ ");";
                statement = connection.createStatement();
                rows = statement.executeUpdate(sql);
                if (rows > 0) {
                    System.out.println("contact updated");
                }
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
