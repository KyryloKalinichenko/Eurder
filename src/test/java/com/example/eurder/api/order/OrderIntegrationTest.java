package com.example.eurder.api.order;

import com.example.eurder.api.item.ItemGroupPostDTO;
import com.example.eurder.domain.customer.Address;
import com.example.eurder.domain.customer.Contact;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.repositories.CustomerRepository;
import com.example.eurder.domain.repositories.ItemRepository;
import com.example.eurder.domain.repositories.OrderRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OrderIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer = new Customer("Bob", "Lil",
            new Address("Belgium", "Brussels", "1111", 1),
            new Contact("lol@gmail.com", "7I5687586586"));


    private Item normalItem = new Item("Item", "it is an item", 20.0, 10);
    private Item noStockItem = new Item("Item", "it is an item", 20.0, 0);


    private OrderPostDTO postDTO = new OrderPostDTO(
            List.of(new ItemGroupPostDTO(0, 2), new ItemGroupPostDTO(1, 2)));

    @Test
    void newOrder_BadRequest() {
        itemRepository.addNewType(normalItem);
        customerRepository.addCustomer(customer);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header(new Header("customerId", "0"))
                .body(postDTO)
                .when()
                .port(port)
                .post("order/new")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void newOrder_GoodRequest() {
        itemRepository.addNewType(normalItem);
        customerRepository.addCustomer(customer);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header(new Header("customerId", "1"))
                .body(postDTO)
                .when()
                .port(port)
                .post("order/new")
                .then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}