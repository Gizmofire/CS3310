
import java.io.BufferedReader;
import java.io.FileReader;

public class solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {

            String filename = args[0];
             // Creating an object of BufferedReader class
            BufferedReader bfro = new BufferedReader(new FileReader(filename));

            // Declaring a string variable
            String st;
        
            // Condition holds true till there is character in a string
            while ((st = bfro.readLine()) != null)
                System.out.println(st);

            
        }
        else

            System.out.println("No file to test passed in args");
    }
    
}
