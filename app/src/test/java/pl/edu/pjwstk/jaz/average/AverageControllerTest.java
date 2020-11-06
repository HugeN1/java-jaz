package pl.edu.pjwstk.jaz.average;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pjwstk.jaz.IntegrationTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@IntegrationTest
public class AverageControllerTest {
    @Test
    public void shouldCalculateAverageInt() {
        var response = given()
                .param("numbers", "4,3,1,7,5")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("srednia: 4"));
    }

    @Test
    public void shouldCalculateAverage() {
        var response = given()
                .param("numbers", "2,1,1")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("srednia: 1.33"));
    }

    @Test
    public void should_show_no_arguments() {
        var response = given()
                .param("numbers", "")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("brak parametrow"));


    }
}