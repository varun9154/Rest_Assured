package CRUD;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Demo {
	public static void main(String[] args) {
	Response response = given().auth().basic("user", "password")
	.contentType(ContentType.JSON)
	.contentType("application/json")
	.header("contentType", "application/json")
	.get( "http://localhost:3000/customers");
	
	response.prettyPrint();
	}

}
