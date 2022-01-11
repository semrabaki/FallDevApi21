package get_http_request_methods;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

    /*
     Given https://restful-booker.herokuapp.com/booking/3

        When user sends a GET request to the url

        Then HTTP status code should be 200

        And   content type should be Json

        And status line should be HTTP/1.1 200 OK
     */
    @Test
    public void get01D(){
        String url="https://restful-booker.herokuapp.com/booking/3";

        Response response= given().accept("application/json").when().get(url);

        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        System.out.println(response.contentType());


    }


    @Test
   public void get01()
   {
       //1.Set url
       String url="https://restful-booker.herokuapp.com/booking/3";

       //2.Set our expected data
       //3.Send our request and get response
       Response response=given().accept("application/json").when().get(url);
       response.prettyPrint();
       //4.Do assertions
       //Hard assertion: means that ones there is one mistake you can not proceed
       //soft assertion: you see the all failing steps
       response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        //How to print content-type, status code,status line, etc. on the cosole..
       System.out.println(response.contentType());
       System.out.println(response.getStatusCode());
       System.out.println(response.statusLine());
       System.out.println(response.getHeaders());
       System.out.println(response.getHeader("Date"));


   }

}
