/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package as3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* “Union-Find Algorithm | Set 2 (Union By Rank and Path Compression).” GeeksforGeeks,
18 Feb. 2017, www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/.
This is the source where I found the Union Find Algorithom.
*/
/* Authors: Brock Lehnen
Date: 4/10/2018
Overview: 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class As3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Path IN_PATH = FileSystems.getDefault().getPath("input/these.txt");
        Charset charset = Charset.forName("UTF-8");

        // 2D array/Matrix of text file stored here
        int matrix[][] = new int[6][6];

        //read in file and store in matrix array
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
                    matrix[row][i] = Integer.parseInt(weights[i]);
                    System.out.print(matrix[row][i] +"\t");
                    System.out.print("\n");
                }
                
                //adding value to row
                row++;
            }
 
        } 
        catch (IOException x) 
        {
            System.err.format("IOException: %s%n", x);
        }

        int N = 1;//vertice
        int M = 3;//edge
        Table table = new Table(N, M);

    }
}
