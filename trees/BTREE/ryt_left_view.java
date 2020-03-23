import java.util.LinkedList;

public class ryt_left_view{
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1,  100,-1,-1, -1 };
        node root = createTreefromPreorder(arr);
        display(root);
        System.out.println("-------------\nleftview_01 :  ");
        leftView(root, 0);
        System.out.println("\n-------------\nrytview_01");
        rytView(root,0);
        System.out.println("\n-------------\nleftview_02");
        leftView_02(root);
        System.out.println("\n-------------\nrytview");
        rytView_02(root);
        System.out.println("\n-------------\nboth side view");
        both_Side_View(root);

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

    //######## left view ###############
    static int leftlevel=-1;
    public static void leftView(node root, int level) {
        if(root == null) return ;

        if(leftlevel < level){
            System.out.print(root.data + " ");
            leftlevel = level;
        }

        leftView(root.l, level+1);
        leftView(root.r,  level+1);
        
    }

    //###### right view ##########
    static int rytlevel=-1;
    public static void rytView(node root, int level) {
        if(root == null) return ;

        if(rytlevel < level){
            System.out.print(root.data + " ");
            rytlevel = level;
        }
        rytView(root.r,  level+1);
        rytView(root.l, level+1);
        
    }

    //########## left view -2 with the help of levelorder traversal ############
    static node prev=null;
    public static void leftView_02(node root) {
        LinkedList<node> q = new LinkedList<>();
        q.addLast(root);
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
               node n = q.removeFirst();
               if(prev == null){ 
                   prev=n;
                   System.out.print(prev.data+" ");
               }
               if(n.l !=null){q.addLast(n.l); }
               if(n.r !=null){q.addLast(n.r); }
            
            }
            prev=null;
         //System.out.print("\n");
        }
    }

    //########## right view -2 with the help of levelorder traversal ############
    static node pre=null;
    public static void rytView_02(node root) {
        LinkedList<node> q = new LinkedList<>();
        q.addLast(root);
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
               node n = q.removeFirst();
               pre=n;
               if(n.l !=null){q.addLast(n.l); }
               if(n.r !=null){q.addLast(n.r); }
            
            }
           
         System.out.print(pre.data+" ");
        }
        
    }
    //########## both side view -2 with the help of levelorder traversal ############
    static node rt=null;
    static node lt = null;
    public static void both_Side_View(node root) {
        LinkedList<node> q = new LinkedList<>();
        q.addLast(root);
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
               node n = q.removeFirst();
               if(rt==null && size!=0){
                   rt=n;
                   System.out.print(rt.data+" ");
               }
               lt=n;
               if(n.l !=null){q.addLast(n.l); }
               if(n.r !=null){q.addLast(n.r); }
            
            }
         rt=null;  
         System.out.print(lt.data+"\n");
        }
        
    }






}