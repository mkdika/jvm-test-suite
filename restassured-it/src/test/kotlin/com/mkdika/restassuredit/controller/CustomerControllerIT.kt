package com.mkdika.restassuredit.controller

import com.mkdika.restassuredit.RestassureditApplication
import com.mkdika.restassuredit.model.Customer
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.tuple
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(RestassureditApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CustomerControllerIT {

    companion object {
        @BeforeClass
        @JvmStatic
        fun `setup`() {
            RestAssured.port = 8080
            RestAssured.baseURI = "http://localhost"
        }
    }

//    @Before
//    fun setup() {
//        RestAssured.port = 8080
//        RestAssured.baseURI = "http://localhost"
//    }

//    @BeforeClass
//    @JvmStatic
//     fun setup() {
//        RestAssured.port = 8080
//        RestAssured.baseURI = "http://localhost"
//    }

    @Test
    fun `given when called findAllCustomer then should return list of Customer`() {

        // Given & When - REST Assured
        val listOfCustomer = given()
                .`when`()
                .get("/customer")
                .then()
                .statusCode(200)
                .extract().`as`(CustomerList::class.java)

        // Then - AssertJ
        assertThat(listOfCustomer.size).isEqualTo(3)
        assertThat(listOfCustomer).isNotNull.extracting("firstName").containsExactly("Maikel", "Max", "John")
    }

    @Test
    fun `given id when call findCustomerById then should return customer`() {

        // Given & When
        val customer = given()
                .`when`()
                .get("/customer/3")
                .then()
                .statusCode(200)
                .extract().`as`(Customer::class.java)

        // Then
        assertThat(customer).isNotNull
                .extracting("firstName", "lastName")
                .contains("John", "Doe")
    }
}

class CustomerList : MutableList<Customer> by ArrayList()