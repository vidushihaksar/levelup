import java.util.Scanner;

class prime{
    public static void main(String[] args) {
        checkPrime();
    }
    public static void checkPrime() {
        Scanner scn = new Scanner(System.in);
        int t,n;
       t = scn.nextInt();
        while(t>0){
            n= scn.nextInt();
            int num = 2;
            boolean res= true;
            while(num*num <= n){
                if(n % num == 0){
                    res = true;

                    
                    break;
                }
                num++;
            }
            if(res==true){System.out.println("not prime");}
            else {System.out.println("prime");}
            
            t--;
        }       
    }
}