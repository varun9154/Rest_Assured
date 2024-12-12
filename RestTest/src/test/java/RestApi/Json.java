package RestApi;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Json {
    public static void main(String[] args) {
        baseURI = "http://localhost:3000/Name";

        
        JSONObject jsonObject = new JSONObject();

   
        JSONObject nameObject = new JSONObject();
        nameObject.put("firstName", "varun");
        nameObject.put("lastName", "kumar");
        jsonObject.put("Name", nameObject);

        jsonObject.put("Email", "varun2345@gmail.com");


        jsonObject.put("Phone", new String[]{"1234567890", "0987654321", "1122334455"});

        JSONObject addressObject = new JSONObject();
        addressObject.put("HouseNO", "123");
        addressObject.put("StreetNo", "45");
        addressObject.put("LandMark", "Sri Ram Park");
        addressObject.put("City", "Ayodhya");
        addressObject.put("State", "UttarPradesh");
        addressObject.put("PinCode", "10001");
        jsonObject.put("Address", addressObject);

        JSONObject universityObject = new JSONObject();
        universityObject.put("UniName", "Lovely Professional University");
        universityObject.put("RegNo", "123456789");
        universityObject.put("Branch", "Computer Science and Engineering");
        universityObject.put("Subject", "Software Engineering");
        jsonObject.put("University", universityObject);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .post("http://localhost:3000/user");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asString());
    }
}