import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class GetUserTest {

    @Test
    public void testGetUser(){
        given().baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"))
                .body("data.email", containsString("@reqres.in"))
                .log().all();
    }


}
