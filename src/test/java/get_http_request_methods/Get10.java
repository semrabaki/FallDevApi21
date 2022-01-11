package get_http_request_methods;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get10 extends DummyApiBaseUrl {

    /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
            Make sure Rhona Davidson earns more than Herrod Chandler
           {
            "id": 7,
            "employee_name": "Herrod Chandler",
            "employee_salary": 137500,
            "employee_age": 59,
            "profile_image": ""
        },
        {
            "id": 8,
            "employee_name": "Rhona Davidson",
            "employee_salary": 327900,
            "employee_age": 55,
            "profile_image": ""
        },
     */
    @Test
    public void get10D(){

        //set the url
        spec.pathParams("first","api","second","v1","third","employee","final",7);

    }
    @Test
    public void get10() {
        //set the url
        spec.pathParams("first", "api", "second", "v1", "third", "employee","final",7);

        //Set get request and get response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");

        // response.prettyPrint();

        //Do the assertions  for status code and content type

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        JsonPath json1=response.jsonPath();  //This creates JSON path object

        int salaryOfHarrod=json1.getInt("data.employee_salary");
        System.out.println(salaryOfHarrod);

       //Set the URL for second person

        spec.pathParams("first", "api", "second", "v1", "third", "employee","final",8);

        Response response2 = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");


        JsonPath json2= response2.jsonPath();

        int salaryOfRhona= json2.getInt("data.employee_salary");
        System.out.println(salaryOfHarrod);


        assertTrue("The salary exceptation does not match! ", salaryOfHarrod<salaryOfRhona);
    }
}
