import java.io.*;
import java.util.*;

public class graph_dfs{
    int v;
    LinkedList<Integer> edges[];
    graph_dfs(int j){
        v = j;
        edges = new LinkedList[v];
        for(int i=0;i<v;i++){
            edges[i] = new LinkedList();
        }
    }
    void addEdge(int i,int j){
        edges[i].add(j);
    }

    void dfs(int s){
        boolean b[] = new boolean[v];
        for(int i=0;i<v;i++){
            b[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList();
        queue.add(s);
        b[s] = true;
        //System.out.println(s);
        while(queue.size()!=0){
            int k,p;
            p=queue.removeLast();
            System.out.println(p);
            
            Iterator<Integer> it = edges[p].listIterator();
            while(it.hasNext()){
                k = it.next();
                if(!b[k]){
                    b[k] = true;
                    queue.add(k);
                }
            }
        }
    }

    public static void main(String ar[]){
        graph_dfs g = new graph_dfs(6);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        
        
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(5, 3);
        g.addEdge(2, 4);
        
        g.dfs(0);
    }
}