
public class BST {

public static void main(String[] args) {

    // int[] arr = {10,20,30,40,50,60,70,80};
    // node r = createBSTFromArray(arr,0,7);
    // display(r);
    // node lca=LCAofBST(r, 50,80);
    // System.out.println("\nlca of:"+lca.data);
    // printInRange(r,50,80);
    //System.out.print(find_bst(r,90));
    int[] pre = {50,25,20,30,75,65};
    node root = BSTFromPreorder(pre, (int)-1e8, (int)1e8, 0);
    display(root);
    System.out.println("##################");
    // int h = HeightFromPreorder(pre,(int)-1e8, (int)1e8, 0);
    // System.out.print("\n height"+h);
    node r = insertIntoBST(root,90);
    display(r);
    System.out.println("##################");
    node s = delNodeFromBST(root, 100);
    display(s);
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
public static boolean find(node n , int data){
    if (n== null) return false;
    if(n.data == data ) return true;

    boolean ans=false;
    ans=ans || find(n.l , data);
    ans=ans || find(n.r , data);

    return ans;
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
//########### create BST From Array ##############
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
//####### insert node in BST #########
public static node insertIntoBST(node root, int val) {
    if(root==null){
        node n = new node(val,null,null);
        return n;
    }
    
    if(val < root.data){
       root.l= insertIntoBST(root.l, val);
    }
    else{
        root.r= insertIntoBST(root.r, val);
    }
    
    return root;
}
public static node findMax(node root) {
    node rnode = root;
    while(rnode.r!=null){
        rnode = rnode.r;
    }
    return rnode;
}
//###### delete node from BST ##########
public static node delNodeFromBST(node root,int val ) {
    if(root==null) return null;
    if(val < root.data){
        root.l = delNodeFromBST(root.l, val);
    }
    else if(val > root.data){
        root.r = delNodeFromBST(root.r, val);
    }
    else {
        if(root.l==null || root.r== null){
            return root.l==null? root.r: root.l;
        }
        node max = findMax(root.l);
        root.data = max.data;
        root.l= delNodeFromBST(root.l, max.data);
    }
    return root;
}

//############## LCA of BST ################
public static node LCAofBST(node root, int a, int b) {
    if(root==null) return null;
  
    if(a>b){
        int c= a;
        a=b;
        b=c;
    }
    if(root.data<a){
        return LCAofBST(root.r, a,b);
    }
    else if(root.data > b){
        return LCAofBST(root.l, a,b);
    }
    else{
        if(find(root,a) && find(root,b)){
            return root;
        }
        return null;
        
    }
    
} 
//############# print in range #############
public static void printInRange(node root, int a, int b) {
    if(root==null) return ;
  
    if(a>b){
        int c= a;
        a=b;
        b=c;
    }
    if(root.data<a){
        printInRange(root.r, a,b);
    }
    else if(root.data > b){
        printInRange(root.l, a,b);
    }
    else{
        System.out.print(root.data+ " ");
        printInRange(root.r, a, b);
        printInRange(root.l, a, b);
        
    }
    
}
//############# find in BST ##############
public static boolean find_bst(node root, int data){
    if(root==null)return false;
    if(root.data == data){
        return true; 
    }
    if(data< root.data){
        return find_bst(root.l, data);
    }
    else{
        return find_bst(root.r, data);
    }
}

//############ BST from preorder ##################
static int idx=0;
public static node BSTFromPreorder(int[]preorder,int lb,int ub, int elem) {
    if(ub<elem || lb>elem ||idx==preorder.length){
        return null;
    }
    node root = new node(preorder[idx],null,null);
    idx++;
    if(idx < preorder.length){
    root.l= BSTFromPreorder(preorder,lb,root.data,preorder[idx]);
    }
    if(idx < preorder.length){
    root.r= BSTFromPreorder(preorder,root.data,ub,preorder[idx]);
    }
    return root;
 
}
//######### height from preorder w/o constructing tree #############
static int i=0;
public static int HeightFromPreorder(int[]preorder,int lb,int ub, int elem) {
    if(ub<elem || lb>elem ||i==preorder.length){
        return -1;
    }

    elem = preorder[i];
    i++;
    int lh=-1,rh=-1;
    if(i < preorder.length){
        lh = HeightFromPreorder(preorder,lb,elem,preorder[i]);
    }
    if(i < preorder.length){
        rh =  HeightFromPreorder(preorder,elem,ub,preorder[i]);
    }
    return Math.max(lh,rh)+1;
}




}