package get_http_request_methods;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response format should be “application/json”
        And
            “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
        And
            “completed” is false
        And
            “userId” is 2
     */
    @Test
    public void get03D() {

        //St the url
        spec.pathParams("first","todos","second",23);

        //Set the excepted data

        //Send the get request and get resposne
         Response response= given().spec(spec).when().get("/{first}/{second}");

         response.prettyPrint();

        //assertions validation

        response.
            then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
            body("completed",equalTo(false)).
                body("userId",equalTo(2));

    }


    @Test
     public void get03(){
         //Set the url
        spec.pathParams("first","todos","second",23);


        //Set the expected data


        //Send the request and get the response

       Response response= given().spec(spec).when().get("/{first}/{second}");

       //response.prettyPrint();

        //Do the assertions and validate

//        //this is 1.way
//        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
//                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
//                body("completed",equalTo(false)).
//                body("userId",equalTo(2));
//
//        //2nd way
//        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),"completed",equalTo(false),"userId",equalTo(2));
//
        //3.way
        assertEquals(200, response.getStatusCode());
        assertEquals("application/json; charset=utf-8", response.getContentType());
        assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));


    }
}
