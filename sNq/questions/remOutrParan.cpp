//remove outermost parantheses -1021
#include<iostream>
 #include<conio.h>
#include<stack>
using namespace std;


     int main(){
        string res ="";
        int count =0;
        string S;
        cin>>S;
        for(int i =0; i<S.length(); i++){
            if(S[i]=='('){ count++; }
            if(S[i]=='(' && count!=1){ res+=S[i];}
            if(S[i]==')'){count--; }
            if(S[i]==')' && count!=0){ res+=S[i];}
        }
         cout<<S<<" "<<res;  
         return 0;  
    }

