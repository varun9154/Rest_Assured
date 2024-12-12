package RestDemo;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;

public class passMutlipleArray {
    public static void main(String[] args) {

    	MutlipleArray obj = new MutlipleArray("16","Rashu","rashu4321@gmail.com",Arrays.asList("6243145375", "9876543210"), "ORD7832");

        Response response = given()
            .contentType(ContentType.JSON)
            .body(obj)
            .post("http://localhost:3000/customers");
        response.prettyPrint();
    }
} 
