import java.util.Scanner;

public class ex3
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int i;
        int suma = 0;
        
        for(i = 3; i <= n; i++){
            if(i % 3 == 0 || i % 5 ==0){
                suma += i;
            }
                
        }
        System.out.print(suma);
    }
}
