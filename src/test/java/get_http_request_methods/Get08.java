package get_http_request_methods;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {

    /*
     Given
            https://jsonplaceholder.typicode.com/todos/2
     When I send a Get Request
     Then the actual data should be as following;
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }*/
    @Test
    public void get08(){
        //Set the URL
        spec.pathParams("first", "todos","second",2);

        //Set the excepted value
       Map<String,Object> expectedDataMap= new HashMap<>();  //since value has different data types we use object
       expectedDataMap.put("userId",1);
       expectedDataMap.put("id",2);
       expectedDataMap.put("title","quis ut nam facilis et officia qui");
       expectedDataMap.put("completed",false);

       //Send the get reguest and get the response

        Response response= given().spec(spec).when().get("/{first}/{second}");

        Map<String,Object> actualDataMap= response.as(HashMap.class);//In here we convert response data to the Map object

        assertEquals("The data does not Match!!", expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals("The data does not Match!!", expectedDataMap.get("id"),actualDataMap.get("id"));
        assertEquals("The data does not Match!!", expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals("The data does not Match!!", expectedDataMap.get("completed"),actualDataMap.get("completed"));




    }

    /*
     Given
            https://jsonplaceholder.typicode.com/todos/2
     When I send a Get Request
     Then the actual data should be as following;
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }*/
    @Test
    public void get08D(){
        //Set the url
        spec.pathParams("first", "todos", "second", 2);
        //Set the expected data
        Todo expectedTodo = new Todo(1, 2,"quis ut nam facilis et officia qui", false );
        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //2. way of setting the expected data
        Todo actualTodo = response.as(Todo.class);


        assertEquals("The data does not match!",expectedTodo.getId(), actualTodo.getId());
        assertEquals("The data does not match!",expectedTodo.getUserId(), actualTodo.getUserId());
        assertEquals("The data does not match!",expectedTodo.getTitle(), actualTodo.getTitle());
        assertEquals("The data does not match!",expectedTodo.isCompleted(), actualTodo.isCompleted());
        System.out.println("The id: "+actualTodo.getId());
        System.out.println("The userId: "+actualTodo.getUserId());
        System.out.println("The user title: "+actualTodo.getTitle());
        System.out.println("The isCompleted: "+actualTodo.isCompleted());




    }
}
