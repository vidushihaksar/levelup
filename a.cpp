 #include<iostream>
 #include<conio.h>
 #include<vector>
  using namespace std;
  
// // vector<vector<int>> dir={{0,-1},{0,1},{-1,0},{1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
// // vector<string> dir_path={"L","R","U","D","Ld","Rd","Lu","Rn"};
// vector<vector<int>> dir ={{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
// vector<string> dir_path={"U", "D", "R", "L","Lu","Ru","Ld","Rd"};
// vector<vector<int>> island={{1,1,0,0,0}, {0,1,0,0,1}, {1,0,0,1,1},{0,0,0,0,0},{1,0,1,0,1}};
// //vector<vector<int>> island={{1,0,0,0,0}, {0,1,0,0,1}, {1,0,0,1,1},{0,0,0,0,0},{1,0,1,01}};

// int jump =1;
// bool issafe(int r ,int c, vector<vector<int>>&board){
//     if(r<0||c<0||r>=board.size()||c>=board.size()||island[r][c]==0||board[r][c]==1){
//         return false; }
//     else
//     {
//         return true;
//     }
// }

// void noofisland(vector<vector<int>> & board,int sr,int sc ,int er,int ec,string ans)
// {
//     if(ans!=""){
//         cout<<ans<<endl;
    
//     }

//    island[sr][sc]=0;
//    board[sr][sc]=1;

//    for(int i=0;i<dir.size();i++){
//        int nsr=sr+jump*dir[i][0];
//        int nsc=sc+jump*dir[i][1];

//        if(issafe(nsr,nsc,board)){
//            island[nsr][nsc]=0;
//           noofisland(board,nsr,nsc,er,ec,ans+dir_path[i]);
//          }
       
//    }
//    board[sr][sc]=0;

// }

// int main(){
//     vector<vector<int>> board(5,vector<int>(5,0)); 
//     int count = 0;
//     for (int i = 0; i < island.size(); i++)
//     {
//         for (int j = 0; j < island[0].size(); j++)
//         {
//             if (island[i][j] == 1)
//             {
//                 count++;
//                 noofisland(board,i,j,4,4,"");
//             }
//         }
//     }
//     cout<<count<<endl;
// }
// /*/////////////////////////////////////////////////////////////////

// int row=4;
// vector<bool> colArrr(4);
// vector<bool> rowArr(4);
// vector<bool> diag_1(7);
// vector<bool> diag_2(7);
// bool isQueenSafe( int r, int c)
// {
//     if(!colArrr[c] && !rowArr[r]!=0 && diag_1[r+c]!=0 && diag_2[r-c+(boxes.size()-1)]!=0){
//         return false;
//     }

//     return true;
// }

// int queen2DCombination(vector<vector<bool>> &boxes, int bn, int qpsf, int tnq, string ans)
// {
//     if (qpsf == tnq)
//     {
//         cout << ans << endl;
//         return 1;
//     }
//     int count = 0;
//     for (int i = bn; i < boxes.size() * boxes[0].size(); i++)
//     {
//         int r = i / boxes[0].size();
//         int c = i % boxes[0].size();
//         if (!boxes[r][c] && isQueenSafe(boxes, r, c))
//         {   colArrr[c]=1;
//             rowArr[r]=1;
//             diag_1[r+c]=1;
//             diag_2[r+c]=1;
//             boxes[r][c] = true;
//             count += queen2DCombination(boxes, i + 1, qpsf + 1, tnq, ans + "(" + to_string(r) + ", " + to_string(c) + ") ");
//             boxes[r][c] = false;
//         }
//     }

//     return count;
// }
// int nqueen_bestwala(int row,int tnq,string ans){
//     if(tnq==0){
//         cout<<ans<<endl;
//         return 1;
//     }
//     int count = 0;
//     for(int col=0;col<col;col++){
//         if(isqueenSafe_bit(row,col))
//         {
//             mark_UnMark_Queen_In_bit_wala_array(row,col);
//             count+= nqueen_bestwala(row+1,tnq-1,ans+"("+ to_string(row))
//         }
//     }
// }

// //############# rat in maze
// */


//https://www.rapidtables.com/convert/number/binary-to-decimal.html

// bool isSafeToPlaceNumber(vector<vector<int>> &board, int num, int x, int y)
// {
//     //row
//     for (int c = 0; c < 9; c++)
//     {
//         if (board[x][c] == num)
//             return false;
//     }

//     //col
//     for (int r = 0; r < 9; r++)
//     {
//         if (board[r][y] == num)
//             return false;
//     }

//     //matrix
//     int r = (x / 3) * 3;
//     int c = (y / 3) * 3;
//     for (int i = 0; i < 3; i++)
//     {
//         for (int j = 0; j < 3; j++)
//         {
//             if (board[r + i][c + j] == num)
//                 return false;
//         }
//     }

//     return true;
// }


// int sudoku_01(vector<vector<int>> &board,  int idx)
// {
//     if (idx == 81)
//     {
//         for (vector<int> ar : board)
//         {
//             for (int ele : ar)
//             {
//                 cout << ele << " ";
//             }
//             cout << endl;
//         }
//         cout << endl;
//         return 1;
//     }

//     int i = idx/ 9;
//     int j = idx % 9;
//     int count=0;

//     if(board[i][j]==0){

//         for (int num = 1; num < 10; num++)
//         {
//              if (isSafeToPlaceNumber(board, num, i, j))
//               {
//                    board[i][j] = num;
//                    count+= sudoku_01(board, idx + 1);
//                    board[i][j] = 0;
//                }
//         }
//     }
//     else{
//          count+= sudoku_01(board, idx + 1);

//         }
//         return count;
    
// }