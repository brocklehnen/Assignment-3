//Gabrielle Strong
//4/10/18
//A Java program for Prim's algorithm.
// The program is for adjacency matrix representation of the graph


import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Prims
{
	// Number of vertices in the graph
	private static int V =6;

	public int minSpot(int key[], boolean mstSet[])
	{
            // min value
            int min = Integer.MAX_VALUE, minindex=-1;

            for (int v = 0; v < V; v++)
            {
                    if (mstSet[v] == false && key[v] < min)
                    {
                            min = key[v];
                            minindex = v;
                    }
            }

            return minindex;
	}

	// print
	public static void print(int parent[], int n, int graph[][])
	{
		System.out.println("Weight");
		for (int i = 1; i < V; i++)
                {
                    System.out.println(parent[i]+" - "+ i + " "+ graph[i][parent[i]]);
                }
	}
	// using adjacency matrix
	public int[] tree(int graph[][])
	{
            int parent[] = new int[V];
            int key[] = new int [V];
            boolean set[] = new boolean[V];

            // all keys set to ∞
            for (int i = 0; i < V; i++)
            {
                    key[i] = Integer.MAX_VALUE;
                    set[i] = false;
            }
            key[0] = 0;
            parent[0] = -1;
            for (int count = 0; count < V+1; count++)
            {
                int u = minSpot(key, set);
                for (int v = 0; v < V; v++)
                {
                    if (graph[u][v]!=0 && set[v] == false && graph[u][v] < key[v])
                    {
                            parent[v] = u;
                            key[v] = graph[u][v];
                            System.out.print(graph[u][v]);
                    }
                }
            }
            return parent;
	}

	public static void main (String[] args)
	{
            Path path = Paths.get("input\\input.txt");
            Charset chars = Charset.forName("ISO-8859-1");
            int graph[][] = new int[6][6];
            try (BufferedReader reader = Files.newBufferedReader(path, chars))
            {
                reader.readLine();
                String line = null;
                int spot = 0;
                while ((line = reader.readLine()) != null)
                {
                    String[] weighted = line.split(",");

                    for( int i =0; i == 6; i++)
                    {
                        if (weighted[i] == "∞")
                        {
                            weighted[i] = Integer.toString(Integer.MAX_VALUE);
                        }
                        graph[spot][i] = Integer.parseInt(weighted[i]);
                    }
                    spot++;
                }
            }
            catch (IOException x)
            {
                System.out.println("No file " + x);
            }
            Prims t = new Prims();
            t.tree(graph);
            for (int i = 0; i < graph.length;i++)
            {
                for (int j = 0; j< graph.length; j++)
                {
                    t.tree(graph);
                    System.out.println(t.tree(graph));
                } 
               //System.out.println(graph[i]);
            }
        }
    }
