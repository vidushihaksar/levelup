#include<iostream>
#include<vector>
using namespace std;

string str1= "send";
string str2= "more";
string str3= "money";
int vis =0;
vector<int> mapping(26,0);

int getNumFromStr(string str)
{
    int res = 0;
    for (int i = 0; i < str.length(); i++)
    {
        res = res * 10 + mapping[(str[i] - 'a')];
    }
    return res;
}

int crypto(string mystr, int idx){

    if(mystr.length()== idx){
        int a = getNumFromStr(str1);
        int b = getNumFromStr(str2);
        int c = getNumFromStr(str3);

        if(a+b==c){
            cout<<a<<"+"<<" "<<b<<"="<<" "<<c;
            cout<<endl;
            return 1;
        }
       

        return 0;
    }
  int count=0;
  int ch = mystr[idx]-'a';

    for(int num=9; num>=0; num--){

           int mask= (1 << num);
           if( (vis & mask)==0 ){
              vis^= mask;
              mapping[ch]=num;
            
              count+=crypto(mystr, idx+1);

              vis^=mask;
              mapping[ch]==0;
            }
    }
    return count;
     
}

void crypto(){
   string str = str1 + str2 + str3;
   vector<int> freq(26,0);
   for(int i=0; i < str.length(); i++){
       freq[str[i]-'a']++;
   }

    string mystr = "";
   for(int i =0 ; i<freq.size(); i++){
       if(freq[i]!=0){
           mystr+= char(i + 'a');
       }
   }
   //cout<<mystr;
       cout << crypto(mystr, 0) << endl;

}
int main(){
    crypto();
}