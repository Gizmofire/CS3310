
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {

            String filename = args[0];
            openFile(filename);
            
        }
        else{

            System.out.println("No file to test passed in args. Using Default test case because I am lazy.");

            openFile("./Givens/SampleInput.txt");}

    }


    static void openFile(String filename) {
          // Creating an object of BufferedReader class
            BufferedReader bfro = new BufferedReader(new FileReader(filename));

            // Declaring a string variable
            String st;
        



            // Condition holds true till there is character in a string
            while ((st = bfro.readLine()) != null)
                System.out.println(st);
                if (st != null) {
                    String s = String.format(st);
                    parse(s);
                }

                
    }
    
    static void parse(String s) {
        ArrayList<int[]> edges = new ArrayList<>();
        String[] parts = s.split(" ");
        int vertices  = Integer.parseInt(parts[0]);    
        for (int i = 1; i < parts.length; i++) {
            String[] items = parts[i].split("");
            int[] edge = new int[2];
            edge[0] = Integer.parseInt(items[1]);
            edge[1] = Integer.parseInt(items[3]);
            edges.add(edge);

            
        }


        solve(vertices, edges);
    }

    static void solve(int x, ArrayList<int[]> edges) {
        System.out.println("Vert " + x);
        for (int i = 0; i < edges.size(); i++) {

            System.out.println("Edge " + edges.get(i)[0] + " " + edges.get(i)[1]);
        }
    }

}
