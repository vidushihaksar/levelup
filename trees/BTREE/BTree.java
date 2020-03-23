import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.String;

public class BTree {

    public static void main(String[] args) {
     // int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, -1, -1, -1, -1 };
     int[] arr ={2147483647,-1,-1};
        node root = createTreefromPreorder(arr);
       
        solve(root);

    }


    public static void solve(node root) {
//         // LCA(root);
//         // basic(root);
//         display(root);
//         int h= height(root);
//         System.out.println("\nheight="+ h);

//         int s= size(root);
//         System.out.println("\nSize = "+s);

//         boolean ans = find(root, 6);
//         System.out.println(ans);

//         ArrayList<node> a = rootToNodePath(root,100);
//         System.out.println("\nRoot to node path is : ");
//         for (int i = 0; i < a.size();i++) 
// 	      { 
//               node n = a.get(i);		      
// 	          System.out.print(n.data + " "); 		
//           }   
          
//         int d = diameter1(root);
//         System.out.println("\n\nDiameter1 = "+ d);

//         int []d2 = diameter2(root);
//         for (int i=0 ; i< d2.length; i++){
//             System.out.println(d2[i]);
//         }

//         int lca = LCA(root,40,60);
//         System.out.println("\nLCA is " + lca);

//         levelOrder1(root);
//         levelOrder2(root);
//        // kaway(root,2,null);
//         //kfar_01(root,2,50);
//         kfar_02(root , 2,60);
//         boolean b = isBST(root); 
//         System.out.println("\n\nIs it a BST : "+b);

//         allPair sol = new allPair();
//         allSol(root, 0,60,sol);
//         System.out.println("\nsize : "+ sol.size + "\n"+"height = " + sol.height + "\nceil value = "+ sol.ceil + "\nFloor value= "+sol.floor+"\npred = " + sol.pred.data+ "\nsucc= "+sol.succ.data);
        
        BSTPair ans1 = new BSTPair();
        ans1 = BSTSol(root);
        System.out.println("\nIs it a BST : " + ans1.isBST + "\nhow many BST present : "+ ans1.count );
//         System.out.println("\nsize of largest BST : " + ans1.LBSTSize + "\nLargest BST node : "+ ans1.LBSTNode.data );
//         System.out.println("\nis it a balanced tree : "+ ans1.isBalanced);
// /*
//         node nnn = linearTree(root);
//         System.out.println("\nLinear tree \n");
//         display(root);
// */
//         DLL(root);
//         while (head != null) {
//             System.out.print(head.data + " -> ");
//             head= head.r;
//         }
//         System.out.println();
//         while (prev_ != null) {
//             System.out.print(prev_.data + " -> ");
//             prev_ = prev_.l;
//         }
        
    //    String sumPath_1 = " ";
    //      boolean bb = sumPath_1(root,70);
    //      System.out.println("Does path sum equal  to target exists ? "+ bb);


    // int[] arr = {10,20,30,40,50,60,70,80};
    // node r = createBSTFromArray(arr,0,7);
    // display(r);

    // node n = addNode(r,69);
    // System.out.println("\n");
    // display(n);

    // node n1 = removeNode(r, 69);
    // System.out.println("\n");
    // display(n1);
    
    
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

//################### height #####################

public static int height(node n){
    if(n== null) return 0;
    int h = Math.max(height(n.l) , height(n.r)) +1;
    return h;
}

//############## size #############################

public static int size(node n){
    if (n== null)return 0;

    return size(n.l)+ size(n.r)+1;
}

//################# find node ########################

public static boolean find(node n , int data){
    if (n== null) return false;
    if(n.data == data ) return true;

    boolean ans=false;
    ans=ans || find(n.l , data);
    ans=ans || find(n.r , data);

    return ans;
}

//#################### root to node path ################

public static ArrayList<node> rootToNodePath(node n, int data){

    ArrayList<node> a =new ArrayList();
    if(n == null) return a;
    if (n.data==data){
       
        a.add(n);
        return a;
    }
    ArrayList<node> le=  rootToNodePath(n.l ,  data);
    if(le.size()!=0){      
        le.add(n);
        return le;
    }
 
    ArrayList<node>  ri =rootToNodePath(n.r , data);
    if(ri.size()!=0){
        ri.add(n);
        return ri;
    }

    return a;
}

//############### diameter 1 ############################### run time O(n^2)

public static int diameter1( node n){
    if(n == null) return 0;
    int lh = height(n.l);
    int rh = height(n.r);

    return Math.max(Math.max(diameter1(n.l) , diameter1(n.r)), lh+rh+1);
}

//################ diameter2 ################################# run time O(n)

public static int[] diameter2(node n){
   
    int [] a = new int[2];
    if(n== null) return a;

    int [] b = diameter2(n.l);
    int [] c = diameter2(n.r);

    a[0]= Math.max(Math.max(b[0],c[0]), b[1]+c[1]+1 );
    a[1]= Math.max(b[1],c[1])+1;

    return a;
}

//######################## LCA #####################################

public static int LCA(node n , int d1, int d2){


    ArrayList<node> a1 = rootToNodePath(n,d1);
    ArrayList<node> a2 = rootToNodePath(n,d2);
    int i,j,prev=0;
    for(i=a1.size()-1 ,j=a2.size()-1; i>=0 && j>=0 ; i--,j-- ){
        if(a1.get(i).data!=a2.get(j).data){
            break;

        }
        prev = a1.get(i).data;

    }
    return prev;
}

//########################### Level order traversal 1 ################
static int level=0;
public  static void levelOrder1(node n){
    LinkedList<node> queue = new LinkedList<>();
    queue.addLast(n);
    queue.addLast(null);
    System.out.println(" \nLevel order Traversal - 1");

    while(queue.size()!= 1){
        node n1 = queue.removeFirst();
      
        System.out.print(n1.data);
        System.out.print(" ");

        if(n1.l!= null){
            queue.addLast(n1.l);
        }

        if(n1.r!= null){
            queue.addLast(n1.r);   
        }

        if(queue.getFirst() == null){
            queue.addLast(null);
            queue.removeFirst();
          
            System.out.print("                Level = " + level);
            level++;
            System.out.println();
        }
    }
}

//########################### Level order traversal 2 ################

public static void levelOrder2(node n){
    LinkedList<node> q= new LinkedList<>();
    q.addLast(n);
    int level=0;
    System.out.println(" \n\nLevel order Traversal - 2");

    while(q.size()>0){
        int size= q.size();
        while(size-->0){
          node nn = q.removeFirst();
          System.out.print(nn.data +" ");
          if(nn.l != null){q.addLast(nn.l); }
          if(nn.r != null){q.addLast(nn.r); }
        }
        level++;
        System.out.print("               level = "+level);
        System.out.println();


    }

}

//#################### kaway ####################################
public static void kaway(node n,int k ,node returnNode) {
    if(n== null) return ;
    if (n== returnNode) return;
    if(k==0) {
        System.out.print(n.data + " ");
        return;
    }
    kaway(n.l,k-1,returnNode);
    kaway(n.r,k-1,returnNode);

}


//################# kfar_1 ##########################################
public static void kfar_01(node n ,int k,int data){
    ArrayList<node> path = rootToNodePath(n,data);
    node rn = null;
    System.out.println("\nkfar_01 elements are :");
    for (i=0; i<path.size() ; i++){
        kaway(path.get(i),k-i,rn);
        rn= path.get(i);
    }
    

}

//##################### kfar_2 #############################
public static int kfar_02(node n, int k, int data) {
    if (n== null){return -1;}
    if(n.data ==  data){
        kaway(n,k,null);        
        return 1;
    }
    int ld = kfar_02(n.l , k,data);
    if(ld!= -1){
        kaway(n,k-ld,n.l);
        return ld+1;
    }

    int rd = kfar_02(n.r , k, data);
    if(rd!= -1){
        kaway(n,k-rd,n.r);
        return rd+1;
    }

    return -1;
}

//################### is BST #################################3
static int prev = (int) -1e8;

public static boolean isBST(node node1) {
    if (node1 == null)
        return true;

    
    if (prev > node1.data) {
        return false;
    }
    if (!isBST(node1.l))
        return false;

    prev = node1.data;

    if (!isBST(node1.r))
        return false;

    return true;

}

//############## size,height,find,ceil,floor,pred,succ #####################
public static class allPair{
    int size=0;
    int height=0;
    boolean find = false;
    int ceil = (int) 1e8;
    int floor = (int) -1e8;
    node pred=null;
    node succ=null;
    node prev=null;

}
public static void allSol(node n, int level,int data, allPair obj){
    if(n==null) return;
    obj.size++;
    obj.height=(Math.max(obj.height, level));
    obj.find = obj.find || n.data==data;

    if(n.data> data && n.data< obj.ceil){
        obj.ceil=n.data;
     }

    if(n.data< data && n.data> obj.floor){
        obj.floor=n.data;
     }

    if(obj.pred==null && n.data==data){obj.pred = obj.prev;}
    if(obj.prev!=null && obj.prev.data==data && obj.succ==null ){obj.succ = n;}
    obj.prev = n;

    allSol(n.l, level +1, data, obj);
    allSol(n.r , level +1, data, obj);
   






}


//############ BST pair(isBST,count,LBSTSize,LBSTNode, balanced tree) ###############

public static class BSTPair{
    boolean isBST=true;
    int count=0;
    int LBSTSize=0;
    node LBSTNode=null;

    int min =(int)1e8;
    int max = (int)-1e8;
    int height=0;
    boolean isBalanced= true;

}
public static BSTPair BSTSol( node n) {
    if(n==null){ return new BSTPair(); }
    BSTPair left = BSTSol(n.l);
    BSTPair right = BSTSol(n.r);

    BSTPair mypair = new BSTPair();

    if(left.isBalanced && right.isBalanced && Math.abs(left.height-right.height)<=1 ){
        mypair.isBalanced=true;
    }
    else {
        mypair.isBalanced=false;
    }

    if(left.isBST && right.isBST && left.max < n.data && right.min >=n.data){
        mypair.isBST=true;
        mypair.count = left.count + right.count+1;
        mypair.LBSTSize = left.LBSTSize + right.LBSTSize+1;
        mypair.LBSTNode =n;
    }
    else{
        mypair.isBST=false;
        mypair.count = left.count + right.count;
        if(left.LBSTSize>= right.LBSTSize){  
            mypair.LBSTSize = left.LBSTSize;
            mypair.LBSTNode = left.LBSTNode;
        }
        else{
            mypair.LBSTSize = right.LBSTSize;
            mypair.LBSTNode = right.LBSTNode;
        }
        
    }

    mypair.min = Math.min(Math.min(left.min,right.min),n.data);
    mypair.max = Math.max(Math.max(left.max,right.max),n.data);
    mypair.height =Math.max(left.height,right.height)+1;

    return mypair;

    
}

//############### linear tree ##############################
public static node linearTree(node n) {
    if(n==null){return null; }
    if(n.l == null && n.r ==null){
        return n;
    }
    node leftTail = linearTree(n.l);
    node rightTail = linearTree(n.r);
    if(leftTail==null){
        n.l = n.r;
    }
    else{
         leftTail.l = n.r;
    }
    n.r= null;
    return rightTail!=null ? rightTail : leftTail;

    
}

//############## Doubly Linked List #######################
static node prev_ =null;
static node head = null;
 public static void DLL(node n) {
    if(n== null){ return; }
    DLL(n.l);
    if(prev_ == null){
        head = n;
    }
    else{
        n.l = prev_;
        prev_.r = n;
    }
    prev_ = n;

    DLL(n.r);    
}

//################## create BST from array ,add node, remove node ###################    
public static node createBSTFromArray (int[]arr, int si, int ei) {
    if(si>ei){
        return null;
    }
    int mid = (si + ei)/2;
    node n1 = new node(arr[mid],null,null);
    n1.l = createBSTFromArray(arr, si, mid-1);
    n1.r= createBSTFromArray(arr, mid+1, ei);

    return n1; 
}
public static node addNode(node n, int data){
    if(n== null){
        node new_node= new node(data,null,null);
        return new_node;
    }

    if(data< n.data) {
        n.l= addNode(n.l, data);
    }
    if(data> n.data) {
        n.r= addNode(n.r, data);
    }

    return n;
}

public static node findMax(node root) {
    while(root.r!=null){
        root = root.r;
    }
    return root;

}
public static node removeNode(node root, int data) {
    if(data < root.data ){
        root.l = removeNode(root.l, data);
    }
    else if(data > root.data){
        root.r =  removeNode(root.r, data);
    }
    else{
        if(root.l== null || root.r== null){
            return root.l==null ? root.r :root.l;
        }
    
        node max = findMax(root.l);
        root.data= max.data;
        node rem = removeNode( root, max.data );
    }
    return root;
}
}



























/*
public static int[] LeafToLeaf(node n){
   
    int [] a = new int[2];
    if(n== null) return a;

    int [] b = LeafToLeaf(n.l);
    int [] c = LeafToLeaf(n.r);

    a[0]= Math.max(Math.max(b[0],c[0])+n.data, b[1]+c[1]+n.data );
    a[1]= Math.max(b[1],c[1])+n.data;

    return a;
}
}

public static int LeafToLeaf(node n) {
    if (n==null){return (int)-1e8;}
    int ld = LeafToLeaf(n.l);
    int rd = LeafToLeaf(n.r);
    return Math.max(Math.max(ld,rd),ld+rd+n.data);
    
}
}*/