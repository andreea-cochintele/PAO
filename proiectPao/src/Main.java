//Cochintele Andreea
//Gestiunea unei admiteri
//1st checkpoint




import admitere.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admitere ob = new Admitere();
        int nr= ob.getNumar_candidati();
        ob.adaugate(0);   //adauga 3 candidati pentru a avea pe ce verifica
        ob.adaugate1(0);   //adauga 2 facultati a cate 2 specializari
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

            i = scan.nextInt();
            switch (i) {
                case 0:
                    System.out.println("Iesire...");
                    break;
                case 1:
                    ob.adauga_candidat();
                    break;
                case 2:
                    ob.afiseaza_candidati(ob.getCandidat());
                    break;
                case 3:
                    String nume = scan.nextLine();
                    ob.afiseaza_candidati_facultate(ob.getCandidat(),nume);
                    break;
                case 4:
                   ob.setCandidat(ob.calculeaza_media_admitere(ob.getCandidat()));
                   break;
                case 5:
                     nume = scan.nextLine();
                    ob.afiseaza_medii(ob.getCandidat(),nume);
                    break;
                case 6:
                    ob.afiseaza_facultati(ob.getFacultati(),ob.getNumar_facultati());
                    break;
                case 7:
                    ob.afiseaza_nrtot_locuri(ob.getFacultati(),ob.getNumar_facultati());
                    break;
                case 8:
                    ob.afiseaza_respinsi(ob.getCandidat());
                    break;
                case 9:
                    nume = scan.nextLine();
                    ob.afiseaza_cand_specializare(ob.getCandidat(),nume);
                    break;
                default:
                    System.out.println("Optiunea aleasa nu este disponibila");
                    break;

            }
        }
    }
}

