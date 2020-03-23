#include<iostream>
#include<vector>
using namespace std;

//################### factorial ##################
int factorial(int n){
    if(n<=1){
        return n;
    }
   return factorial(n-1)*n;

}
//################## power a^b #############
int power_1(int a,int b){
    if(a==0)return 0;
    if(b==0)return 1;

   return power_1(a,b-1)*a;
}
//################ power better #########
int power_bttr(int a,int b){
    if(a==0)return 0;
    if(b==0)return 1;

    int recans = power_bttr(a,b/2);
    if(b%2==0){ return recans*recans; }
    else return recans*recans*a;

}
//############## print in inc order #########
void printInc(int a,int b){
    if(a>b) return;

    cout<< a <<" ";
    printInc(a+1, b);
}
//########### print in dec ##############3
void printdec(int a,int b){
    if(a==b+1) return;

    printdec(a+1, b);
    cout<< a <<" ";
}
//########## even in inc ,odd in dec ########3
void printEvnOdd(int a, int b){
    if (a == b + 1)
        return;

    if (a % 2 == 0)
        cout << "even: " << a << endl;

    printEvnOdd(a + 1, b);

    if (a % 2 != 0)
        cout << "odd: " << a << endl;
}
//################ print array ###############
void display(vector<int> &arr, int idx){
    if(arr.size()==idx) return;
    cout<<arr[idx]<<" ";
    display(arr ,idx+1);

}
//############ find data in array #############3
bool findData(vector<int> &arr,int idx, int data){
     if(arr.size()==idx) return false;
     if(arr[idx]==data){
         return true;
     }
     findData(arr,idx+1,data);
}
//############# return first index #############
int firstIndex(vector<int>& arr , int idx, int data){
    if(arr.size()==idx) return -1;
     if(arr[idx]==data){
         return idx;
     }
     return firstIndex(arr , idx+1, data);
}
//############## return last index#############3
int lastIndex(vector<int>& arr , int idx, int data){
    if(arr.size()==idx) return -1;
    int li= lastIndex(arr , idx+1, data);
    if(li!=-1)return li;
    if(arr[idx]==data){
         return idx;
     }
}
//############## floodfill for 4 calls ####################
vector<vector<int>> dir_04 ={{-1,0},{1,0},{0,1},{0,-1}};
vector<string> dir_path_04 ={"U", "D", "R", "L"};
int jump=1;
bool isSafe_04(int r, int c, vector<vector<int>> &board){
    if (r < 0 || c < 0 || r >= board.size() || c >= board[0].size() || board[r][c]==1)
        return false;
    return true;
}
int floodfill_04(vector<vector<int>> &board, int sr, int sc, int er, int ec, string ans){
    if(sr==er && sc==ec){
        cout<<ans<<endl;
        return 1;
    }
    board[sr][sc]=1;
    int count=0;
    for(int i=0;i<dir_04.size();i++){
        int nr= sr+ jump* dir_04[i][0];
        int nc= sc+ jump* dir_04[i][1];
        if(isSafe_04(nr,nc,board)){
            count+= floodfill_04(board,nr,nc,er,ec,ans+ dir_path_04[i]);
        }
    }
    board[sr][sc]=0;
    return count;

}
//############# floodfill for 8 calls #########################
vector<vector<int>> dir_08 ={{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
vector<string> dir_path_08 ={"U", "D", "R", "L","Lu","Ru","Ld","Rd"};
//int jump=1;
bool isSafe_08(int r, int c, vector<vector<int>> &board){
    if (r < 0 || c < 0 || r >= board.size() || c >= board[0].size() || board[r][c]==1)
        return false;
    return true;
}
int floodfill_08(vector<vector<int>> &board, int sr, int sc, int er, int ec, string ans){
    if(sr==er && sc==ec){
        cout<<ans<<endl;
        return 1;
    }
    board[sr][sc]=1;
    int count=0;
    for(int i=0;i<dir_08.size();i++){
        int nr= sr+ jump* dir_08[i][0];
        int nc= sc+ jump* dir_08[i][1];
        if(isSafe_08(nr,nc,board)){
            count+= floodfill_08(board,nr,nc,er,ec,ans+ dir_path_08[i]);
        }
    }
    board[sr][sc]=0;
    return count;

}
//############# Maze path (H,V,D)-multi jump #################
vector<vector<int>> dir_maze ={{1,0},{0,1},{1,1}};
vector<string> dir_path_maze ={"V", "H", "D"};
//int jump=1;
bool isSafe_maze(int r, int c, vector<vector<int>> &board){
    if (r < 0 || c < 0 || r >= board.size() || c >= board[0].size() || board[r][c]==1)
        return false;
    return true;
}
int mazePath(vector<vector<int>> &board, int sr, int sc, int er, int ec, string ans){
    if(sr==er && sc==ec){
        cout<<ans<<endl;
        return 1;
    }
    board[sr][sc]=1;
    int count=0;
    for(int i=0;i<dir_maze.size();i++){
        for(int jump=0;jump<board.size();jump++){
            int nr= sr+ jump* dir_maze[i][0];
            int nc= sc+ jump* dir_maze[i][1];
            if(isSafe_maze(nr,nc,board)){
               count+= mazePath(board,nr,nc,er,ec,ans+ dir_path_maze[i]+to_string(jump)+" ");
        }
        }
    }
    board[sr][sc]=0;
    return count;
}
//################ rotten oranges ##########################
vector<vector<int>> dir_rotten ={{-1,0},{1,0},{0,1},{0,-1}};
vector<string> dir_path_rotten ={"U", "D", "R", "L"};
vector<vector<int>> oranges={{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
int jump_ = 1;
bool isSafeForOranges(int r, int c){
    if (r < 0 || c < 0 || r >= oranges.size() || c >= oranges[0].size() || oranges[r][c] == 2 || oranges[r][c] == 0)
        return false;
    return true;
}
void rottenOranges( int sr, int sc, string ans){
   if(ans!=""){
       cout << ans << endl;
   }
    for (int d = 0; d < dir_rotten.size(); d++)
    {
        int nsr = sr + jump * dir_rotten[d][0];
        int nsc = sc + jump * dir_rotten[d][1];
        if (isSafeForOranges(nsr, nsc))
        {
            oranges[nsr][nsc] = 2;
            rottenOranges(nsr, nsc, ans + dir_path_rotten[d] );
        } 
    }
}
//########### rat in maze ########################################
vector<string> dir_rat={{1,0},{0,1}};
vector<string> dir_path_rat={"v", "h"};
vector<vector<int>> rat={{1, 0, 0, 0},{1, 1, 0, 1},{0, 1, 0, 0},{1, 1, 1, 1}};
bool isSafeForRat(vector<vector<int>>&board,int r,int c){
    if(r<0 || c<0 || r>=rat.size() || c>=rat[0].size() || r >= board.size() || c >= board[0].size() || rat[r][c]==0){
        return false;
    }
    return true;
}
int ratInMaze(vector<vector<int>>&board , int sr,int sc,int er,int ec,string ans){
    if(sr==er && sc==ec){
        cout<<ans<<endl;
        return 1;
    }
    board[sr][sc]=1;
    int count=0;
    for(int d=0; d<dir_rat.size() ;d++)
    {
        int nr = sr + jump*dir_rat[d][0];
        int nc = sc + jump*dir_rat[d][1];
        if(isSafeForRat(board,nr,nc)){
            count+= ratInMaze(board,nr,nc,er,ec,ans+dir_path_rat[d]);
        }
    }
    board[sr][sc]=0;
    return count;
}

//################# no of islands #############################
vector<vector<int>> dir_islands ={{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
vector<string> dir_path_islands ={"U", "D", "R", "L","Lu","Ru","Ld","Rd"};
vector<vector<int>> islands ={{1, 1, 0, 0, 0},{0, 1, 0, 0, 1},{1, 0, 0, 1, 1},{0, 0, 0, 0, 0},{1, 0, 1, 0, 1} };
bool isSafeIslands(vector<vector<int>>&board,int r,int c ){
    if(r<0 || c<0 || r >= board.size() || c >= board[0].size() || islands[r][c]==0 || board[r][c]==1){
        return false;
    }
    return true;
}
void noOfIslands( vector<vector<int>>&board, int sr,int sc,int er,int ec,string ans){
    if(ans!=""){
       cout << ans << endl;
    }
    board[sr][sc]=1;
    islands[sr][sc]=0;
    //int count=0;

    for(int d=0; d<dir_islands.size() ;d++)
    {
        int nr = sr + jump*dir_islands[d][0];
        int nc = sc + jump*dir_islands[d][1];
        if(isSafeIslands(board,nr,nc)){
            islands[nr][nc]=0;
            noOfIslands(board,nr,nc,er,ec,ans+dir_path_islands[d]);
        }
    }
    board[sr][sc]=0;
}

void floodfillSet(){
    vector<vector<int>> board(3,vector<int>(3,0)); 
    // cout<<ratInMaze(board,0,0,3,3,"");

    //vector<vector<int>> board(5,vector<int>(5,0)); 
    //cout<< floodfill_04(board,0,0,2,2,"");
    //cout<< floodfill_08(board,0,0,2,2,"");
   // cout<< mazePath(board,0,0,2,2,"");
    int count = 0;
    for (int i = 0; i < oranges.size(); i++)
    {
        for (int j = 0; j < oranges[0].size(); j++)
        {
            if (oranges[i][j] == 2)
            {
                count++;
                rottenOranges(i, j,"");
            }
        }
    }
    cout<<count<<endl;
    // for (int i = 0; i < islands.size(); i++)
    // {
    //     for (int j = 0; j < islands[0].size(); j++)
    //     {
    //         if (islands[i][j] == 1)
    //         {  count++;
    //            noOfIslands(board,i, j,4,4,"");
    //         }
    //     }
    // }
    // cout<<count<<endl;
    
    // //cout<<ratInMaze(board,0,0,3,3,"");
    // vector<vector<bool>> box(4, vector<bool>(4, false));
    // cout << queen2DCombination(box, 0, 0, 4, "") << endl;
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////





//##################  combination ###############################
int combination(int member, int tm, string ans){
    if(member==tm+1){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=member; i<=tm;i++){
        count+=combination(i+1, tm, ans+ to_string(i));

    }
    return count;
}
//################# coin combination infinite ###################
int coinCombinationInfinite(vector<int> &coins , int idx,int target,string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    } 
    int count=0;
    for(int i=idx;i<coins.size() ; i++){
        if(target-coins[i]>=0){
              count+= coinCombinationInfinite(coins, i, target-coins[i],ans+to_string(coins[i]) );
        }
    }
    return count;
}
//####################### coin combination finite ###################
int coinCombinationFinite(vector<int> &coins , int idx,int target,string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    } 
    int count=0;
    for(int i=idx;i<coins.size() ; i++){
        if(target-coins[i]>=0){
              count+= coinCombinationFinite(coins, i+1, target-coins[i],ans+to_string(coins[i]) );
        }
    }
    return count;
}
//################# coin permutation infinite ###################
int coinPermutationInfinite(vector<int> &coins , int idx,int target,string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    } 
    int count=0;
    for(int i=0;i<coins.size() ; i++){
        if(target-coins[i]>=0){
              count+= coinPermutationInfinite(coins, i, target-coins[i],ans+to_string(coins[i]) );
        }
    }
    return count;
}
//################# coin permutation finite ###################
int coinPermutationFinite(vector<int> &coins , int idx,int target,string ans,vector<int> &v){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    } 
    int count=0;
    for(int i=0;i<coins.size() ; i++){
        if(target-coins[i]>=0 && v[i]!=1){
              v[i]=1;
              count+= coinPermutationFinite(coins, i, target-coins[i],ans+to_string(coins[i]), v);
               v[i]=0;
        }
    }
   
    return count;
}
//################## queen combination ###############################
// tnb=total no of boxes, bn= box no, tnq=total no of queen, qpsf=queen placed so far
int queenCombination(int tnb,int bn,int tnq,int qpsf,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=bn; i<tnb; i++){
        count+= queenCombination(tnb, i+1, tnq, qpsf+1, ans+"b"+to_string(i)+"q"+to_string(qpsf)+" ");
    }
    return count;
}
//################## queen permuatation finite ###############################
// tnb=total no of boxes, bn= box no, tnq=total no of queen, qpsf=queen placed so far
int queenPermutation(vector<bool>&visited,int bn,int tnq,int qpsf,string ans){
    if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0; i<visited.size(); i++){
        if(!visited[i]){
            visited[i]=true;
            count+= queenPermutation(visited, i+1, tnq, qpsf+1, ans+"b"+to_string(i)+"q"+to_string(qpsf)+" ");
            visited[i]=false;
        }
    }
    return count;
}

//##################### 2D queen combination #####################################
// vector<vector<int>> q_dir = {{0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};
// bool isQueenSafeForCombination(vector<vector<bool>> &queen, int r, int c){
//     for (int d = 0; d < q_dir.size(); d++)
//     {
//         for (int jump = 1; jump <= queen.size(); jump++)
//         {
//             int nr = r + jump * q_dir[d][0];
//             int nc = c + jump * q_dir[d][1];
//             if (nr >= 0 && nc >= 0 && nr < queen.size() && nc < queen[0].size())
//             {
//                 if (queen[nr][nc])
//                     return false;
//             }
//             else
//                 break;
//         }
//     }
//     return true;
// }
// int queen2Dcombination(vector<vector<bool>> &queen, int bn,int tnq, int qpsf, string ans){
//      if(qpsf==tnq){
//         cout<<ans<<endl;
//         return 1;
//     }
//     int count=0;
//     for(int i=bn; i<queen.size()*queen[0].size(); i++){
//         int r = i/queen.size();
//         int c = i%queen[0].size();
//         if(isQueenSafeForCombination(queen,r,c)){
//             queen[r][c]=true;
//             count+= queen2Dcombination(queen, i+1, tnq, qpsf+1, ans+"("+to_string(r)+to_string(c)+")");
//             queen[r][c]=false;
//         }
// }
//     return count;
// }
//##################### 2D queen permutation #####################################

vector<vector<int>> q_dir = {{0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {0, 1}, {1, 0}, {1, 1}, {1, -1}};
bool isQueenSafeForPermutation(vector<vector<bool>> &queen, int r, int c){
    for (int d = 0; d < q_dir.size(); d++)
    {
        for (int jump = 1; jump <= queen.size(); jump++)
        {
            int nr = r + jump * q_dir[d][0];
            int nc = c + jump * q_dir[d][1];
            if (nr >= 0 && nc >= 0 && nr < queen.size() && nc < queen[0].size())
            {
                if (queen[nr][nc])
                    return false;
            }
            else
                break;
        }
    }
    return true;
}
int queen2Dpermutation(vector<vector<bool>> &queen, int bn,int tnq, int qpsf, string ans){
     if(qpsf==tnq){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=0; i<queen.size()*queen[0].size(); i++){
        int r = i/queen[0].size();
        int c = i%queen[0].size();
        if(!queen[r][c] && isQueenSafeForPermutation(queen,r,c)){
            queen[r][c]==true;
            count+= queen2Dpermutation(queen, i+1, tnq, qpsf+1, ans+"("+to_string(r)+to_string(c)+")");
            queen[r][c]==false;
        }
    }
    return count;
}

void PandC(){
    //cout<<combination(1, 5,"");
    vector<int> coins={2,3,5,7};
    //cout<<coinCombinationInfinite(coins,0,10,"");
    //cout<<coinCombinationFinite(coins,0,10,"");
    //cout<<coinPermutationInfinite(coins,0,10,"");
    vector<int> v(4,0);
   // cout<<coinPermutationFinite(coins,0,10,"",v);
   //cout<<queenCombination(5,0,3,0,"");
   vector<bool>visited(5,false);
   //cout<<queenPermutation(visited,0,3,0,"");
   vector<vector<bool>> queen(4,vector<bool>(4,false));
  // cout<<queen2DCombination(queen, 0, 4, 0, "");
   //cout<<queen2Dpermutation(queen, 0, 4, 0, "");





}

void solve(){
   floodfillSet();
    //PandC();

    // int fact = factorial(5);
    // cout<<"Fatorial is "<<fact;

    // int pwr = power_1(2,2);
    // cout<<"\npower is "<<pwr;

    // int pwr_bttr = power_bttr(2,3);
    // cout<<"\npower is "<<pwr_bttr;
    // cout<<"\nIncresing order id :\n ";
    // printInc(1,10);
    // cout<<"\ndecreasing order is :\n ";
    // printdec(1,10);
    // cout<<endl;
    // printEvnOdd(1,10);
     vector<int> arr = {11,55,33,44,55,55,66,55};
    // cout<<"Array is : \n";
    // display(arr , 0);
    // bool ans = findData(arr,0,65);
    // cout<<"\ndata is present "<<ans;
    // int fi= firstIndex(arr,0,55);
    // cout<<"first index is "<<fi;
    // int li= lastIndex(arr,0,55);
    // cout<<"\nlast index is : "<<li;
    // int ar=[6,6,78,6,6,6];
    // int ans[]= allIndex(ar,0,6,0);
    // for(i=0;i<ans.size();i++){
    //     cout<<ans[i]<<" ";
    // vector<vector<int>> board(3, vector<int>(3, 0));
    //     cout<<board.size();
    //     vector<vector<int>> dir = {{0, 1}, {1, 0}, {1, 1}};
    //     cout<<dir.size();
    

}
int main(){
    solve();
}