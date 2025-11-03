import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        // Create a dictionary to store word groups (anagrams)
        Map<String, List<String>> wordGroups = new HashMap<>();

        try {
            // Read the word list file
            BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                String cleanWord = line.replaceAll("[^a-zA-Z]", "").toLowerCase();
                
        
                // Sort the characters of the word to use as key
                char[] chars = cleanWord.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                // Add word to the appropriate group in dictionary
                wordGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(cleanWord);
            }
            reader.close();

            // Write anagrams to output file
            BufferedWriter writer = new BufferedWriter(new FileWriter("anagrams.txt"));
            
            // Only write groups that have more than one word (actual anagrams)
            for (List<String> group : wordGroups.values()) {
                if (group.size() > 1) {
                    writer.write(String.join(" ", group));
                    writer.newLine();
                }
            }
            writer.close();

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
