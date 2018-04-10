/*
 * Brittany Couts
 *4/10/18
 *Runs through floyds algorithm printing along the way
 *For some reason the code would not work with max inf so I set max Inf to be 100 while running through so it could work
 */
package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Britt
 */
public class Floyd 
{
    //final static int INF = 99999;
    static int[][] P;
    static final int N = 6;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        final Path IN_PATH = FileSystems.getDefault().getPath("input/input.txt");
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
                }
                //adding value to row
                row++;
            }
            //reader.close();
           
            //to get matrix going
            printMatrix(FloydAlgo(matrix));
            
        } 
        //if it fails it cathces it
        catch (IOException x) 
        {
            System.err.format("IOException: %s%n", x);
        }
        
    }
        //method to rint the matrix
        static void printMatrix(int[][] Matrix) 
        {
                //for loops to go trough the matrix
		System.out.print("\n\t");
		for (int j = 0; j < N; j++) 
                {
			System.out.print(j + "\t");
		}
		System.out.println();
                //spacer
		for (int k = 0; k < N; k++) 
                {
			System.out.print("\t-");
		}
		System.out.println();
                
                //for loop to print the values
		for (int i = 0; i < N; i++) 
                {
			System.out.print(i + " |\t");
			for (int j = 0; j < N; j++) 
                        {
				System.out.print(Matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
        }
	
        //method to run through the algorithm
        public static int[][] FloydAlgo(int[][] Matrix) 
        {
            //code would not work witout this
            int fixer = 100;
            
            //setting up the original matrix
            for(int u =0; u<N; u++)
            {
                for(int c =0; c<N; c++)
                {
                     if(Matrix[u][c]==Integer.MAX_VALUE)
                     {
                         Matrix[u][c] = fixer;
                     }
                     //return M[u][c];
                }
            }
            
            //printing original matrix
            System.out.println("Original Matrix:");
            printMatrix(Matrix);
            
            //setting diagnaols to 0
            for(int v = 0; v < N; v++)
            {
                Matrix[v][v] = 0;
            }            

            //code to work the algorithm
            for (int k = 0; k < N; k++) 
                {
			for (int i = 0; i < N; i++) 
                        {
				for (int j = 0; j < N; j++) 
                                {
					if (Matrix[i][k] + Matrix[k][j] < Matrix[i][j]) 
                                        {
						Matrix[i][j] = Matrix[i][k] + Matrix[k][j];
						//P[i][j] = k;
					}
				}
                               // System.out.println("test: " + i);
                                
			}
                        
                        printMatrix(Matrix);
		}
                //printMatrix(M);
		return Matrix;
	}
    
}
