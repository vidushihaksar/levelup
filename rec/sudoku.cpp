#include<iostream>
#include<vector>
using namespace std;


bool isSafeToPlaceNumber(vector<vector<int>> &board, int num, int x, int y){
    //row
    for(int c=0; c<9; c++){
        if(board[x][c]==num){
            return false;
        }
    }
    //col
    for(int r=0; r<9; r++){
        if(board[r][y]==num){
            return false;
        }
    }
    //matrix
    int r = (x/3)*3;
    int c = (y/3)*3;
    for(int i= 0 ; i<3; i++){
        for(int j= 0 ; j<3; j++){
            if(board[r+i][c+j]==num){
                return false;
            }
        }
    }
     return true;
 }
 
 





//########## sudoku with multiple ans ##########################

/*int sudoku_01(vector<vector<int>> &board, int idx){
    if (idx == 81)
    {
        for (vector<int> ar : board)
        {
            for (int ele : ar)
            {
                cout << ele << " ";
            }
            cout << endl;
        }
        cout << endl;
        return 1;
    }

    int i = idx / 9;
    int j = idx % 9;
    int count=0;

    if(board[i][j]==0){
        for(int num=1; num<10; num++){
            if(isSafeToPlaceNumber(board, num, i, j)){

                board[i][j]=num;
                count+= sudoku_01(board, idx+1);
                board[i][j]=0;

            }
        }
    }
    else{
        count+= sudoku_01(board, idx+1);
    }
    return count;
}*/

//############# sudoku single ans ######################3
/*bool sudoku_01(vector<vector<int>> &board, int idx){
    if (idx == 81)
    {
        for (vector<int> ar : board)
        {
            for (int ele : ar)
            {
                cout << ele << " ";
            }
            cout << endl;
        }
        cout << endl;
        return true;
    }

    int i = idx / 9;
    int j = idx % 9;
    int count=0;
    bool res = false;

    if(board[i][j]==0){
        for(int num=1; num<10; num++){
            if(isSafeToPlaceNumber(board, num, i, j)){

                board[i][j]=num;
                res= res || sudoku_01(board, idx+1);
                board[i][j]=0;

            }
        }
    }
    else{
        res = res || sudoku_01(board, idx+1);
    }
    return res;
}*/

//########### optimized no of calls + bits ###############
bool sudoku_01(vector<vector<int>> &board, int idx, vector<int> &calls, vector<int>&row, vector<int>&col, vector<vector<int>>&mat){
    if (idx == calls.size())
    {
        for (vector<int> ar : board)
        {
            for (int ele : ar)
            {
                cout << ele << " ";
            }
            cout << endl;
        }
        cout << endl;
        return true;
    }

    int i = calls[idx] / 9;
    int j = calls[idx] % 9;
    //int count=0;
    bool res = false;

    for(int num=1; num<10; num++){
        int mask= (1<<num) ;
        if( (mask & row[i])==0 && (mask & col[j])==0 && (mask & mat[i/3][j/3])==0 ){
            row[i]^=mask;
            col[j]^=mask;
            mat[i/3][j/3]^=mask;
            board[i][j]=num;

            res = res || sudoku_01(board, idx+1, calls, row, col, mat);

            board[i][j]=0;
            row[i]^=mask;
            col[j]^=mask;
            mat[i/3][j/3]^=mask;

        }
    }    
    return res;
}

void sudoku(){
    vector<vector<int>> board = {{0, 0, 6, 0, 0, 8, 0, 0, 0},
                                 {5, 2, 0, 0, 0, 0, 0, 0, 0},
                                 {0, 8, 7, 0, 0, 0, 0, 3, 1},
                                 {0, 0, 3, 0, 1, 0, 0, 8, 0},
                                 {9, 0, 0, 8, 6, 3, 0, 0, 5},
                                 {0, 5, 0, 0, 9, 0, 6, 0, 0},
                                 {1, 3, 0, 0, 0, 0, 2, 5, 0},
                                 {0, 0, 0, 0, 0, 0, 0, 7, 4},
                                 {0, 0, 5, 2, 0, 6, 3, 0, 0}};
                                 
    vector<int> row(9,0), col(9,0);
    vector<vector<int>> matrix(3, vector<int>(3,0));                             
    vector<int> calls;

    for(int i= 0; i<9; i++){
        for(int j=0; j<9; j++){
            if(board[i][j]==0){
               calls.push_back((i*9 +j));
            }

            else{
                int mask= 1 << board[i][j];
                if( (mask & row[i])==0 && (mask & col[j])==0 && (mask & matrix[i/3][j/3])==0 ){
                    row[i]|=mask;
                    col[j]|=mask;
                    matrix[i/3][j/3]|=mask;
                }
            }
        }
    }
    cout<< sudoku_01(board,0,calls, row, col, matrix);
    //cout << sudoku_01(board, 0) << endl;
}
int main()
{
    sudoku();
}
