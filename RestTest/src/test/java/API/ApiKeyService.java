package API;

import java.security.SecureRandom;
import java.util.Base64;
import java.io.FileWriter;
import java.io.IOException;

public class ApiKeyService {

    private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int KEY_LENGTH = 32;  // Length of the generated API key

    // Method to generate a random API key
    public static String generateApiKey() {
        SecureRandom random = new SecureRandom();
        StringBuilder apiKey = new StringBuilder(KEY_LENGTH);
        for (int i = 0; i < KEY_LENGTH; i++) {
            int index = random.nextInt(CHARSET.length());
            apiKey.append(CHARSET.charAt(index));
        }
        return apiKey.toString();
    }

    // Method to save the API key to a file (simulating storage)
    public static void saveApiKey(String apiKey) {
        try (FileWriter writer = new FileWriter("api_keys.txt", true)) {
            writer.write(apiKey + "\n");
        } catch (IOException e) {
            System.err.println("Error saving API key: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Generate an API key
        String apiKey = generateApiKey();
        System.out.println("Generated API Key: " + apiKey);

        // Save the API key to a file
        saveApiKey(apiKey);
    }
}

