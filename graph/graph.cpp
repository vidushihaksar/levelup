#include<iostream>
#include<vector>

using namespace std;

class edge{
    public:
    int v;
    int w;
    
    edge(int v, int w){
        this->v = v;
        this->w = w;
    }
};

int n=7;
vector<vector<edge*>> graph(7,vector<edge*>()); //vector<edge*>graph[n]

//############# add edge ############
void addEdge(int u, int v, int w){
    graph[u].push_back(new edge(v,w));
    graph[v].push_back(new edge(u,w));
}

//######## search vertex for remove ############
int idx= -1;
int searchVertex(int u, int v){
    for(int i= 0;i<graph[u].size();i++){
        if(graph[u][i]->v== v){
            idx= i;
            break;
        }
    }
    return idx;
}
//######### remove edge ###############
void removeEdge(int u, int v){
    int uidx =-1, vidx = -1;

     vidx = searchVertex(u,v);
     uidx = searchVertex(v,u);
    
    if(uidx!= -1){
        graph[u].erase(graph[u].begin() + vidx);
        graph[v].erase(graph[v].begin() + uidx);
    }
}
//############ remove vertex ##############
void removeVertex(int u){
    for(int i = graph[u].size()-1; i>=0; i--){
        int v= graph[u][i]->v;
        removeEdge(u,v);
    }
}
void display(){
    for(int i =0;i<n;i++){
        cout<<i<<"->";
        for(edge*e : graph[i])
        {
            cout<< "(" << e->v << "," << e->w << ")";
        }
        cout<<endl;
    }
}

void createGraph(){
    addEdge(0,1,10);
    addEdge(0,3,10);
    addEdge(1,2,10);
    addEdge(2,3,90);
    addEdge(3,4,2);
    addEdge(4,5,2);
    addEdge(4,6,2);

    
}

int main(){
    createGraph();
    display();
    removeEdge(2,3);
    cout<<endl<<"after removing (2,3) and (3,2) edge\n";
    display();
    cout<<endl<<"after removing vertex 4\n";
    removeVertex(4);
    display();

}