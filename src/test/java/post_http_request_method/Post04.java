package post_http_request_method;

import base_urls.MedunnaBaseUrl;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Registrant;

import static io.restassured.RestAssured.given;

public class Post04 extends MedunnaBaseUrl {

//Send the post request to the url https://medunna.com/api/register
    /*
            create a new user for Medunna project
                status code should be 200
                {
                    "activated": true,
                        "authorities": [
                    "string"
                              ],
                    "createdBy": "string",
                        "createdDate": "2022-01-03T19:25:02.075Z",
                        "email": "string",
                        "firstName": "string",
                        "id": 0,
                        "imageUrl": "string",
                        "langKey": "string",
                        "lastModifiedBy": "string",
                        "lastModifiedDate": "2022-01-03T19:25:02.075Z",
                        "lastName": "string",
                        "login": "string",
                        "password": "string",
                        "ssn": "string"
                }
                 */
    @Test
    public void post04(){

        spec.pathParams("first","api","second","register");

        //Generate dummy data
        Faker faker= new Faker();

        String fileName= "C:/Users/semra/IdeaProjects/FallDevApi21/test_data/DummyTestData.txt";


        //Set the expected data

        Registrant registrant= new Registrant();
        registrant.setFirstName(faker.name().firstName());
        registrant.setLastName(faker.name().lastName());
        registrant.setLangKey("en");
        registrant.setPassword(faker.internet().password(8,18,true,true));
        registrant.setEmail(registrant.getFirstName()+registrant.getLastName()+"@gmail.com");
        registrant.setLogin(registrant.getFirstName()+registrant.getLastName());
        registrant.setSsn(faker.idNumber().ssnValid());

        //Send the post request and get the response
        Response response= given().spec(spec).contentType(ContentType.JSON).body(registrant).when().post("/{first}/{second)");

       // WriteToTxt.saveRegistrantData(fileName, registrant);
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void post05(){


    }


}
