package get_http_request_methods;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerokuappBaseUrl {

         /*
        When
            I send GET Request to https://restful-booker.herokuapp.com/booking/2
        Then
            Response body should be like that;
            {
                "firstname": "Sally",
                "lastname": "Wilson",
                "totalprice": 335,
                "depositpaid": false,
                "bookingdates": {
                    "checkin": "2015-11-23",
                    "checkout": "2019-08-15"
                 }
            }
     */
         @Test
         public void get09D() {
             spec.pathParams("first", "booking", "second", 2);


             //Set the expected data
             Map<String, Object> expectedBookingDates = new HashMap<>();
             expectedBookingDates.put("checkin", null);
             expectedBookingDates.put("checkout", "2021-01-01");
             Map<String, Object> expectedData = new HashMap<>();
             expectedData.put("statusCode", 200);
             expectedData.put("firstname", "Susan");
             expectedData.put("lastname", "Wilson");
             expectedData.put("totalprice",993 );
             expectedData.put("depositpaid", true);
             expectedData.put("bookingdates", expectedBookingDates);


             //Send the request and get response

             Response response= given().spec(spec).when().get("/{first}/{second}");
             //1.way : body()+ expectedData Map
             response.then().assertThat().body("firstname",equalTo( expectedData.get("firstname")),"checkin",equalTo(expectedBookingDates.get("checkin")));

             //2.way :assertEquals()+ExpectedData Map<==GSON

             Map<String, Object> actualData= response.as(HashMap.class); //In here we use GSON to convert json file to java and put in map
             System.out.println("actualData : "+actualData);

             assertEquals(expectedData.get("statusCode"), response.getStatusCode());
             assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
             assertEquals(expectedBookingDates.get("checkin"), actualData.get("bookingdates.checkin"));


         }
   @Test
    public void get09() {
           spec.pathParams("first", "booking", "second", 2);
           //Set the expected data
           Map<String, Object> expectedBookingDates = new HashMap<>();
           expectedBookingDates.put("checkin", "2020-08-20");
           expectedBookingDates.put("checkout", "2021-01-01");
           Map<String, Object> expectedData = new HashMap<>();
           expectedData.put("firstname", "Mary");
           expectedData.put("lastname", "Wilson");
           expectedData.put("totalprice",993 );
           expectedData.put("depositpaid", true);
           expectedData.put("bookingdates", expectedBookingDates);


           //Send The Get request and Get the response
           Response response = given().spec(spec).when().get("/{first}/{second}");
           response.prettyPrint();
           Map<String, Object> actualData = response.as(HashMap.class); // GSON ---in here we are converting json data to java data
           System.out.println("actualData : "+actualData);

       assertEquals("The data does not match!", expectedData.get("firstname"),actualData.get("firstname") );
       assertEquals("The data does not match!", expectedData.get("lastname"),actualData.get("lastname") );
       assertEquals("The data does not match!", expectedData.get("totalprice"),actualData.get("totalprice") );
       assertEquals("The data does not match!", expectedData.get("depositpaid"),actualData.get("depositpaid") );
       assertEquals("The data does not match!", expectedBookingDates.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin") );
       assertEquals("The data does not match!", expectedBookingDates.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout") );
       assertEquals("The data does not match!", expectedBookingDates,actualData.get("bookingdates") );

//
//

    }
}