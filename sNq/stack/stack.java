public class stack{
    int[] st;
    int tos = -1;
    int size = 0;

    public void resize(int size){
        this.st = new int[size];
        tos = -1;
        size = 0;
    }
    stack(){
        resize(10);
    }

    stack(int size){
        resize(size);
    }
    
    public int maxsize() {
        return this.st.length;
    }

    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return this.size()==0;
    }
    public void push_(int val) {
        this.st[++tos] = val;
        this.size++;
    }

    public void push(int val) throws Exception {
        if(this.size()== maxsize()){
            throw new Exception("stackOverFlow");
        }
        push_(val);
    }
    public void pop_() {
        this.st[this.tos]=0;
        this.tos--;
        this.size--;        
    }

    public void pop()throws Exception {
        if(this.size()== 0){
            throw new Exception("stackIsEmpty");
        }       
        pop_();
    }
    
    public int top_() {
        return this.st[this.tos];
    }
    public int top()throws Exception{
        if(this.size()== 0){
            throw new Exception("stackIsEmpty");
            
        }       
        return top_();
    }
}