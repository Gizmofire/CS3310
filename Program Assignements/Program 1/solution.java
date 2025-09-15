
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class solution {
    public static void main(String[] args) throws Exception  {
        if (args.length > 0) {

            String filename = args[0];
            openFile(filename);
            
        }
        else{

            System.out.println("No file to test passed in args. Using Default test case because I am lazy.");

            openFile("./Givens/SampleInput.txt");
        }

    }


    static void openFile(String filename) throws Exception{
          // Creating an object of BufferedReader class
            BufferedReader bfro = new BufferedReader(new FileReader(filename));

            // Declaring a string variable
            String st;
        


        File myObj = new File(filename);
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                parse(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
         }
                
    }
    
    static void parse(String s) {
        ArrayList<int[]> edges = new ArrayList<>();
        String[] parts = s.split(" ");
        int vertices  = Integer.parseInt(parts[0]);    
        for (int i = 1; i < parts.length; i++) {
            // Remove parentheses and split by comma
            String edgeString = parts[i].replaceAll("[()]", "");
            String[] items = edgeString.split(",");
            // Had some errors when trying to catch double digit numbers
            if (items.length != 2) {
                System.err.println("Error parsing edge: " + parts[i]);
                continue; // Skip this malformed edge
            }
            int[] edge = new int[2];
            edge[0] = Integer.parseInt(items[0]);
            edge[1] = Integer.parseInt(items[1]);
            edges.add(edge);

            
        }


        solve(vertices, edges);
    }

    static void solve(int x, ArrayList<int[]> edges) {


        // USED FOR DEBUGGING arr
        // System.out.println("Vert " + x);
        // for (int i = 0; i < edges.size(); i++) {
        //     System.out.println("Edge " + edges.get(i)[0] + " " + edges.get(i)[1]);
        // }


        
        // THE DFS ALGO 
        boolean[] visited = new boolean[x + 1]; // Vertices are 1-indexed
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= x; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }


        //DFS + pretty print formating
        System.out.print("Graph groupings: ");
        for (int i = 1; i <= x; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adjacencyList, visited, component);
                System.out.print(component.toString().replace('[', '{').replace(']', '}') + " ");
            }
        }
        System.out.println();
    }

    // Go to each vertex and trace down to each neighbor recursively
    static void dfs(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        for (int neighbor : adj.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }


    }

}
