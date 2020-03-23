#include<iostream>
#include<vector>
#include<stack>


using namespace std;

class Node{
    int data;
    vector<node *> childs;

    Node(int data){
        this.data = data;
    }
}

Node*  createTreeFromArray(vector<Node*> arr){
    stack<Node*> st;
    Node *root = nullptr;

    for(int i = 0 ; i<arr.size() ; i++){
        if(arr[i]!=-1){
            if(i==0) 
            {
                root = arr[i];
            }

            st.push(arr[i]);
        }
        else{
            Node* r= st.top();
            st.pop();
            st.top()->childs.push_back(arr[i]);
        }
    }
    return root;
}
void display(Node* root){
    cout<<root.data<<"->";
    for(Node* n:root->childs){
        cout<<n<" ";
    }
    cout<<endl;
    for(Node* n:root->childs){
        display(n);
    }
    
}