package ch.thts.rest;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void getBooks() throws Exception {
        when().get("api/books")
                .then()
                .statusCode(200)
                .body("[0].title", equalTo("Faust"));
    }

}