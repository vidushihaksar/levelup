import java.util.HashMap;
import java.util.ArrayList;

class sumpath {
    public static void main(String[] args) {
        // int[] arr = { 0,2, -2, 2,-1,-1 , -1,-1,2,-1,-1 };
        // node root = createTreefromPreorder(arr);
        // display(root);
        
        // ArrayList<ArrayList<Integer>> sumpath = pathSum_2a(root,70);
        // System.out.println(sumpath);
        // ArrayList<ArrayList<Integer>> ans= new ArrayList<>();    
        // ArrayList<Integer> base = new ArrayList<>();
        // pathSum_2b(root,ans,base,70);

        // //sum_path_III
        // HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);
        // int c= pathSum_III(root,0,sum,map);
        // System.out.println(c);
        
        //##### leaf to leaf ###############
    //    int[] arr = {-15,-1,6,3,-1,-1,9,-1,0,4,-1,-1,-2,10,-1,-1,-1};
    //    // int[] arr={0,-1,-1};
    //     node root = createTreefromPreorder(arr);
    //     display(root);
    //     int s = leafToLeafSum(root);
    //     System.out.println(Max_leaftoleaf);

        //#### node to node #############
        int[] arr = {-10,9,-1,-1,20,15,-1,-1,7,-1,-1};
        node root = createTreefromPreorder(arr);
        display(root);
        int s = nodeToNode(root);
        System.out.println(maxPath);

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

//#################### Sum path- return true if path having sum equal to target exists #############
public static boolean hasSumPath(node n, int target){
    if(n==null)return false;
    if(n.l == null && n.r == null && target-n.data==0){
     
        return true;
    }    
    boolean result = false;

    result =  result || hasSumPath(n.l , target-n.data  );
    result =  result || hasSumPath(n.r , target-n.data );

    return result;
    }
//##################### Sum path_2(A) #######################
public static ArrayList<ArrayList<Integer>> pathSum_2a(node n,int tar) {
    if(n== null)return null;
    if(n.l==null && n.r==null && tar-n.data==0){
        ArrayList<ArrayList<Integer>> base=new ArrayList<>();
        ArrayList<Integer> small = new ArrayList<>();
        small.add(n.data);
        base.add(small);
        return base;

    }
    ArrayList<ArrayList<Integer>> myans=new ArrayList<>();

    ArrayList<ArrayList<Integer>> leftt = pathSum_2a(n.l , tar-n.data);
    if(leftt!= null){
        for(ArrayList<Integer> s :leftt){
            s.add(0,n.data);
            myans.add(s);
        }
    }
    ArrayList<ArrayList<Integer>> rightt = pathSum_2a(n.r , tar-n.data);
    if(rightt!= null){
        for(ArrayList<Integer> s :rightt){
            s.add(0,n.data);
            myans.add(s);
        }
    }
    return myans;
}
//##################### Sum path_2(B) #######################
public static void pathSum_2b(node n,ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> base ,int tar) {
    if(n== null)return ;
    if(n.l==null && n.r==null && tar-n.data==0){
        ArrayList<Integer> small = new ArrayList<>(base);
        small.add(n.data);
        ans.add(small);
        System.out.println(ans);
    }
    base.add(n.data);
    pathSum_2b(n.l, ans, base, tar-n.data);
    pathSum_2b(n.r, ans, base, tar-n.data);
    base.remove(base.size()-1);
}

//########### sumPath_III  ###################################
    public static int pathSum_III(node n, int prefixSum, int tar, HashMap<Integer, Integer> map) {
        if (n == null)
            return 0;

        prefixSum +=n.data;
        int count = map.getOrDefault(prefixSum - tar, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        //map.put(prefixSum, 1);
        count += pathSum_III(n.l, prefixSum, tar, map);
        count += pathSum_III(n.r, prefixSum, tar, map);

        if (map.get(prefixSum) == 1) {
            map.remove(prefixSum);
        } else {
            map.put(prefixSum, map.get(prefixSum) - 1);
        }
        return count;
    }

//############## leaf to leaf ##############################
static int Max_leaftoleaf= (int)-1e8;   
public static int leafToLeafSum(node node1) {
    if (node1 == null)
        return 0;
    int leftNodeToLeaf = leafToLeafSum(node1.l);
    int rightNodeToLeaf = leafToLeafSum(node1.r);
    
    if(node1.l != null && node1.r!=null){
        Max_leaftoleaf = Math.max(Max_leaftoleaf, leftNodeToLeaf + rightNodeToLeaf + node1.data);
        return Math.max(rightNodeToLeaf, leftNodeToLeaf) + node1.data;
    }
    return (node1.l == null? rightNodeToLeaf: leftNodeToLeaf) + node1.data;
}

//########## node to  node ###############################
static int maxPath = (int)-1e8;
public static int nodeToNode(node root) {
    if(root==null) return 0;
    
    int leftNodeToLeaf= nodeToNode(root.l);
    int rightNodeToLeaf= nodeToNode(root.r);

    int max_=Math.max(leftNodeToLeaf , rightNodeToLeaf )+ root.data;
    
    maxPath = Math.max(maxPath, (leftNodeToLeaf + rightNodeToLeaf + root.data ));
    maxPath = Math.max(Math.max(maxPath,max_), root.data);
    
    return Math.max(max_,root.data);
     
 
}
}
