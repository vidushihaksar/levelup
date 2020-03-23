public class queue{
    protected int[] que;
    protected int front =0;
    protected int end = 0;
    protected int size = 0;

    queue(){
         this.que = new int[10];
    }

    queue(int size){
        this.que = new int[size];
    }

    public int size(){
        return this.que.size;
    }
    public void push_(int val) {
        this.end = (this.end ) % this.que.length;
        que[this.end] = val;
        this.size++;
        
    }
    public void push(int val) throws Exception {
        if(this.size() == que.length){
            throw new Exception("QueueIsFull");
        }

        push_(val);
    }
    
    public void pop_() {
        int rem = this.que[this.front];
        this.que[this.front] = 0;
        this.size--;

        this.front = (this.front ) % this.que.length;
    }

    public void pop() throws Exception {
        if(this.size() == 0){
            throw new Exception("QueueIsEmpty");
        }
        pop_();
    }

    public int top(){
        return this.que[this.top];
    }

    public boolean isEmpty() {
        return this.size==0;
        
    }
}