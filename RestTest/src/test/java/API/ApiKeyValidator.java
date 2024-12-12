package API;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ApiKeyValidator {

    // Method to validate the API key
    public static boolean validateApiKey(String apiKey) {
        try (BufferedReader reader = new BufferedReader(new FileReader("api_keys.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(apiKey)) {
                    return true;  // API key found and valid
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading API keys file: " + e.getMessage());
        }
        return false;  // API key not found
    }

    public static void main(String[] args) {
        String apiKey = "YOUR_API_KEY";  // Replace with the key to validate

        if (validateApiKey(apiKey)) {
            System.out.println("API Key is valid. Proceeding with execution...");
            // Proceed with your main functionality
        } else {
            System.out.println("Invalid API Key!");
            // Terminate the program or deny access
        }
    }
}

