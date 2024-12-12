package RestApi;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.response.Response;

public class Hashmap {
    public static void main(String[] args) {
    
        HashMap<String, String> map = new HashMap<>();
       
        map.put("id", "10");
        map.put("customerName", "varun kumar");
        map.put("email", "varu234@gmail.com");
        map.put("phoneNo", "654736938674");  
        map.put("orderId", "ORD12569");      
        
        Response response = given()
            .contentType("application/json")
            .body(map)
            .post("http://localhost:3000/customers");

        
        response.prettyPrint();
    }
}

