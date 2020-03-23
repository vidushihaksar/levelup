public class avl{
    public static void main(String[] args) {
        Node root=null;
        for(int i=1;i<=10;i++){
            root=addData(root, i*10);

        }
        display(root);
    }

    public static class Node{
        int data =0;
        Node left= null;
        Node right = null;
        int height = 0;
        int balance = 0;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static void display(Node node) {
        if (node == null)
            return;
        String str = "";

        str += node.left == null ? "." : node.left.data;
        str += " -> " + node.data + " <- ";
        str += node.right == null ? "." : node.right.data;
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void updateHeight_balance(Node node) {
        int lh = -1;
        int rh = -1;

        if (node.left != null)
            lh = node.left.height;
        if (node.right != null)
            rh = node.right.height;

        node.height = Math.max(lh, rh) + 1;
        node.balance = lh - rh;
    }
    //########### left - left rotate #########
    public static Node ll(Node x) {
        Node y = x.left;
        Node y_ka_ryt   =y.right;
        y.right = x;
        x.right = y_ka_ryt;

        updateHeight_balance(x);
        updateHeight_balance(y);

        return y;
    }
    //########### right - right rotate #########
    public static Node rr(Node x) {
        Node y = x.right;
        Node y_ka_lft   =y.left;
        y.left = x;
        x.right = y_ka_lft;

        updateHeight_balance(x);
        updateHeight_balance(y);
        
        return y;
    }

    //########## get rotate #################
    public static Node getRotate(Node x) {
        updateHeight_balance(x);
         if(x.balance==2){     //balance= 2 => ll, lr
            Node y = x.left;
            if(y.balance==1)   // ll
            {
                return ll(x);
            }
            else               //lr
            {
                x.left = rr(y);   
                return ll(x);
            }
        }
         else if(x.balance==-2){
            Node y = x.right;
            if(y.balance==-1)   // rr
            {
                return rr(x);
            }
            else                //rl
            {
                x.right = ll(y);
                return rr(x);
            }

        }
        return x;
    }
    //########## add in AVL #################
    public static Node addData(Node root, int data) {
        if (root == null) {
            Node node = new Node(data, null, null);
            return node;
        }

        if (data < root.data) {
            root.left = addData(root.left, data);
        } else {
            root.right = addData(root.right, data);
        }
        root=getRotate(root);
        return root;
    }
    //########### find max ############
    public static Node findMax(Node root) {
        Node rnode = root;
        while(rnode.right!=null){
            rnode = rnode.right;
        }
        return rnode;
    }
    //###### remove node from AVL ##########
    public static Node removeIn_AVL(Node root,int val ) {
        if(root==null) return null;
        if(val < root.data){
            root.left = removeIn_AVL(root.left, val);
        }
        else if(val > root.data){
            root.right = removeIn_AVL(root.right, val);
        }
        else {
            if(root.left==null || root.right== null){
                return root.left==null? root.right: root.left;
            }
            Node max = findMax(root.left);
            root.data = max.data;
            root.left= removeIn_AVL(root.left, max.data);
        }
        root  = getRotate(root);
        return root;
    }
    
}