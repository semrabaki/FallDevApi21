package delete_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Delete01 extends JsonPlaceHolderBaseUrl {
    /*
        When
            I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
        Then
            Status code is 200
            And Response body is {}
    */

    @Test
    public void delete01() {
        //Set the url

        //spec= new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
        spec.pathParams("first", "todos", "second", 198);
        //Set the excepted data
        Map<String,Object> expectedData= new HashMap<>();
        //Send the delete request and get the response

        Response response = given().spec(spec).when().delete("/{first}/{second}");

        response.then().assertThat().statusCode(200);


        Map<String, Object> actualData= response.as(HashMap.class);

        response.prettyPrint();

        assertEquals("The data does not match!",expectedData,actualData);
    }
}
