// import java.util.StringBuilder;
// import java.util.Stack;
// import java.util.Scanner;
import java.util.*;


//leetcode - 20
public class validParanthesis_20{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;

        str = scan.nextLine();
        StringBuilder strb  = new StringBuilder(str);
        System.out.println(isValid(strb));
    }
    public static boolean isValid(StringBuilder str) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{' ){
                st.push(i);
            }

            else  {
                if(st.size()==0){
                    return false;
                }
               
                else if(str.charAt(st.peek())=='('  && str.charAt(i)==')'){
                    st.pop();
                }
                 else if(str.charAt(st.peek())=='['  && str.charAt(i)==']'){
                    st.pop();
                }
                 else if(str.charAt(st.peek())=='{' &&  str.charAt(i)=='}'){
                    st.pop();
                }

                else if(str.charAt(i)==')' || str.charAt(i)=='}' || str.charAt(i)==']'){
                    return false;
                }

            }
        }
        return st.size()==0;
    }
}