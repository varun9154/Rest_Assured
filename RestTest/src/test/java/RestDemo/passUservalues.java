package RestDemo;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class passUservalues {
    public static void main(String[] args) {
      
        User.Name name = new User.Name("Varun", "Kumar");
        User.Address address = new User.Address("123", "65", "Near Park", "New York", "NY", "10001");
        User.University university = new User.University("Lovely Professional University", "123456789", "Computer Science and Engineering", "Software Engineering");
        List<String> phoneNumbers = Arrays.asList("1234567890", "0987654321", "1122334455");
        User user = new User(name, "varun3456@gmail.com", phoneNumbers, address, university);
        Response response = given()
            .contentType(ContentType.JSON)
            .body(user)
            .post("http://localhost:3000/users");
        response.prettyPrint();
        System.out.println(response.jsonPath().get("name[0]").toString());
        System.out.println(response.jsonPath().getMap("id").size());
    } 
}