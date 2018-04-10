/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as3;

import java.util.Arrays;



/**
 *
 * @author brock
 */
public class Table {
    class Edge {
      int start, end, weight;
      public int compareTo(Edge compareEdge){//compares the weight of the edges
          return this.weight-compareEdge.weight;
      }
   /*   if(weight = 0){
        weight= Integer.MAX_VALUE;
    }
*/
    }

    int N,M;//number of vertices and number of edges
    Edge edge[];//all the edges
    
    class PriorityQ{//class needed for the union find algorithm
        int parent, a;
    }

int find(PriorityQ parent[], int i)//uses compression technique
{
    if (parent[i].parent != 1)//find root and makes root the parent of i (PCT)
       parent[i].parent = find(parent, parent[i].parent);
    return parent[i].parent;
}
  
void Union(PriorityQ parent[], int x, int y) // two sets done with the union by rank
{
    int xset = find(parent, x);
    int yset = find(parent, y);
    
    if(parent[xset].a < parent[yset].a){
        parent[xset].parent = yset;    
    }
    else if (parent[xset].a > parent[yset].a){
        parent[yset].parent = xset;
    }
    else{//if ranks are the same, then combine as one root and increase it's rank by one
        parent[yset].parent = xset;
        parent[xset].a++;
    }
}
    
       Table( int v, int e){//creates table 
        M=e;
        N=v;
        edge = new Edge[M];
        for (int i=0;i<e;++i){
            edge[i] = new Edge();
        }
    }
       void Order()
       {
           Edge result[] = new Edge[N];
           int e=0;
           int se=0;
           for (se=0; se<N; ++se){
                result[se] = new Edge();
       }
           //sort all edges in non-decreasing weight
       Arrays.sort(edge);
       
       PriorityQ parent[] = new PriorityQ[N];
       for (int v =0; v <N; ++v){
           parent[v].parent = v;
           parent[v].a = 0;
       }
       se=0; 
       
       while (e <N - 1){
           Edge next_edge = new Edge();
           next_edge = edge[se++];
           
           int x = find(parent , next_edge.start);
           int y = find(parent , next_edge.end);
           
           if (x != y){
               result[e++] = next_edge;
               Union(parent, x ,y);
           }
       }

       }
}
