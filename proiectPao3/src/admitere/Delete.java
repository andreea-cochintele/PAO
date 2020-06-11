package admitere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
    public static void stergereCandidat3(Admitere lista, int numar) {
        String d1URL = "jdbc:oracle:thin@localhost:8080:xe";
        String username = "SYS";
        String password = "papaiaro1";
        try {
            Connection connection = DriverManager.getConnection(d1URL, username, password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM candidat " +
                    "WHERE id_candidat = " + numar;
            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("candidat updated");
            }
            statement.close();
            connection.close();

            statement = connection.createStatement();
            sql = "DELETE FROM contact " +
                    "WHERE id_candidat = " + numar;
            rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("contact updated");
            }
            statement.close();
            connection.close();

            statement = connection.createStatement();
            sql = "DELETE FROM adresa " +
                    "WHERE id_candidat = " + numar;
            rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("adresa updated");
            }
            statement.close();
            connection.close();

            statement = connection.createStatement();
            sql = "DELETE FROM dates " +
                    "WHERE id_candidat = " + numar;
            rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("dates updated");
            }
            statement.close();
            connection.close();

            statement = connection.createStatement();
            sql = "DELETE FROM istoric " +
                    "WHERE id_candidat = " + numar;
            rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("istoric updated");
            }
            statement.close();
            connection.close();

            statement = connection.createStatement();
            sql = "DELETE FROM specializare " +
                    "WHERE id_candidat = " + numar;
            rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("specializare updated");
            }
            statement.close();
            connection.close();


            statement = connection.createStatement();
            sql = "DELETE FROM optiuni " +
                    "WHERE id_candidat = " + numar;
            rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("optiuni updated");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void stergereFacultati3(Admitere lista, int numar) {
        String d1URL = "jdbc:oracle:thin@localhost:8080:xe";
        String username = "SYS";
        String password = "papaiaro1";
        try {
            Connection connection = DriverManager.getConnection(d1URL, username, password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM facultati " +
                    "WHERE id_facultate = " + numar;
            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("facultati updated");
            }
            statement.close();
            connection.close();

            connection = DriverManager.getConnection(d1URL, username, password);
            statement = connection.createStatement();
            sql = "DELETE FROM alegeri " +
                    "WHERE id_facultate = " + numar;
            rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("alegeri updated");
            }
            statement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
