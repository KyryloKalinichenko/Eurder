package com.example.eurder.api.customer;

import com.example.eurder.domain.customer.Address;
import com.example.eurder.domain.customer.Contact;
import com.example.eurder.domain.customer.Customer;
import com.example.eurder.domain.repositories.CustomerRepository;
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

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CustomerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CustomerRepository repository;

    private CustomerDTO customerDTOIvan = new CustomerDTO("Ivan", "Here",
            new Contact("kfsgkhgf@gmail.com", "858658587658"),
            new Address("Belgium", "Brussels", "1188", 5));

    private CustomerDTO customerDTOJon = new CustomerDTO("Jon", "There",
            new Contact("jon@gmail.com", "8658587658"),
            new Address("Belgium", "Brussels", "1188", 6));



    @Test
    void getCustomerByIdAsAdmin() {

        Customer customerIvan = new Customer(customerDTOIvan);
        Customer customerJon = new Customer(customerDTOJon);

        repository.addCustomer(customerIvan);
        repository.addCustomer(customerJon);

        CustomerDTO toVerify = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header(new Header("token", "admin"))
                .when()
                .port(port)
                .get("customer/2")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(CustomerDTO.class);

        Assertions.assertThat(toVerify).isEqualTo(customerDTOIvan);

    }

    @Test
    void createNewCustomer() {

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(customerDTOIvan)
                .when()
                .port(port)
                .post("customer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value());

    Assertions.assertThat(repository.getCustomers().contains(new Customer(customerDTOIvan)));
    }

    @Test
    void getAllAsAdmin() {
        Customer customerIvan = new Customer(customerDTOIvan);
        Customer customerJon = new Customer(customerDTOJon);

        repository.addCustomer(customerIvan);
        repository.addCustomer(customerJon);

        List<CustomerDTO> list =  RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header(new Header("token", "admin"))
                .when()
                .port(port)
                .get("customer/all")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .body()
                .jsonPath()
                .getList(".", CustomerDTO.class);

        Assertions.assertThat(list).containsExactlyInAnyOrder(customerDTOIvan, customerDTOJon);


    }
}