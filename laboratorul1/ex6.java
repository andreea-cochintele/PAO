import java.util.Scanner;
public class ex6
{
   public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int i;
        int nr = 2;
        int num = 1;
        int a = 0;
        int b = 1;
        
        
        while(nr<n){
            a = b;
            b = num;
            num = a +  b;
            nr++;
        }
                
        if(n == 1){
            System.out.print("1");
        }
        else if(n == 2){
            System.out.print("1");
        }
        else{
            System.out.print(num);
        }
        
        
    }
}
