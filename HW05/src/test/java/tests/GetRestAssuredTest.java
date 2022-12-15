package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojoclasses.WeatherFact;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class GetRestAssuredTest {
    public static final String weatherURL = "https://api.weather.yandex.ru/v2/forecast?lat=48.7194&lon=44.5018&ru_RU&extra=true";
    public static final String[] apiKey = {"X-Yandex-API-Key", "ca8e2bb3-f2e8-4d64-a253-58f845c6b06c"};

    @Test
    @DisplayName("Проверка доступа к Яндекс.Погода")
    public void getWeatherFluentTest() {
        RestAssured
                .given()
                .header(apiKey[0], apiKey[1])
                .when()
                .get(weatherURL)
                .then().log().all()
                .statusCode(200);
    }

    @Test
    @DisplayName("Вывод погоды в Волгограде")
    public void getWeatherTest() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader(apiKey[0], apiKey[1])
                .build();

        Response response = given()
                .expect()
                .header("Content-Type", "application/json")
                .statusLine("HTTP/1.1 200 OK")
                .statusCode(200)
                .when()
                .get(weatherURL);

        WeatherFact weatherFact = response
                .then()
                .extract().body().jsonPath().getObject("fact", WeatherFact.class);
        String name = response.jsonPath().getString("geo_object.locality.name");

        Assertions.assertEquals("Волгоград", name);
        System.out.println("В городе " + name + "\nТекущая погода: " + weatherFact.getTemp() + "°C"
                + "\nОщущаемая температура: " + weatherFact.getFeels_like() + "°C"
                + "\nВлажность воздуха: " + weatherFact.getHumidity() + "%");
    }

    @Test
    @DisplayName("Проверка, что доступ без ключа запрещен")
    public void accessForbiddenWithoutKey() {
        ResponseSpecification response = RestAssured.expect();
        response.statusLine("HTTP/1.1 403 Forbidden");
        response.statusCode(403);

        RequestSpecification request = RestAssured.given();
        request.baseUri(weatherURL);
        request.get();
    }

    @Test
    public void weatherWithSpecificationTest() {
        Specifications.installSpec(Specifications.weatherRequestSpec(), Specifications.responseSpecOK200());

        WeatherFact weatherFact = given()
                .when()
                .get()
                .then()
                .extract().body().jsonPath().getObject("fact", WeatherFact.class);
        System.out.println("Давление (в мм рт. ст.): " + weatherFact.getPressure_pa());
    }
}
