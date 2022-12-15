import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;

public class PostRestAssuredTest {
    public static final String URL = "https://reqres.in/";

    @Test
    @DisplayName("Создать пользователя, Fluent стиль")
    public void postTestFluent() {
        String user = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        RestAssured
                .given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("api/users")
                .then().log().all()
                .statusCode(201);
    }

    @Test
    @DisplayName("Создать пользователя")
    public void postTestSpecification() {
        String user = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        RequestSpecification request = RestAssured.given();
        request.baseUri(URL);
        request.body(user);
        request.then().statusCode(201)
                .header("Content-Type", "application/json; charset=utf-8");
        request.contentType(ContentType.JSON);

        Response response = request.post("api/users");
        String regex = "(.{17})$";
        String currentDate = Clock.systemUTC().instant().toString().replaceAll(regex, "");
        String postDate = response.jsonPath().getString("createdAt");
        Assertions.assertTrue(postDate.contains(currentDate));
        response.prettyPrint();
    }

    @Test
    @DisplayName("Создать пользователя без пароля")
    public void reqresWithSpecificationTest() {
        Specifications.installSpec(Specifications.reqresRequestSpec(), Specifications.responseSpecError400());

        UserRegister userRegister = new UserRegister("sydney@fife", "");

        Response response = RestAssured.given()
                .body(userRegister)
                .when()
                .post("/api/register");

        response.prettyPrint();
    }
}
