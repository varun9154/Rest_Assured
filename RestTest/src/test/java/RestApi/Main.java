package RestApi;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
public class Main{
	public static void main (String[]args) {
	Response respones =given().contentType("application/json")
			/*.formParam("id","9")
			.formParam("customerName","varun")
			.formParam("email","varun@gmail.com")
			.formParam("phone no","897398648782")
			.formParam("order Id","ORD12349")
			.post("http://localhost:3000/team");*/
			.body("{\r\n"
	              + "    \"id\": \"9\",\r\n"
	                + "    \"customerName\": \"varun\",\r\n"
	               + "    \"email\": \"varun@gmail.com\",\r\n"
	              + "    \"phoneNo\": \"8519928264\",\r\n"
	               + "    \"orderId\": \"ORD1234789\"\r\n"
	                + "}")
	            .post("http://localhost:3000/customers");
			respones.prettyPrint();
	//System.out.println(respones.asPrettyString());
	}
}