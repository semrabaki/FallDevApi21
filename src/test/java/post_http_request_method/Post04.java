package post_http_request_method;

import base_urls.MedunnaBaseUrl;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Registrant;

import static io.restassured.RestAssured.given;
import static utilities.WriteToTxt.saveRegistrantData;

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
    public void post04() {
        //Set the url
        spec.pathParams("first", "api", "second", "register");

//            Registrant registrant = new Registrant();
//            registrant.setFirstName("Semra");
//            registrant.setLastName("Baki");
//            registrant.setLangKey("en");
//            registrant.setPassword("123456D9u");
//            registrant.setEmail("bakisemra@gmail.com");
//            registrant.setLogin("bakiesemra");
//            registrant.setSsn("123-45-6421");


        //            //Generate dummy data
        Faker faker = new Faker();
        String fileName = "C:/Users/semra/IdeaProjects/FallDevApi21/test_data/DummyTestData.txt";
        //Set the expectedData
        Registrant registrant = new Registrant();
        registrant.setFirstName(faker.name().firstName());
        registrant.setLastName(faker.name().lastName());
        registrant.setLangKey("en");
        registrant.setPassword(faker.internet().password(8, 18, true, true));
        registrant.setEmail(registrant.getFirstName() + registrant.getLastName() + "@gmail.com");
        registrant.setLogin(registrant.getFirstName() + registrant.getLastName());
        registrant.setSsn(faker.idNumber().ssnValid());
        // Send the post request and get the response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(registrant).when().post("/{first}/{second}");
        saveRegistrantData(fileName, registrant);
        response.then().assertThat().statusCode(201);

    }

    @Test
    public void post05() {

        //Send the post request to the url https://medunna.com/api/register
        Faker faker = new Faker();
        String endPoint = "https://medunna.com/api/register";
        //Set the expectedData
        Registrant registrant = new Registrant();
        registrant.setFirstName(faker.name().firstName());
        registrant.setLastName(faker.name().lastName());
        registrant.setLangKey("en");
        registrant.setPassword(faker.internet().password(8, 18, true, true));
        registrant.setEmail(registrant.getFirstName() + registrant.getLastName() + "@gmail.com");
        registrant.setLogin(registrant.getFirstName() + registrant.getLastName());
        registrant.setSsn(faker.idNumber().ssnValid());
        Response response = given().when().contentType(ContentType.JSON).body(registrant).post(endPoint);
        response.then().assertThat().statusCode(201);
    }
}


