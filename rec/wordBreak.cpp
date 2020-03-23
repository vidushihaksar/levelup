#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<string> dict ={ "i", "like", "ilike", "man", "go", "mango", "ice", "cream","icecream", "and"};

int wordBreak(string que , string ans, vector<string> &dict )
{   if(que.length()==0){
     cout<<ans<<endl;
     return 1;
    }


    int count =0 ;
   for(int i =1;i<=que.size();i++){
       string nstr = que.substr(0,i) ;
       if( std::find(dict.begin(), dict.end(), nstr)!= dict.end() ){
           count+= wordBreak( que.substr(i), ans+ nstr+" ", dict);
       }
   }
   return count;

}
int main(){
    cout<<wordBreak("ilikeicecreamandmango", "", dict);
}


