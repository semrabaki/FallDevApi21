package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

public class Post03 extends JsonPlaceHolderBaseUrl {

     /*
       When
             I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
             with the request body {
                                   "userId": 55,
                                   "title": "Tidy your room",
                                   "completed": false
                                  }
       Then
           Status code is 201
           And response body is like {
                                       "userId": 55,
                                       "title": "Tidy your room",
                                       "completed": false,
                                       "id": 201
                                     }
    */
    @Test
    public void post03(){
        //Set the url
        spec.pathParam("first","todos");

        //Set the expected data

        //Map<String, Object> exceptedData= JsonPlaceHolderData.exceptedDataSeteup();


    }
}
