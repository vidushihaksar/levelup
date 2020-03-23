public class client {

    public static void main(String[] args) throws Exception {
        simpleStack();
    }

    public static void simpleStack() throws Exception {
        //stack st = new stack(4);
        dynamicStack st = new dynamicStack(3);
        st.push(10);
        st.push(10);
        st.push(10);
        st.push(80);
        System.out.println(st.top() +" \n"+ st.maxsize());
        
    }
}