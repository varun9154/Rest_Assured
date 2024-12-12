package CRUD;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Postrequest {
	public static void main(String[] args) {
		Response response = given().contentType(ContentType.JSON)
		/*.formParam("id","123")
		.formParam("roll no", "24")
		.formParam("Name", "varun")
		.formParam("address", "Bellary")*/
				.body("{\r\n"
			              + "    \"id\": \"15\",\r\n"
			                + "    \"roll no\": \"123\",\r\n"
			               + "    \"name\": \"varun\",\r\n"
			              + "    \"address\": \"Bellary\",\r\n"
			               + "    \"orderId\": \"ORD1234789\"\r\n"
			                + "}")
		.post("http://localhost:3000/customers");
		response.prettyPrint();
	}

}
