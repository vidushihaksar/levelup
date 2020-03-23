public class a{
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        Node node=create(arr);
        
    }
    public static class Node{
        int data;
        Node left=null;
        Node right=null;

        Node(int data, Node left ,Node right){
             this.data=data;
             this.left=left;
             this.right=right;

        }

    }
    static int idx=0;
    public static Node create(int []arr){
        if (idx==arr.length || arr[idx]==-1){
         idx++;
         return null;
        }
        Node nnode = new Node(arr[idx],null,null);
        idx++;
        nnode.left=create(arr);
        nnode.right=create(arr);
        return nnode;
    }


    public static void display(Node node){
         if(node==null)
            return ;

        String str=" ";
        str += node.left==null?"-1": node.left.data;
        str += "->"+node.data+"<-";
        str += node.right==null?"-1":node.right.data;
        System.out.println(str);
        display(node.left);
        display(node.right);
     }
}