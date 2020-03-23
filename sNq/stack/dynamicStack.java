public class dynamicStack extends stack{

    dynamicStack(){
        resize(10);
    }

    dynamicStack(int size){
        resize(size);
    }
    
    @Override
    public void push(int val) {
        if(this.size()== maxsize()){
            int[] res = new int[this.size()];
            for(int i = res.length-1; i>=0; i--){
                res[i]= top_();
                pop_();
            }
            resize(2* res.length);
            for(int i = 0; i<=res.length-1; i++){
                push_(res[i]);

            }
        }
        push_(val);

    }
}