package com.mkdika.restassuredit.repository

import com.mkdika.restassuredit.model.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Int>