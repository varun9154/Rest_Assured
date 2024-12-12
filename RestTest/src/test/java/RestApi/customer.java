package RestApi;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
public class customer {
	
	public static void main(String[] arg) {
		Response response = given().auth().basic("admin", "admin").contentType(ContentType.JSON).get("http://localhost:3000/customers");
		System.out.println(response.prettyPrint() );
		//response.prettyPrint();
	}

}