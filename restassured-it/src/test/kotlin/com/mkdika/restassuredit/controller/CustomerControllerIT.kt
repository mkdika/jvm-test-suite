package com.mkdika.restassuredit.controller

import com.mkdika.restassuredit.model.Customer
import io.restassured.RestAssured.given
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CustomerControllerIT {

    @Test
    fun `given when called findAllCustomer then should return list of Customer`() {

        // Given & When
        val listOfCustomer = given()
                .`when`()
                .get("/customer")
                .then()
                .statusCode(200)
                .extract().`as`(CustomerList::class.java)

        // Then
        assertThat(listOfCustomer).isNotNull
        assertThat(listOfCustomer.size).isEqualTo(3)
//        assertThat(listOfCustomer).contains("Maikel")

    }
}

class CustomerList : MutableList<Customer> by ArrayList()