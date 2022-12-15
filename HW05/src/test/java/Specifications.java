import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification weatherRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://api.weather.yandex.ru/v2/forecast?lat=48.7194&lon=44.5018&ru_RU&extra=true")
                .setContentType(ContentType.JSON)
                .addHeader("X-Yandex-API-Key", "ca8e2bb3-f2e8-4d64-a253-58f845c6b06c")
                .build();
    }

    public static RequestSpecification reqresRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecError400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static void installSpec(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    public static ResponseSpecification responseSpecUnique(int status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }
}