public class LCA{

    public static void main(String[] args){
        // int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, -1,-1};
        // TreeNode root = createTreefromPreorder(arr);
        // //LCA-2
        // boolean ans = LCA_02(root,30,90);
        // if(LCA_node!=null) {System.out.println(LCA_node.data);}
        // else{
        //     System.out.println("no LCA");
        // }

        int[] arr1 ={6,2,0,-1,-1,4,3,-1,-1,5,-1,-1,8,7,-1,-1,9,-1,-1};
        TreeNode root = createTreefromPreorder(arr1);
        //lca in bst
        LCA_inBST(root,2,10);
        System.out.println(lca_node.data);
       
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
//############# createTreefromPreorder $################# 
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
//############# LCA 2 (SELF DONE) #####################
    static TreeNode LCA_node = null; 
    public static boolean LCA_02(TreeNode node, int data1,  int data2) {
        if(node== null)return false;

        boolean selfdone= false;
        if(node.data == data1 || node.data == data2 ){
             selfdone = true;
        }
    
        boolean l = LCA_02(node.left, data1, data2);
        boolean r = LCA_02(node.right, data1, data2);

        if( (l && r) || (l && selfdone) || (r && selfdone)){
            LCA_node = node;
            return true;
        }
        return l || r || selfdone;
    }

//########## LCA IN BST ##################
static TreeNode lca_node =null;
public static void LCA_inBST(TreeNode root, int data1, int data2) {
    if(root==null){
        return;
    }
    if(data1 > root.data){
        LCA_inBST(root.right, data1, data2);
    }
    else if(data2 < root.data){
        LCA_inBST(root.left, data1,data2);
    }
    else{
        lca_node = root;
    }
}
}