//Brittany Couts & Brock Lehnen & Gabby Strong
//4/10/18
// The program is for adjacency matrix representation of the graph
// Help with kruskals
package outlab3.pkg232;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;


public class Kruskal
{
    //could not get it to work with input
    void Kruskal(String[] args)
    {
        //TreeSet is used to sort the edges before passing to the algorithm
        TreeSet<Edge> edges = new TreeSet<Edge>();
        final Path IN_PATH = FileSystems.getDefault().getPath("input/input.txt");
        Charset charset = Charset.forName("UTF-8");
        
        int matrix[][] = new int[6][6];

        Integer weight = null;
       try (BufferedReader reader = Files.newBufferedReader(IN_PATH, charset)) 
        {
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
                    matrix[row][i] = Integer.parseInt(weights[i]);
                }
                //adding value to row
                row++;
            }
        } 
        //catch if fail
       catch(IOException e) 
        {
            System.out.println("File IO Error" + e.toString());
        }

        KruskalEdges vv = new KruskalEdges();

        for (Edge edge : edges) 
        {
            System.out.println(edge);
            vv.insertEdge(edge);
        }

        //attempt to get it to calculate
        int total = 0;
        for (Edge edge : vv.getEdges()) 
        {
            System.out.println(edge);
            total += edge.getWeight();
        }
        System.out.println("Total weight is " + total);
    }

}
