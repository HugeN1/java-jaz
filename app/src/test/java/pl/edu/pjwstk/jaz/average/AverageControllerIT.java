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
public class AverageControllerIT {
    @Test
    public void should_calculate_simple_average() {
        var response = given()
                .param("numbers","1,2,3,4")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Average equals: 2,50"));


    }

    @Test
    public void should_calculate_simple_average_integer() {
        var response = given()
                .param("numbers","4,2,0,2")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Average equals: 2"));


    }

    @Test
    public void should_show_no_arguments() {
        var response = given()
                .param("numbers","")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Please put parameters"));


    }

    @Test
    public void should_correctly_calculate_rounding_numbers() {
        var response = given()
                .param("numbers","77,35,11,5,6,15,-3")
                .when()
                .get("/api/average")
                .then()
                .statusCode(200)
                .body(equalTo("Average equals: 20,86"));


    }
}