
import java.util.ArrayList;
public class verticalOdr {
    public static void main(String[] args) {
        int[] ar={0,2,3,4,-1,7,10,-1,-1,8,-1,-1,5,6,11,-1,-1,9,-1,-1,-1,-1,1,-1,-1};
        node root = createTreefromPreorder(ar);
        display(root);
        int lw =width(root,true);
        int  rw = width(root,false);
         System.out.println(lw + " "+rw);
        // System.out.println(lw+rw+1);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < lw+rw+1; ++i) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            arr.add(x);
          }
           
        // verticalOrder(root,arr, lw);
        // for(ArrayList<Integer> small: arr){
        //     System.out.println(small);
        // }
        verticalSum(root, arr, lw);
        System.out.print("using ArrayList : ");
        System.out.println(ans);

        //###### vertical sum using DLL ############
        LinkedList ll =new LinkedList(0,null,null);
        verticalSum_DLL(root, ll);
        while(ll.left!=null){
            ll = ll.left;
        }
        System.out.print("DLL : ");
        while (ll != null) { 
            System.out.print(ll.data +" "); 
            ll = ll.right; 
        } 

        //###### diagonal sum using DLL #########
        LinkedList ll1 =new LinkedList(0,null,null);
        diagonalSum_DLL(root,ll1);
        while(ll1.left!=null){
            ll1 = ll1.left;
        }
        System.out.print("\ndiagonal DLL : ");
        while (ll1 != null) { 
            System.out.print(ll1.data +" "); 
            ll1 = ll1.right; 
        } 


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

    //######## width #############################
    public static int width(node nnode, boolean isLeftWidth) {
        if (nnode == null)
            return -1;

        int left = width(nnode.l, isLeftWidth) + (isLeftWidth ? 1 : -1);
        int right = width(nnode.r, isLeftWidth) + (isLeftWidth ? -1 : 1);

        return Math.max(left, right);
    }
    
    //######### vertical sum ###############################
    public static void verticalOrder_for_sum(node root,ArrayList<ArrayList<Integer>> arr, int lw) {
        if(root==null) return;
        
        if(arr.get(lw)!=null){
            ArrayList<Integer>g = arr.get(lw);
            g.add(root.data);
        }
        if(arr.get(lw)==null){
        ArrayList<Integer> a =new ArrayList<>();
        a.add(root.data);
        arr.add(lw,a);
        }
        
        verticalOrder_for_sum(root.l, arr, lw-1);
        verticalOrder_for_sum(root.r, arr,lw+1);
        
    }
    static int sum =0;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void verticalSum(node root,ArrayList<ArrayList<Integer>> arr, int lw) {
        verticalOrder_for_sum(root,arr,lw);
        for(ArrayList<Integer> small : arr){
            sum= 0;
            for(int n: small){
                sum+=n;
            }
            ans.add(sum);
        }
    }

    //########## vertical sum DLL ###############
    public static class LinkedList{
        int data = 0;
        LinkedList right= null;
        LinkedList left= null;

        LinkedList(int data,LinkedList left, LinkedList right)
        {   this.data= data;
            this.left = left;
            this.right = right;
        }
    }

    public static void verticalSum_DLL(node root, LinkedList ll) {
        if(root==null){
            return;
        }
        ll.data = ll.data + root.data;

        if(root.l != null){
            if(ll.left == null){
                ll.left = new LinkedList(0, null,null);
                ll.left.right = ll;
            }
            verticalSum_DLL(root.l, ll.left);
        }
        
        if(root.r != null){
            if(ll.right == null){
                ll.right = new LinkedList(0, null,null);
                ll.right.left = ll;
            }
            verticalSum_DLL(root.r, ll.right);
        }
    }


    //############# diagonal sum using DLL ##################
    public static void diagonalSum_DLL(node root, LinkedList ll) {
        if(root==null){
            return;
        }
        ll.data = ll.data + root.data;

        if(root.l != null){
            if(ll.left == null){
                ll.left = new LinkedList(0, null,null);
                ll.left.right = ll;
            }
            diagonalSum_DLL(root.l, ll.left);
        }
        
        if(root.r != null){
            // if(ll.right == null){
            //     ll.right = new LinkedList(0, null,null);
            //     ll.right.left = ll;
            // }
            diagonalSum_DLL(root.r, ll);
        }
    }
}