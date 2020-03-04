import java.util.Scanner;
public class ex4
{
   public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int i;
        int fact = 1;
        
        for(i = 2; i <= n; i++){
            
                fact *= i;
            }
                
        
        System.out.print(fact);
    }
}
