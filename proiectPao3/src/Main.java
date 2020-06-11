//Cochintele Andreea
//Gestiunea unei admiteri
//1st checkpoint




import admitere.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Admitere ob = new Admitere();
        int nr= ob.getNumarCandidati();
        //ob.adaugate(0);   //adauga 3 candidati pentru a avea pe ce verifica
        //ob.adaugate1(0);   //adauga 2 facultati a cate 2 specializari
        ob.readCsvFacultate("fmi.csv",0);
        ob.readCsvFacultate("bio.csv",1);
        ob.readCsvCandidati("candidati.csv",0);
        Scanner scan = new Scanner(System.in);
        int i = 1;
        while (i != 0){
            System.out.println("Alegeti optiunea:");
            System.out.println("0. Iesire.");
            System.out.println("1. Adaugati candidat.");
            System.out.println("2. Afisati candidati. ");
            System.out.println("3. Afisati candidati dupa facultate.(Inserati numele facultatii(ex input:  3 Facultatea_de_biologie)) ");
            System.out.println("4. Calculati mediile de admitere");
            System.out.println("5. Afisati mediile de admitere calculate.(Inserati numele facultatii(ex input :  5 Facultatea_de_biologie)");
            System.out.println("6. Afisari facultatile si specializarile disponibile.");
            System.out.println("7. Calculeaza si afiseaza numarul total de locuri pe facultate.");
            System.out.println("8. Respingem candidatii fara medie de trecere si ii afisam.");
            System.out.println("9. Afisati candidati dupa specializare. (Inserati specializarea (ex input: 9 Informatica)");
            System.out.println("10.Afisati lista specializari.");

            i = scan.nextInt();
            switch (i) {
                case 0:
                    System.out.println("Iesire...");
                    break;
                case 1:
                    ob.adaugaCandidat();
                    //Add.adaugaCandidat3(ob,ob.getNumarCandidati()+1);
                    break;
                case 2:
                    ob.afiseazaCandidati(ob.getCandidat());
                    break;
                case 3:
                    String nume = scan.nextLine();
                    ob.afiseazaCandidatiFacultate(ob.getCandidat(),nume);
                    break;
                case 4:
                   ob.setCandidat(ob.calculeazaMedieAdmitere(ob.getCandidat()));
                   break;
                case 5:
                     nume = scan.nextLine();
                    ob.afiseazaMedii(ob.getCandidat(),nume);
                    break;
                case 6:
                    ob.afiseazaFacultatiLocuri(ob.getFacultati(),ob.getNumarFacultati());
                    break;
                case 7:
                    ob.afiseazaNumarTotalLocuri(ob.getFacultati(),ob.getNumarFacultati());
                    break;
                case 8:
                    ob.afiseazaRespinsi(ob.getCandidat());
                    break;
                case 9:
                    nume = scan.nextLine();
                    ob.afiseazaCandidatiSpecializare(ob.getCandidat(),nume);
                    break;
                case 10:
                    Citire ob1 = new Citire();
                    ob1.afisareGeneralFacultatiFile("facultati.csv");
                    break;
                default:
                    System.out.println("Optiunea aleasa nu este disponibila");
                    break;

            }
        }
    }
}

