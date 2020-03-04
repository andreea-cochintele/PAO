
import java.util.Scanner;

public class ex2
{
   public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        if(x == y){
            System.out.print(x);
            System.out.print(" = ");
            System.out.println(y);

            System.out.print(x);
            System.out.print(" >= ");
            System.out.println(y);


            System.out.print(x);
            System.out.print(" <= ");
            System.out.println(y);

        }
        if(x < y){
            System.out.print(x);
            System.out.print(" != ");
            System.out.println(y);

            System.out.print(x);
            System.out.print(" < ");
            System.out.println(y);

            System.out.print(x);
            System.out.print(" <= ");
            System.out.println(y);

        }
        else {

            System.out.print(x);
            System.out.print(" != ");
            System.out.println(y);
            
            System.out.print(x);
            System.out.print(" > ");
            System.out.println(y);

            System.out.print(x);
            System.out.print(" >= ");
            System.out.println(y);

        }
    }
}
