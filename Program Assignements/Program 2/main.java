/**************************************************************/
/* Gordon Lau  */
/* Login ID: 016229083 */
/* CS 3310, Fall 2025 */
/* Programming Assignment 2 */
/* Solution class: Solution for anagrams */
/**************************************************************/



import java.io.*;
import java.util.*;





public class main {


    /**************************************************************/
    /* Method: Main */
    /* Purpose: Start of program for the anagram word array sorting algo*/
    /* Returns: Text in CLI */
    /**************************************************************/
    public static void main(String[] args) {

        // Creates a dictionary to store word groups (anagrams)
        Map<String, List<String>> wordGroups = new HashMap<>();

        try {
            // Reads the word list file
            BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                // Removes punctuation and convert to lowercase
                String cleanWord = line.replaceAll("[^a-zA-Z]", "").toLowerCase();
                
        
                // Sorts the characters of the word to use as key
                char[] chars = cleanWord.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                // Adds word to the appropriate group in dictionary
                wordGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(cleanWord);
            }
            reader.close();

            // Writes anagrams to output file
            BufferedWriter writer = new BufferedWriter(new FileWriter("anagrams.txt"));
            
            // Only write to groups that have more than one word (actual anagrams)
            for (List<String> group : wordGroups.values()) {
                if (group.size() > 1) {
                    writer.write(String.join(" ", group));
                    writer.newLine();
                }
            }
            writer.close();

        } catch (IOException e) {
            // Handle exceptions
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
