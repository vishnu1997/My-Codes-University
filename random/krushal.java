import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Graph
{
    int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges
 
    class Edge
    {
        int src, dest;
    };
 
    // Creates a graph with V vertices and E edges
    Graph(int v,int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
 
    // A utility function to find the subset of an element i
    int find(int parent[], int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
 
    // A utility function to do union of two subsets
    void Union(int parent[], int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
 
 
    // The main function to check whether a given graph
    // contains cycle or not
    int isCycle( Graph graph)
    {
        // Allocate memory for creating V subsets
        int parent[] = new int[graph.V];
 
        // Initialize all subsets as single element sets
        for (int i=0; i<graph.V; ++i)
            parent[i]=-1;
 
        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for (int i = 0; i < graph.E; ++i)
        {
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);
 
            if (x == y)
                return 1;
 
            graph.Union(parent, x, y);
        }
        return 0;
    }
}

class ed{
    public int d;
    public int p1,p2;
    public boolean flag;
    ed(int p,int q,int r){
        p1=p;
        p2=q;
        d=r;
        flag=false;
    }
    void swap(ed ob){
        int r,t,y;
        r=ob.p1;
        t=ob.p2;
        y=ob.d;
        ob.p1=p1;
        ob.p2=p2;
        ob.d=d;
        p1=r;
        p2=t;
        d=y;
    }
}

public class krushal(tryout) {
    static void sort(ed ob[]){
        int min = ob[0].d;
        for(int i=0;i<ob.length-2;i++){
           for(int j=0;j<ob.length-1;j++){
               if(ob[j].d>ob[j+1].d){
                   ob[j].swap(ob[j+1]);
               }
           }
        }
    }
    
    static int start(ed ob[],int n,int e){
        ArrayList ar = new ArrayList();
        int br = 0;
        int sum = 0;
        for(int i=0;i<ob.length;i++){
          // System.out.println(ob[i].d+"   "+ob[i].p1+"   "+ob[i].p2);
           // Graph graph = new Graph(n, e);
            //for(){}
            if(!(ar.contains(new Integer(ob[i].p1))&&ar.contains(new Integer(ob[i].p2)))){
                
                if(!(ar.contains(new Integer(ob[i].p1)))){
                    ar.add(new Integer(ob[i].p1));
                }
                if(!(ar.contains(new Integer(ob[i].p2)))){
                    ar.add(new Integer(ob[i].p2));
                }
                sum += ob[i].d;
                //System.out.println(sum);
                br++;
                ob[i].flag=true;
            }else{
                //System.out.println("inside");
                int l=0;
                for(int j=0;j<ob.length;j++){
                    if(ob[j].flag){l++;}
                }
                l++;
                Graph graph = new Graph(n,l);
                int k=0;
                for(int j=0;j<ob.length;j++){
                    if(ob[j].flag){
                        graph.edge[k].src = ob[j].p1-1;
                        graph.edge[k].dest = ob[j].p2-1;
                        k++;
                    } 
                }
                graph.edge[k].src = ob[i].p1-1;
                graph.edge[k].dest = ob[i].p2-1;
                if(!(graph.isCycle(graph)==1)){
                    sum+=ob[i].d;
                    br++;
                    //System.out.println(sum+"inside");
                }
            }
          if(br==(n-1)){
              break;
          } 
        }
        return sum;
    }
    
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
        int nodes=in.nextInt();
        int edges=in.nextInt();
        ed ob[]= new ed[edges];
        for(int i=0;i<edges;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            ob[i]=new ed(a,b,n);
        }
        sort(ob);
        int sum = start(ob,nodes,edges);
        System.out.println(sum);
        in.close();
        
    }
}