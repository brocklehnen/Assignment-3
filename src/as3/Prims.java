/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab3.pkg232;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

class Prims
{
   private static final int V=6;

   public int minSpot(int key[], Boolean setter[])
   {
       int min = Integer.MAX_VALUE, minIndex=-1;

       for (int v = 0; v < V; v++)
           if (setter[v] == false && key[v] < min)
           {
               min = key[v];
               minIndex = v;
           }

       return minIndex;
   }
   // attempted to use char array to convert the first 6 nodes into actual A,B,C,D,E,F
 /*  public String character(int i)
   {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        if (i >6)
        {
            return null;
        }
        return Character.toString(alphabet[i]);
  */ 
   public void print(int parent[], int n, int graph[][])
   {
       System.out.println("Prims Edges");
       for (int i = 1; i < V; i++)
       {
           System.out.print( i+" " + graph[i][parent[i]] + " ");
       }
   }
   //logic to fo the prim code
   public void tree(int graph[][])
   {
       int parent[] = new int[V];
       int key[] = new int [V];
       Boolean Set[] = new Boolean[V];
       // Initialize all keys as INFINITE
       for (int i = 0; i < V; i++)
       {
           key[i] = Integer.MAX_VALUE;
           Set[i] = false;
       }
       key[0] = 0;   // Make key 0 so picked as first vertex
       parent[0] = -1; // root of MST
       //have V vertices
       for (int count = 0; count < V-1; count++)
       {
           int u = minSpot(key, Set);
           // Add the picked
           Set[u] = true;
           for (int v = 0; v < V; v++)
           {
               if (graph[u][v]!=0 && Set[v] == false &&
                   graph[u][v] < key[v])
               {
                   parent[v] = u;
                   key[v] = graph[u][v];
               }
           }
       }

       // print the constructed MST
       print(parent, V, graph);
   }

   void readFile (String[] args)
   {
      
       final Path IN_PATH = FileSystems.getDefault().getPath("input/input.txt");
        Charset charset = Charset.forName("UTF-8");

        // 2D array/graph of text file stored here
        int graph[][] = new int[6][6];

        //read in file and store in graph array
        try (BufferedReader reader = Files.newBufferedReader(IN_PATH, charset)) {
            
            reader.readLine();
            String line = ""; // stores each line
            int row = 0; // keep track of current row
            
            while ((line = reader.readLine()) != null) 
            {
           
                //splits the num at the commas
                String[] weights = line.split(",");
                
                //going through values
                for (int i = 0; i < 6; i++) 
                {
                    //setting infinity to max integer
                    if ("∞".equals(weights[i])) 
                    {
                        weights[i] = Integer.toString(Integer.MAX_VALUE); 
                    }
                    graph[row][i] = Integer.parseInt(weights[i]);
                }
                //adding value to row
                row++;
            }
            Prims t = new Prims();
            //reader.close();
            t.tree(graph);
        } 
        //if it fails it cathces it
        catch (IOException x) 
        {
            System.err.format("IOException: %s%n", x);
        }
   }
}
