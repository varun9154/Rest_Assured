package RestApi;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
public class DemoTestCase {
	
	public static void main(String[] arg) {
		Response response = given().auth().basic("admin", "admin").contentType(ContentType.JSON).get("http://localhost:3000/users");
		//System.out.println("this is the api output: " );
		response.prettyPrint();
	}

}
