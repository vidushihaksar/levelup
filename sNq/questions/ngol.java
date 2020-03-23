import java.util.*;
public class ngol{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            int val = scn.nextInt();
            arr[i]=val;
        }
        int[] ne = new int[n];
        ngol_(arr, ne, n);
        
        
    }

    public static void ngol_(int[] arr, int[]ne, int n) {
        //int n = arr.length;
        Stack<Integer> st = new Stack<>();
        

        for(int i =n-1; i>=0; i--){
            while(st.size()!=0 && arr[st.peek()]< arr[i]){
                int idx = st.pop();
                ne[idx] = arr[i];
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            ne[idx] = -1;
        }
        for(int i =0;i<n;i++){
            System.out.print(ne[i]+ " ");
        }

    }



}