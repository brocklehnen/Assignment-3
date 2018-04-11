/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as3;

import java.util.Arrays;



public class Table {




    class Edge implements Comparable<Edge>{
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

           Table( int v, int e){//creates table 
        M=e;
        N=v;
        edge = new Edge[M];
        for (int i=0;i<e;++i){
            edge[i] = new Edge();
        }
    }
int find(PriorityQ parents[], int i)//uses compression technique
{
    if (parents[i].parent != i)//find root and makes root the parent of i (PCT)
       parents[i].parent = find(parents, parents[i].parent);
    return parents[i].parent;
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
    else{//if the ranks are the same then combine
        parent[yset].parent = xset;
        parent[xset].a++;
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
       for (int i=0; i <N; ++i){
           parent[i]=new PriorityQ();
       }
       for (int v =0; v <N; ++v){
           parent[v].parent = v;
           parent[v].a = 0;
       }
       se=0; 
       
       while (e <N - 1){//Pick the smallest edge
           Edge next_edge = new Edge();
           next_edge = edge[se++];
           
           int x = find(parent , next_edge.start);
           int y = find(parent , next_edge.end);
           
           if (x != y){
               result[e++] = next_edge;
               Union(parent, x ,y);
           }
       }
 
 System.out.println("Following are the edges plus the weight at the end");
 //tells the two points for the shortest path plus the weight at the end
      int a = 0;
 for (int i = 0; i < e; ++i){
            System.out.println(result[i].start+" -- " + result[i].end+" == " + result[i].weight);
        
 }
    }

}
