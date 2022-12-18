package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojoclasses.UserRegister;

import java.time.Clock;

import static io.restassured.RestAssured.expect;

public class PostRestAssuredTest {
    public static final String URL = "https://reqres.in/";

    @Test
    @DisplayName("Создать пользователя, Fluent стиль")
    public void postTestFluent() {
        String user = """
                {
                    "name": "morpheus",
                    "job": "leader"
                }""";
        expect()
                .statusCode(201)
                .given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("api/users")
                .then().log().all();
    }

    @Test
    @DisplayName("Создать пользователя")
    public void postTest() {
        String user = """
                {
                    "name": "morpheus",
                    "job": "leader"
                }""";

        RequestSpecification request = RestAssured.given();
        request.baseUri(URL);
        request.body(user);
        request.expect().statusCode(201);
        request.header("Content-Type", "application/json; charset=utf-8");
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

        UserRegister userRegister = new UserRegister("sydney@fife", "");

        Response response =
                expect().statusCode(400)
                        .given()
                        .contentType(ContentType.JSON)
                        .body(userRegister)
                        .when()
                        .post(URL + "api/register");

        response.prettyPrint();
    }
}
