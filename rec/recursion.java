import java.util.ArrayList;
public class recursion{

    public  static void main(String[] args) {
        solve();
    }
    public static void solve(){
        // int f = fact(5);
        // System.out.println("factorial is :"+ f);
        // int [] b ={2,5,6,6,8,6,7};

        // int [] a= allIndex(b,0,6,0);
        // for (int i =0;i<a.length;i++){
        //     System.out.print(a[i]+" ");
        // }

        // System.out.println("\n"+fibonacci_1(4));
        // fibonacci_2(5,0,1);
        String a ="10112";
        String b = new String();
        // System.out.println(subsequence_1(a,b));
        // ArrayList<String> ans = subsequence_2(a);
        // System.out.println(ans);
        System.out.println(nokiaKeyPad_02(a,b));
        // vector<vector<int>> board(3, vector<int>(3, 0));
        // System.out.print(board.size());
        // ArrayList<String> ans = nokiaKeyPad_01(a);
        // System.out.println(ans);
        //System.out.println(handlePermutation(a,""));


    }

//########## factorial ################
public static int fact(int n) {
        if(n<=1){ return n;}
        return fact(n-1)*n; 
    }
//############ return all index ########3
public static int[] allIndex(int[] arr, int idx, int data, int count) {
     if(arr.length==idx){
        int a[]=new int[count];
        return a;
     }

     if(arr[idx]==data){
        count++;
     }
     int recans[]=allIndex(arr ,idx+1, data,count);
     if(arr[idx]==data){
        recans[count-1]=idx;
     }
     return recans;
     }

//########### fibonacci_1 ##################3
public static int fibonacci_1(int n) {
    if(n<=1){
        return n;
    }
    return fibonacci_1(n-1)+fibonacci_1(n-2);
    
}
//################ fibonacci_2 #########
public static void fibonacci_2(int n, int a, int b) {
    if(n<0){
        return;
    }
    System.out.print(a+" ");
    fibonacci_2(n-1,b,a+b);
    
}
//############## subsequence void type #########33
public static int subsequence_1(String str,String ans) {
    if(str.length()==0){
        System.out.println(ans);
        return 1;
    }
    String nstr= str.substring(1);
    char ch = str.charAt(0);
    
    return subsequence_1(nstr , ans+ch) + subsequence_1(nstr, ans);
    
}
//##########3 subsequence 2 return type ##########
public static ArrayList<String> subsequence_2(String str) {
    if(str.length()==0){
        ArrayList<String> base = new ArrayList<>();
        base.add(" ");
        return base;
    }
    String nstr= str.substring(1);
    char ch = str.charAt(0);
    ArrayList<String> recans= subsequence_2(nstr);
    ArrayList<String> myStr = new ArrayList<>(recans);
    int size= myStr.size();
    for (int i = 0; i < size; i++) {
        myStr.add(ch + myStr.get(i));
    }
    return myStr;

}

//############## keypad return type(including 10 and 11) ##############3
static String[] words = { "$^%", ";:.,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "+-/", "@#*" };
public static ArrayList<String>nokiaKeyPad_01(String str) {
    if(str.length()==0){
        ArrayList<String> base = new ArrayList<>();
        base.add("");
        return base;
    }
    int idx =  str.charAt(0)-'0';
    String nstr= str.substring(1);
    String s=words[idx];
    ArrayList<String> recans= nokiaKeyPad_01(nstr);
    ArrayList<String> mystr=new ArrayList<>();
    for(int i=0;i<s.length();i++){
        for(String j:recans){
            mystr.add(s.charAt(i)+j);
        }
    }
    if (str.length() > 1) {
        idx = idx * 10 + (str.charAt(1) - '0');
        if (idx >= 10 && idx <= 11) {
            s= words[idx];
            recans= nokiaKeyPad_01(str.substring(2));
            for (int i = 0; i < s.length(); i++) {
                for (String j : recans) {
                    mystr.add(s.charAt(i) + j);
                }
            }
        }

    }
    
    return mystr;
}
//##################### keypad void type ##############3333333
public static int nokiaKeyPad_02(String str, String ans) {
    if (str.length() == 0) {
        System.out.println(ans);
        return 1;
    }

    String nstr = str.substring(1); // str.substr(1);
    int idx = str.charAt(0) - '0'; // str[0];
    String word = words[idx];

    int count = 0;
    for (int i = 0; i < word.length(); i++) {
        count += nokiaKeyPad_02(nstr, ans + word.charAt(i));
    }
    if (str.length() > 1) {
        idx = idx * 10 + (str.charAt(1) - '0');
        if (idx >= 10 && idx <= 11) {
            word = words[idx];
            for (int i = 0; i < word.length(); i++) {
                count += nokiaKeyPad_02(str.substring(2), ans + word.charAt(i));
            }

        }
    }


    return count;
}
//############# permutation_01 ##################
public static int permutation(String str,String ans){
    if (str.length() == 0) {
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i); 
        String nstr = str.substring(0,i)+str.substring(i+1); 
        count+=permutation(nstr,ans+ch);
    }
    return count;
}
//############ handle permutation eg:aba ##############
public static int handlePermutation(String str,String ans){
    if (str.length() == 0) {
        System.out.println(ans);
        return 1;
    }
    int count=0;
    boolean [] alpha = new boolean[26];
    for(int j=0;j<alpha.length;j++){
        alpha[j]=false;
    }
    
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i); 
        if(!alpha[ch-'a']){
            alpha[ch-'a']=true;
            String nstr = str.substring(0,i)+str.substring(i+1); 
            count+=handlePermutation(nstr,ans+ch);
        }
      
    }
    return count;
}


}

    