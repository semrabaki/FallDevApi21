package get_http_request_methods;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


/**
 *
 */
public class Get05 extends HerokuappBaseUrl {

    /*
            Given
                https://restful-booker.herokuapp.com/booking
            When
                User send a request to the URL
            Then
                Status code is 200
            And
               Among the data there should be someone whose firstname is "Mary" and last name is "Wilson"
 */

    //since we are loking specfic data type we use query params.
    @Test
    public void get05(){
        //Set the url
        spec.pathParam("first", "booking").queryParams("firstname","Eric","lastname","Ericsson");

       //Send the get request and get the reponse
        Response response= given().spec(spec).when().get("/{first}");
        response.prettyPrint();

      //  response.then().assertThat()
        response.then().assertThat().statusCode(200);




    }



}
