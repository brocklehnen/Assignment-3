/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab3.pkg232;

/**
 *
 * @author Britt
 */
public class Driver
{

    //runs the full program
    public static void main(String[] args)
    {
        System.out.println("Floyd method \n");
        Floyd f = new Floyd();
        f.readFile(args);
        
        System.out.println("Prims method \n");
        Prims p = new Prims();
        p.readFile(args);
        
        System.out.println("\n\nKruskal method \n");
        Kruskal k = new Kruskal();
        k.Krus(args);
              
        
    }
    
}