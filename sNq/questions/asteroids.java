// leetode - 735. Asteroid Collision
import java.util.*;

public class asteroids{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int[] asteroids = new int[n];

        for(int i = 0; i<n; i++){
            asteroids[i] = scn.nextInt();
        }
        fn(asteroids);
    }
    public static void fn(int[]asteroids) {
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<asteroids.length; i++){
            int ele = asteroids[i];
            
            if(ele > 0){ st.push(ele); }
            else{
                while(st.size()!=0 && st.peek()>0 && st.peek()< -ele){
                    st.pop();
                }
                if(st.size()!=0 && st.peek() == -ele){
                     st.pop();
                }
                else if(st.size()==0 || st.peek() < 0){
                    st.push(ele);
                }
            }
        }
        int[] a = new int[st.size()];
        for(int i= a.length-1; i>=0; i--){
            int ele = st.pop();
            a[i]=ele;
        }

        for(int i=0; i<a.length; i++){
            System.out.println(a[i]+" ");
        }
    
    }
}