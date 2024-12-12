package RestDemo;

import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PassProductValues {

    @BeforeClass
    public void setup() {
        baseURI = "http://localhost:3000/users";
    }

    @Test
    public void TestRunner() {
        Product.Name name = new Product.Name("13", "teja045");
        Product.Address address = new Product.Address("754", "88", "Banglore", "Karnataka", "13451");
        Product.OrderId orderId = new Product.OrderId("ID0876", "P344", "Iphone");

        ArrayList<String> phoneNumbers = new ArrayList<>(Arrays.asList("128734670", "02734874321", "198656455"));
        Product product = new Product(name, "teja3456@gmail.com", phoneNumbers, address, orderId);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(product) // Serialize the product object to JSON
                .post("http://localhost:3000/users"); // Endpoint should match the server configuration

        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201, "Expected status code 201 but found " + actualStatusCode);
    }

    @Test
    public void InvalidOutput() {
        Product.Name name = new Product.Name("14", "varun045");
        Product.Address address = new Product.Address("754", "88", "Banglore", "Karnataka", "13451");
        Product.OrderId orderId = new Product.OrderId("ID0876", "P344", "Iphone");

        ArrayList<String> phoneNumbers = new ArrayList<>(Arrays.asList("128734670", "02734874321", "198656455"));
        Product product = new Product(name, "teja3456@gmail.com", phoneNumbers, address, orderId);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(product) // Serialize the product object to JSON
                .post("http://localhost:3000/users"); // Endpoint should match the server configuration

        response.prettyPrint();
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201, "Expected status code 201 but found " + actualStatusCode);
    }
}
