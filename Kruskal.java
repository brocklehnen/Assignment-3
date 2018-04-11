/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    void Kruskal(String[] args)
    {
        //TreeSet is used to sort the edges before passing to the algorithm
        TreeSet<Edge> edges = new TreeSet<Edge>();
        final Path IN_PATH = FileSystems.getDefault().getPath("input/input.txt");
        Charset charset = Charset.forName("UTF-8");
        
        
        String [] parts;
        int a = 0;
        int b = 0;
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

        int total = 0;
        for (Edge edge : vv.getEdges()) 
        {
            System.out.println(edge);
            total += edge.getWeight();
        }
        System.out.println("Total weight is " + total);
    }

}