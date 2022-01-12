package patch_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Patch01 extends JsonPlaceHolderBaseUrl{

    /*
 When
     I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
     with the PUT Request body like {
                                     "title": "Tidy your room"
                                    }
Then
    Status code is 200
    And response body is like  {
                                 "userId": 10,
                                 "title": "Tidy your room",
                                 "completed": true,
                                 "id": 198
                               }
    */
    @Test
    public void patch01() {

       // spec= new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
        spec.pathParams("first", "todos", "second", 198);

        //Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        //expectedData.put("title", "Tidy your room 777 patch");
        //expectedData.put("title", "Tidy your room");
        expectedData.put("userId", 50);


        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                body(expectedData).
                when().
                patch("/{first}/{second}");

        response.prettyPrint();

        //Validation

        response.then().assertThat().statusCode(200);
    }
}