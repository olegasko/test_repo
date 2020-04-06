package collers;

import com.jayway.restassured.response.Response;
import lombok.NoArgsConstructor;

import static com.jayway.restassured.RestAssured.when;


@NoArgsConstructor
public class LocationCall {

    public static Response getLocation() {
        return when().get("https://www.epam.com/services/geolocation").andReturn();
    }
}
