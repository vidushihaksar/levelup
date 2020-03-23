public class morris_traversal{
    public static void main(String[] args) {
     int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, -1, -1, -1, -1 };
    // int[] arr ={2147483647,-1,-1};
     node root = createTreefromPreorder(arr);
     morrisIn(root);
     System.out. print("\n-------------\n");
     morrispre(root);
    }

    
public static class node{
    int data;
    node l=null;
    node r=null;

    node(int data, node l , node r){
        this.data=data;
        this.l=l;
        this.r= r;

    }
}

//######## createTreefromPreorder ###############
    static int i =0;
    public static node createTreefromPreorder (int[] pre){
      
        if (pre.length==0 || pre[i]==-1){
            i++;
            return null;
        }
        node n1 = new node(pre[i], null, null);
        i++;
        n1.l = createTreefromPreorder(pre);
        n1.r = createTreefromPreorder(pre);
        return n1;
    }

//##################### display tree ##################
public static void display(node n){
    if(n== null) return;
    String s="";
    s += n.l== null? "." :n.l.data;
    s += "->" + n.data + "->";
    s += n.r== null? "." :n.r.data;

    System.out.println(s);
    display(n.l);
    display(n.r);
}

    public static node rightmost(node nl, node curr) {
        while(nl.r!=null && nl.r!=curr){
            nl= nl.r;
        }
        return nl;
    }

    public static void morrisIn(node root) {
        node curr = root;
        while(curr!=null){
            node nextLeft = curr.l;
            if(nextLeft==null){
                System.out.print(curr.data+" ");
                curr = curr.r;
                continue;
            }
        node rightmost = rightmost(nextLeft,curr);

        if(rightmost.r==null){
            rightmost.r = curr;
            curr= curr.l;
        }
        else{
            rightmost.r=null;
            System.out.print(curr.data+" ");
            curr=curr.r;
        }
        } 
    }

    
    public static void morrispre(node root) {
        node curr = root;
        while(curr!=null){
            node nextLeft = curr.l;
            if(nextLeft==null){
                System.out.print(curr.data+" ");
                curr = curr.r;
                continue;
            }
        node rightmost = rightmost(nextLeft,curr);

        if(rightmost.r==null){
            System.out.print(curr.data+" ");
            rightmost.r = curr;
            curr= curr.l;
        }
        else{
            rightmost.r=null;
           
            curr=curr.r;
        }
        } 
    }
}