package get_http_request_methods;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02  extends HerokuappBaseUrl {

    /*
            Negative Senario
            Given https://restful-booker.herokuapp.com/booking/1001
            When user sends a GET request to the url
            Then HTTP status code should be 404
            And   response body contains "Not Found"
            And status line should be HTTP/1.1 404 Not Found
            And body does not contain "techproed"
            And Server is "Cowboy"
             */
           @Test
           public void get02D() {
               //Set the url
               spec.pathParams("first", "booking", "second", "1001");
               //Set the excepted data

               //Send get request and get response

               Response response = given().spec(spec).when().get("/{first}/{second}");
               //Assertion and validation
               response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
//               assertTrue(response.asString().contains("Not Found"));
//               assertFalse(response.asString().contains("TechPRoEd"));
//               assertEquals(response.getHeader("Server"), "Cowboy");

               //How to do Soft asssertion

               //a)Create soft assertion object

               SoftAssert softAssert= new SoftAssert();

               //b)use assertions with soft Asset object
               System.out.println("=============================>");
               softAssert.assertTrue(response.asString().contains("Not Found"));
               System.out.println("=============================>");
               softAssert. assertFalse(response.asString().contains("TechPRoEd"));
               System.out.println("=============================>");
               //c) Use AssertAll()<==DO not forget
               softAssert.assertAll();


           }
           @Test
           public void get02(){
               //Set the URL
               spec.pathParams("first", "booking","second",1001);

               //Set the expected data

               //Send the request and Get the response  (since I try to get data I put get after when()
               Response response=given().spec(spec).when().get("/{first}/{second}");  // this request gets data

               response.prettyPrint();

               //Do the assertions and validate
               response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

               //When you use JUNIT assertation, you can leave a message at the begining
               //When you use assertion with TestNG annotations, then you can leave the message at the end
               //When we use assert true==> our expectation is true as result
               assertTrue("The data excepted does not Match",response.asString().contains("Not Found"));
               //When we use assert false=> our excepttaion os False
               assertFalse(response.asString().contains("techproed"));

               System.out.println(response.getHeader("Server"));
               assertEquals(response.getHeader("Server"), "Cowboy");




           }
}
