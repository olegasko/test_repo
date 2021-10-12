package api;



import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;


public abstract class BaseApiCalls {

    private static final String HOST = "https://petstore.swagger.io";
    private static final String API_VERSION = "/v2";

    protected static Response get(String uri, Map<String, String> queryParameters) {
        return
                given().
                        contentType(ContentType.JSON).
                        when().
                        get(HOST + API_VERSION + uri);
    }

    protected static Response post(String uri, Map<String, String> queryParameters, Object body) {

        return given().
                contentType(ContentType.JSON).
                body(body).
                log().body().
                when().
                post(HOST + API_VERSION + uri);
    }

    protected static Response put(String uri, Map<String, String> queryParameters, Object body) {
        return given().
                contentType(ContentType.JSON).
                body(body).
                log().body().
                when().
                post(HOST + API_VERSION + uri);
    }

    protected static Response delete(String uri, Map<String, String> queryParameters, Object pet) {
        return given().
                contentType(ContentType.JSON).
                log().body().
                when().
                delete(HOST + API_VERSION + uri);
    }

}
