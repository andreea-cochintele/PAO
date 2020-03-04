import java.util.Scanner;
public class ex7
{
   public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int fact = 2;
        while(n > 1){
            while(n % fact == 0){
                n = n/fact;
            }
            fact++;
            if(n>1 && fact * fact > n){
                fact = n; 
            }
        }
        fact--;
        System.out.print(fact);
   }
}
