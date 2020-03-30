import java.util.*;

public class gasStation{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] gas = new int[n];
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
             gas[i] = scn.nextInt();
        }
        for(int i=0; i<n; i++){
            cost[i] = scn.nextInt();
       }

       System.out.println(start(gas, cost));
    }
    public static int start(int[]gas, int[]cost){
        int start=0, extraPetrol=0, lack=0;

        for(int i=0; i<gas.length; i++){
            extraPetrol+= gas[i]-cost[i];
            if(extraPetrol  < 0){
                start = i+1;
                lack+= extraPetrol;
                extraPetrol =0;
            }
        }
        return lack+extraPetrol >= 0 ? start : -1;

    }
}