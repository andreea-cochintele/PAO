import java.util.Scanner;
public class ex5
{
   public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int i;
        int prim = 1;
        
        for(i = 2; i * i <= n; i++){
            if(n % i == 0){
                prim = 0;
            }
        }
                
        if(prim == 1 ){
            System.out.print("Numarul este prim");
        }
        else{
            System.out.print("Numarul nu este prim");
        }
        
    }
}
