package RestApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map; 
import io.restassured.response.Response;
import static io.restassured.RestAssured.*; 
public class RestApp {

    public static void main(String[] args) {
      
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "varun");
        userMap.put("code", "cs104");

        
        ArrayList<Integer> credits = new ArrayList<>();
        credits.add(5);
        credits.add(4);
        userMap.put("credit", credits);

        Map<String, String> Subjects = new HashMap<>();
        Subjects.put("name", "Varun");
        Subjects.put("code", "cs106");
        Subjects.put("credits", "5");

     
        userMap.put("Subjects", Subjects);

       
        System.out.println("User Data: " + userMap);

        
        Response response = given()
                                .contentType("application/json")
                                .body(userMap)
                                .post("http://localhost:3000/university");

        System.out.println("Response: " + response.asString());
        
    }
}
