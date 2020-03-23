import java.util.ArrayList;

public class recoverBST {
    public static void main(String[] args) {
        int[] arr ={1,3,-1,2,-1,-1,-1};
        TreeNode root = createTreefromPreorder(arr);
        display(root);
        recoverTree(root);
        System.out.println("\n Recovered tree\n");
        display(root);
        
    }

//########## Treenode #######################
public static class TreeNode{
    int data;
    TreeNode left=null;
    TreeNode right=null;
    
    TreeNode(int data, TreeNode left , TreeNode right){
        this.data=data;
        this.left=left;
        this.right= right;

    }
}
static int i =0;
public static TreeNode createTreefromPreorder (int[] pre){
   
    if (pre.length==0 || pre[i]==-1){
         i++;
         return null;
    }
    TreeNode n1 = new TreeNode(pre[i], null, null);
    i++;
    n1.left = createTreefromPreorder(pre);
    n1.right = createTreefromPreorder(pre);
    return n1;
}

//##################### display tree ##################
public static void display(TreeNode n){
    if(n== null) return;
    String s="";
    s += n.left== null? "." :n.left.data;
    s += "->" + n.data + "->";
    s += n.right== null? "." :n.right.data;

    System.out.println(s);
    display(n.left);
    display(n.right);
}

//########## O(1)space and O(n)time #########
static TreeNode first,second,prev;
public static void recoverTree(TreeNode node){
    prev = null; first = null; second = null;
      recoverBST1(node);
      if(first!=null){
      int zm  = first.data;
      first.data = second.data;
      second.data = zm;
    }
 }
public static void recoverBST1(TreeNode root) {
    if (root != null ){
    recoverBST1(root.left);
    if (prev != null && root.data < prev.data) {
        second = root;
        if (first == null)
            first = prev;  
    }
    prev = root; 
    recoverBST1(root.right);
    }
} 
   
 /*public static void inorder(TreeNode root, TreeNode[] in) {
        if(root== null) return;
        inorder(root.left);
        int i==0;
        in[i++]= root
        inorder(root,right);

    }
    public static void recover(TreeNode root) {
        TreeNode[] in = new TreeNode[100];
        TreeNode x= new TreeNode(0,null,null);
        TreeNode y= new TreeNode(0,null,null);

        inorder(root, in);
        for(int i= 0 ;i<in.length;i++)
            if(in[i+1]< in[i]){
                y= in[i+1];
                if(x==null){ x= in[0]; }
            }
        }
        int z  = x.data;
        x.data = y.data;
        y.data = z;
    }*/
}