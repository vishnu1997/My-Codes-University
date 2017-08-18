import java.io.*;
import java.util.*;

public class graph_bfs{
    int v;
    LinkedList<Integer> edges[];
    graph(int j){
        v = j;
        edges = new LinkedList[v];
        for(int i=0;i<v;i++){
            edges[i] = new LinkedList();
        }
    }
    void addEdge(int i,int j){
        edges[i].add(j);
    }

    void bfs(int s){
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
            p=queue.poll();
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
        graph g = new graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 7);
        g.addEdge(2, 6);
        g.bfs(0);
    }
}