#include<iostream>
using namespace std;

void check(int *a){
    int b;

    if(&b > a ){
        cout<<"stack up";
    }
    else
    {
        cout<<"stack down";
    }
    
}


int main(){
   int a;
   check(&a);
}