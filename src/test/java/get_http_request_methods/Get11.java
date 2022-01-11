package get_http_request_methods;

import base_urls.DummyApiBaseUrl;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Employee;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get11 extends DummyApiBaseUrl {

 /*
      When
        I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
       Status code should be 200
       Use Gson and ObjectMapper
       make sure you have 24 records for data
  */

    @Test
    public void get11 () throws Exception
    {
        //Set the URL
        spec.pathParams("first","api","second","v1","third","employees");

         //Send the request and get the response
        Response response= given().spec(spec).when().get("/{first}/{second}/{third}");

        //Validate the status code
        response.then().statusCode(200);

        //This is a convertor from Java to Json, Json to Java
        ObjectMapper obj= new ObjectMapper(); //import org.codehaus.jackson.map.ObjectMapper; we should pick this import

        Employee employees= obj.readValue(response.asString(), Employee.class);


        for(int i=0; i<employees.getData().size(); i++) {
            System.out.println("The person"+i+" is " + employees.getData().get(i).getEmployee_name());
        }

        assertTrue("The data size does not Match", employees.getData().size()==24);

    }

    @Test
    public void get11D(){
        //Set the URL
        spec.pathParams("first","api","second","v1","third","employees");

        //Send the request and get the response
        Response response= given().spec(spec).when().get("/{first}/{second}/{third}");

        //Do the assertions and validate

        Gson gson= new Gson();

        Employee employees= gson.fromJson(response.asString(), Employee.class);

        System.out.println("The employee data size " + employees.getData().size());

        assertTrue("The data does not match!", employees.getData().size()==24);


    }

}
