import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class WPDownload {
    
    public static void main(String[] args) {
        String[][] urlsAndPaths = {
            {"https://www.geeksforgeeks.org/", "Haris-Farooqi.html"},
            {"https://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol", "smtp.html"}
        };

        new down(urlsAndPaths);
    }

}


class down {
    
    down(String[][] webpage) {
        try {
            for (String[] pair : webpage) {
                
                // Create a URI object and convert it to a URL
                URI uri = new URI(pair[0]);
                URL url = uri.toURL();
                
                // Open a stream to read the webpage content
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                
                // Specify the filename to save the downloaded content
                BufferedWriter writer = new BufferedWriter(new FileWriter(pair[1]));
                
                // Read each line from the stream and write it to the file
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine(); // Add a new line for better formatting
                }
                
            // Close the streams
            reader.close();
            writer.close();
            
            System.out.println("Webpage downloaded successfully");

            // -------1st way to open in chrome-------
            // Runtime.getRuntime().exec(
                //     "\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\" " + "file:///C:\\Users\\Lab%20User\\Desktop\\java.sir\\" + pair[1]
                // );
                

            // -------2nd way to open in chrome-------
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start chrome \"" + "E:\\UBIT\\2nd semester\\OOP Java\\webPageDownload\\"+pair[1] + "\"");
            builder.start();


        }
        } 
        // Handle malformed URL or URI exceptions
        catch (MalformedURLException | IllegalArgumentException e) {
            System.out.println("Error: The URL is invalid.");
        } 
        // Handle IO exceptions
        catch (IOException e) {
            System.out.println("Error: Unable to download the webpage.");
        } 
        // Handle URI syntax exceptions
        catch (Exception e) {
            System.out.println("Error: Invalid URI syntax.");
        }
    }

}
