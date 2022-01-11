package get_http_request_methods;

import base_urls.DummyApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get07 extends DummyApiBaseUrl {
/*
    Given
    http://dummy.restapiexample.com/api/v1/employee/7
    When
    I send a GET request to the Url
    Then
    HTTP Status Code should be 200
    And
    Response format should be "application/json"
    And
    Herrod Chandler should be the employee name
            And
            "employee_salary":137500 should be expected salary
    And
           "id":7 should be expected id
     */
@Test
public void get07D() {

    spec=spec.pathParams("first","api", "second","v1","third","employee","final",7);

    Response response= given().spec(spec).when().get("/{first}/{second}/{third}/{final}");

    response.prettyPrint();



    JsonPath json= response.jsonPath();

   assertEquals(137500,json.getInt("data.employee_salary"));
   assertEquals("Herrod Chandler",json.getString("data.employee_name"));
    assertEquals(7,json.getInt("data.id"));


}

    @Test
    public void get07()
    {
        spec.pathParams("first","api", "second","v1","third","employee","final",7);
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");

       // response.prettyPrint();

        //Do the assertions and validate
        //1.way of validation :Use body()
      //  response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK").contentType(ContentType.JSON).
        //        body("data.employee_name", equalTo("Herrod Chandler")).body("data.employee_salary",equalTo(137500)).body("data.id",equalTo(7));


        //2.way of validation:JsonPathClass +Hard Assertion
        //JsonPath class is good to naviagte and to assert for JSON Data
        JsonPath json= response.jsonPath();
        System.out.println(json.getString("$")); //this is to see all data
        System.out.println(json.getString("data.employee_name"));
        System.out.println(json.getString("data.employee_salary").equals("137500"));
                                          //String                            String
        System.out.println(json.getInt("data.employee_salary")==137500);



        //3.way:Use JSonPath Class+Soft Assertion
        //Soft assertion

        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(json.getString("data.employee_name"),"Herrod Chandler", "The data Does not match");
        softAssert.assertEquals(json.getInt("data.employee_salary"), 137500, "The data Does not match");
        softAssert.assertAll();

    }
}
