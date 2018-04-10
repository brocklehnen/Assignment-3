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

/**
 *
 * @author brock
 */
public class As3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Charset charset = Charset.forName("UTF-8");
Path logfile = Paths.get("input//these.txt");


int matrix[][] = new int [6][6];
try (BufferedReader reader = Files.newBufferedReader(logfile, charset)) {
               
        


            String arr;
            String line = null;
            int row = 0;
            String newline = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {//reads file
            String[] weight = line.split (",");
            for (int i=0; i< 6; i++){
                if ("∞".equals(weight[i])){
                    weight[i]=Integer.toString(Integer.MAX_VALUE);
                }
                matrix[row][i] = Integer.parseInt(weight[i]);
            }    
            arr ="  " + newline;//line break in output
                

            System.out.println(line);
            
            row++;
        }
         

    } 
     
    catch (IOException x) {
    System.err.format("IOException: %s%n", x);
}
   int N = 1;
   int M = 3;
Table table = new Table(N,M);


    }
    }

    
    

