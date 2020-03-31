//leetcode 155 MIN STACK

import java.util.*;
public class minStack {
   long minSoFar = 0;
   Stack<Long> st = new Stack<>();

   
    public static void push(int x){
        long val = x;

        if(st.size() == 0){
            minSoFar = val;
            st.push(val);
            return;
        }
        if(val < minSoFar){
            st.push((val - minSoFar) + val);
            minSoFar = val;
        }
        else{
            st.push(val);
        }
    }
    public static void pop() {
        if(st.peek() <  minSoFar){
            minSoFar = (minSoFar - st.peek()) + minSoFar;
            st.pop();
            
        }
        else{
            st.pop();
        }
    }
    public static int top() {
        if(st.peek() <  minSoFar){
            return (int)minSoFar;
        }
        
            long v = st.peek();
            return (int)v;
    }
    public static int min() {
        return (int)minSoFar;
    }

}