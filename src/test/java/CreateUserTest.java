import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class CreateUserTest {
@Test
    public void testCreateUserTest(){
        File jsonFile = new File("src/test/resources/create_user.json");

      Response response =
            given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                .body(jsonFile)
                .when()
                .post()
                .then()
                .statusCode(201)
                    .body("name", equalTo("morpheus"))
                    .body("job", equalTo("leader"))
                    .body("id", notNullValue())
                .log().all()
                .extract().response();
    }

}
