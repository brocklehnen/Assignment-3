//Brittany Couts & Brock Lehnen & Gabby Strong
//4/10/18
// The program is for adjacency matrix representation of the graph
// Can run this program with the Driver class or in the Prim's class.
// comment out the main method if wishing to test with the driver.
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
        k.Kruskal(args);
              
        
    }
    
}
