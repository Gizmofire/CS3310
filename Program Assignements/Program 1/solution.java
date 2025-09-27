
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**************************************************************/
/* Gordon Lau  */
/* Login ID: 016229083 */
/* CS 3310, Fall 2025 */
/* Programming Assignment 1 */
/* Solution class: Solution for the DFS prompt */
/**************************************************************/


public class solution {


    /**************************************************************/
    /* Method: Main */
    /* Purpose: Start of program and pass file name in CLI according to directions. 
    Can also run without file name passed as a saftey.*/
    /* Parameters: */
    /* String target: file to pass to the program*/
    /* Returns: Text in CLI */
    /**************************************************************/
    public static void main(String[] args) throws Exception  {
        if (args.length > 0) {

            // basic string variable to store the filename passed in CLI
            String filename = args[0];

            openFile(filename);
            
        }
        else{

            // edge case that the programm runs without a filename passed in CLI
            System.out.println("No file to test passed in args. Using Default test case because I am lazy.");

            openFile("./Givens/SampleInput.txt");
        }

    }

    /**************************************************************/
    /* Method: Open File */
    /* Purpose: reads the file in the local directroy*/
    /* Parameters: */
    /* String filename: filename/path of file that should be opened*/
    /**************************************************************/
    static void openFile(String filename) throws Exception{

        // File referenc to read from the filename variable
        File myObj = new File(filename);
        
        // Scanner to read the file line by line and pipes the data to parse()
        // This isolates the solving process per line and allows for multiple test cases in one file
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                parse(data);
            }

        // cataches file not found error
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
         }
                
    }

    /**************************************************************/
    /* Method: Parse */
    /* Purpose: breaks down file contents into a format that can be used 
    to solve the dfs challenge the passes it to solve() */
    /* Parameters: */
    /* String s: s for string is used as a basic data type */
    /**************************************************************/
    static void parse(String s) {

        // Some basic variables to store the vertices and edges
        ArrayList<int[]> edges = new ArrayList<>();
        String[] parts = s.split(" ");
        int vertices  = Integer.parseInt(parts[0]);    

        
        for (int i = 1; i < parts.length; i++) {
            // Remove parentheses and split by comma
            String edgeString = parts[i].replaceAll("[()]", "");
            String[] items = edgeString.split(",");


            // Had some errors when trying to catch double digit numbers - this was the solution to fix
            if (items.length != 2) {
                System.err.println("Error parsing edge: " + parts[i]);
                continue; // Skip this malformed edge
            }

            // creates an edge array to store the two vertices of the edge so it can be referenced later in algo solving
            int[] edge = new int[2];
            edge[0] = Integer.parseInt(items[0]);
            edge[1] = Integer.parseInt(items[1]);
            edges.add(edge);

            
        }


        solve(vertices, edges);
    }

    /**************************************************************/
    /* Method: Solve */
    /* Purpose: Finds all connected components in an undirected graph using DFS */
    /* Parameters: */
    /* int x: number of vertices in the graph */
    /* ArrayList<int[]> edges: list of edges in the graph */
    /* Returns: Prints each connected component to the console */
    /**************************************************************/
    static void solve(int x, ArrayList<int[]> edges) {


        /* // USED FOR DEBUGGING arr
        System.out.println("Vert " + x);
        for (int i = 0; i < edges.size(); i++) {
            System.out.println("Edge " + edges.get(i)[0] + " " + edges.get(i)[1]);
        } */


        // dfs algo prep
        boolean[] visited = new boolean[x + 1]; // Vertices are 1-indexed

        // cretes a 2d arraylist to store the adjacency list
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= x; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // adjacency list to find the neighbors of each vertex for traversal
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }


        //DFS + pretty print formating
        System.out.print("Graph groupings: ");
        for (int i = 1; i <= x; i++) {
            if (!visited[i]) {

                // list to compontents of visted vertex
                ArrayList<Integer> component = new ArrayList<>();

                dfs(i, adjacencyList, visited, component);
                System.out.print(component.toString().replace('[', '{').replace(']', '}') + " ");
            }
        }
        System.out.println();
    }


    /**************************************************************/
    /* Method: dfs */
    /* Purpose: Recursively traverses each vertex in the component to visit all connected vertices and stores them*/
    /* Parameters: */
    /* int vertex: current vertex to visit */
    /* ArrayList<ArrayList<Integer>> adj: adjacency list of the graph */
    /* boolean[] visited: array to track visited vertices */
    /* ArrayList<Integer> component: list to store the connected component */
    /**************************************************************/
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
