package api;

import io.restassured.response.Response;

import java.util.Map;

public class PetApiCalls extends BaseApiCalls {

    public static Response petGet(String uri, Map<String, String> queryParameters, Object body) {
        return get(uri, queryParameters);
    }

    public static Response petPost(String uri, Map<String, String> queryParameters, Object body) {
        return post(uri, queryParameters, body);
    }

    public static Response petPut(String uri, Map<String, String> queryParameters, Object body) {
        return put(uri, queryParameters, body);
    }

    public static Response petDelete(String uri, Map<String, String> queryParameters, Object body) {
        return delete(uri, queryParameters, body);
    }

}
