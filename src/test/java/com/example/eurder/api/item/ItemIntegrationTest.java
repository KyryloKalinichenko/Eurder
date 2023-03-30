package com.example.eurder.api.item;

import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.repositories.CustomerRepository;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ItemIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ItemRepository repository;

    private Item item = new Item("Item", "It is an item", 20.0, 10);



    @Test
    void addItemAsAdmin() {

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header(new Header("token", "admin"))
                .body(item)
                .when()
                .port(port)
                .post("item")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value());

        Assertions.assertThat(repository.getItemById(0)).isEqualTo(item);
    }

    @Test
    void addItem_BadRequest() {

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(item)
                .when()
                .port(port)
                .post("item")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());

    }
}