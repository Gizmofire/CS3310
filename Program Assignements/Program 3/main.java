/**************************************************************/
/* Gordon Lau  */
/* Login ID: 016229083 */
/* CS 3310, Fall 2025 */
/* Programming Assignment 3 */
/* Solution class: Solution for canoe effecient */
/**************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    private static int[][] costMatrix;
    private static int[][] splitPoint;

    private static int n; // Number of trading posts

   /**************************************************************/
    /* Method: Main */
    /* Purpose: Start of program for the anagram word array sorting algo*/
    /* Returns: Text in CLI */
    /**************************************************************/
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the name of the input file: ");
        String filename = console.nextLine().trim();


        try {
            parseFile(filename);
            calculateOptimalCosts();
            printOptimalMatrix();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**************************************************************/
    /* Method: parseFile */
    /* Purpose: Break down the file into */
    /* Returns: Filled out matrix objects for calculation */
    /**************************************************************/
    private static void parseFile(String filename) throws FileNotFoundException {
    
        Scanner fileScanner = new Scanner(new File(filename));

        if (!fileScanner.hasNextInt()) {
            System.out.println("Error: File is empty or invalid format.");
           
        }

        n = fileScanner.nextInt();
        costMatrix = new int[n][n];
        splitPoint = new int[n][n];

        // The input format specifies the upper triangular part of the matrix.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (fileScanner.hasNextInt()) {
                    int cost = fileScanner.nextInt();
                    // Initialize matrix with direct rental costs
                    costMatrix[i][j] = cost;
                    // Initialize split point as the destination (implies direct trip)
                    splitPoint[i][j] = j; 
                }
            }
        }

        fileScanner.close();
    
    }

    /**************************************************************/
    /* Method: calculateOptimalCosts */
    /* Purpose: Calculate the most optimal costs through dynamic programming*/
    /* Returns: Filled out costMatrix and splitPoint matrices */
    /* Note: this algo works on the basis that if its not cheaper 
    to go drop off and go on, then skip the post. As shown in the singular conditional. 
    I just made it iteratively to find it quicker and noted it in the splitPointArr.*/
    /**************************************************************/
    private static void calculateOptimalCosts() {
        
        for (int i = n - 2; i >= 0; i--) {
            
            for (int j = i + 1; j < n; j++) {
                
                for (int k = i + 1; k < j; k++) {
                    int currentPathCost = costMatrix[i][k] + costMatrix[k][j];

                    if (currentPathCost < costMatrix[i][j]) {
                        costMatrix[i][j] = currentPathCost;
                        splitPoint[i][j] = k; 
                    }
                }
            }
        }
    }


    
    /**************************************************************/
    /* Method: printOptimalMatrix */
    /* Purpose: Start of printing the calculated results in splitpoint*/
    /* Returns: Text in CLI */
    /**************************************************************/
    private static void printOptimalMatrix() {
        System.out.println("\nOptimal Cost Matrix:");
        System.out.print("      ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%4d ", j);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%4d |", i);
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    System.out.printf("%4d ", costMatrix[i][j]);
                } else {
                    System.out.print("   - ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // maybe remorve this later 
        System.out.println("\nSplit Matrix:");
        System.out.print("      ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%4d ", j);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%4d |", i);
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    System.out.printf("%4d ", splitPoint[i][j]);
                } else {
                    System.out.print("   - ");
                }
            }
            System.out.println();
        }
        System.out.println();

        int start = 0;
        int end = n - 1;
       

        System.out.println("Optimal sequence of rentals for " + start + " to " + end + ":");
        System.out.println("Total Cost: " + costMatrix[start][end]);
        printPathRecursive(start, end);
    }

    /**************************************************************/
    /* Method: printPathRecursive */
    /* Purpose: Recurvively path through the chain of most optimal paths and print out the disconnects representing when to get off and on*/
    /* Returns: Text in CLI */
    /**************************************************************/
    private static void printPathRecursive(int start, int end) {
        
        int k = splitPoint[start][end];

        // Base Case: If the split point is the destination itself,
        // it means the optimal path is a direct rental from start to end.
        if (k == end) {
            System.out.println("Rent canoe at post " + start + ", drop off at post " + end);
        } else {
            // Recursive Step: The path is split at k.
            // Print the path for the left half (start -> k)
            printPathRecursive(start, k);
            // Print the path for the right half (k -> end)
            printPathRecursive(k, end);
        }
    }
}