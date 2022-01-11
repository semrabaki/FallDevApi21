package get_http_request_methods;

import base_urls.RestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class GetRequestSuleymanHoca09 extends RestApiBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employees
    Then
    Status code 200
    1) Print all ids greater than 10 on the console
    Assert that there are 14 ids greater than 10
    2)Print all ages less then 30 on the console
    Assert that maximum age less than 30 ie 23

    3) Print all employee names whose salaris are greters than 350.000
    Assert that "Charde Marshall is one of the employees whose saalry us greater than 350.000

     */

    @Test
    public void get01(){

        //Set the url
        spec.pathParams("first", "api", "second", "v1", "third", "employees");
        //Set the expected data
        //Send the request and get the response

        Response response= given().spec(spec).when().get("/{first}/{second}/{third}");
        //send request and get response

        response.prettyPrint();

        JsonPath json= response.jsonPath();

        response.then().assertThat().statusCode(200); //assertEquals(200, response.getStatusCode());

        //1)Print all ids  greater than 10 on the console

        List<String> idList=json.getList("data.findAll{Integer.parseInt(it.id)>10}.id"); //or you can use Integer.valueOf
        System.out.println(idList);

        assertEquals(14,idList.size());

        //2)Print all ages less then 30 on the console







    }
}
