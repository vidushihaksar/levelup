import java.util.*;
public class longestValidParan{
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println( valid(str));
    }
    public static int valid(String str) {
        Stack<Integer> st = new Stack<>();
        StringBuilder strb  = new StringBuilder(str);

        st.push(-1);
        int count_max =0;

        for(int i=0; i<strb.length();i++){
            if(st.peek()!=-1 && strb.charAt(i)==')' && strb.charAt(st.peek())=='('){
                st.pop();
                int c = i - st.peek();
                count_max   = Math.max(count_max, c);
            }
            else{ st.push(i); }
        }
        return count_max;
    }
}