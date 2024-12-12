package API;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Activate {
    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String CHARSET = "UTF-8";

    // Encrypt method
    public static String encrypt(String plainText, String key) throws Exception {
        // Ensure key is valid
        key = formatKey(key);

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(CHARSET), ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt method
    public static String decrypt(String encryptedText, String key) throws Exception {
        // Ensure key is valid
        key = formatKey(key);

        // Handle URL-safe Base64
        String base64Corrected = encryptedText.replace('-', '+').replace('_', '/');
        while (base64Corrected.length() % 4 != 0) {
            base64Corrected += "=";
        }

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(CHARSET), ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decodedBytes = Base64.getDecoder().decode(base64Corrected);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);

        return new String(decryptedBytes, CHARSET);
    }

    // Generate a valid key for AES
    private static String formatKey(String key) {
        if (key.length() < 16) {
            // Pad with 0s if the key is less than 16 bytes
            return String.format("%-16s", key).replace(' ', '0');
        } else if (key.length() > 16) {
            // Truncate to 16 bytes if the key is too long
            return key.substring(0, 16);
        }
        return key;
    }

    // Example usage
    public static void main(String[] args) {
        try {
            String schoolId = "school-123";
            String rollNo = "roll-456";
            String key = generateKey(schoolId, rollNo); // Generate key

            String plainText = "Hello, this is a secret message!";
            System.out.println("Original Text: " + plainText);

            // Encrypt
            String encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decrypt
            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Generate key from schoolId and rollNo
    private static String generateKey(String schoolId, String rollNo) {
        String rawKey = (schoolId + rollNo).replace("-", "");
        return rawKey.length() >= 16 ? rawKey.substring(0, 16) : String.format("%-16s", rawKey).replace(' ', '0');
    }
}
