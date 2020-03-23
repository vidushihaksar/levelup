import java.util.Scanner;
public class fahrenheit{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter min range\n");
        int min_range=scn.nextInt();
        System.out.println("enter max range\n");
        int max_range=scn.nextInt();
        System.out.println("enter step\n");
        int step=scn.nextInt();

        for(int i=min_range ; i<=max_range; i+=step)
        {
           int c = (int)((5.0/9)*(i-32));
           System.out.println(i + " "+ c);
        
        }
        
        
    }
}