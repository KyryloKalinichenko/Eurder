package com.example.eurder.api.item;

import com.example.eurder.domain.repositories.ItemRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ItemIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ItemRepository repository;

    private ItemPostDTO itemPostDTO = new ItemPostDTO("Item", "It is an item", 20.0, 10);



    @Test
    void addItemAsAdmin() {

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header(new Header("token", "admin"))
                .body(itemPostDTO)
                .when()
                .port(port)
                .post("item")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value());

        Assertions.assertThat(repository.getAllItems().contains(itemPostDTO));
    }

    @Test
    void addItem_BadRequest() {

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(itemPostDTO)
                .when()
                .port(port)
                .post("item")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }
}