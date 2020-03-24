// import java.util.*;
// public class largestRectInHistogram{
//     public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n= scn.nextInt();
//        int[] heights = new int[n];

//        for(int i = 0; i<n; i++){
//            heights[i]=scn.nextInt();
//        }
//                 int area=0,max_=0;
//                 int[] rt = new int[n];
//                 int[] lt = new int[n];
                
//                 nsor_(heights, rt, n);
//                 nsol_(heights, lt, n);
                
//                 for(int i =0; i<n; i++){
//                     int h = heights[i];
//                     int w = rt[i]-lt[i]-1;
//                      area = h*w;
//                     max_ = Math.max(max_, area);
//                 }
//                 System.out.print(max_);

//     }
//     public static void nsor_(int[] arr, int[]rt, int n) {
//                 Stack<Integer> st = new Stack<>();
//                 for(int i =0; i<n; i++){
//                     while(st.size()!=0 && arr[st.peek()]> arr[i]){
//                         int idx = st.pop();
//                         rt[idx] = i;
//                     }
//                     st.push(i);
//                 }
//                 while(!st.isEmpty()){
//                     int idx = st.pop();
//                     rt[idx] = n;
//                 }
                
        
        
//     }
//              public static void nsol_(int[] arr, int[]lt, int n) {
//                 Stack<Integer> st = new Stack<>();
//                 for(int i =n-1; i>=0; i--){
//                     while(st.size()!=0 && arr[st.peek()]> arr[i]){
//                         int idx = st.pop();
//                         lt[idx] = i;
//                     }
//                     st.push(i);
//                 }
//                 while(!st.isEmpty()){
//                     int idx = st.pop();
//                     lt[idx] = -1;
//                 }
                 
        
//             }
// }
import java.util.*;
public class largestRectInHistogram{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
       int n= scn.nextInt();
       int[] heights = new int[n];

       for(int i = 0; i<n; i++){
           heights[i]=scn.nextInt();
       }
       System.out.print(largestRectangleArea(heights));
    }
public static int largestRectangleArea(int[] heights) {

    Stack<Integer> st = new Stack<>();
    int n  = heights.length;
    st.push(-1);
    int area=0;
    for(int i=0; i<heights.length; i++){
        while(st.size()!=0 && st.peek()!=-1 && heights[i]<=heights[st.peek()]){
           int h = heights[st.peek()];
            st.pop();
            //int height = heights[idx];
           int width = i - st.peek() -1;
            int a = h * width;
            area = Math.max(area,a);
        }
        st.push(i);
    }
    while(st.size()!=0 && st.peek()!=-1){
            int h = heights[st.peek()];
            st.pop();
            //int height = heights[idx];
            int width = n - st.peek() -1;
            int a = h * width;
            area = Math.max(area,a);
    }

    return area;
}
}