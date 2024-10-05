import java.io.*;
import java.util.List;

/*NOTE: Writing to a text file is temporary, will convert objects to json in future build.*/

public class ReadWrite {
    public static void writeToFile(String fileName, List<Recipe> recipes) {
        try {
            FileWriter writer = new FileWriter(fileName); // Create a new FileWriter object with the given file name
            String data = ""; // Create a string to store the data to write to the file
            for (int i = 0; i < recipes.size(); i++) { // Loop through the list of recipes
                data += recipes.get(i).toString();
            }           
            writer.write(data); // Write the data to the file
            writer.close();
        } catch (IOException e) { // Catch any IOExceptions that occur
            e.printStackTrace();
        }
    }
}
