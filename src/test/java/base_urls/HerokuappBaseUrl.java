package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.junit.Before;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class HerokuappBaseUrl {

    //we will use RequestSpecification for storing base url into it
    protected RequestSpecification spec;

    @Before    //this means it will be runnning before any test cases like static block
    public void setup(){

        spec= new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();





    }
}
