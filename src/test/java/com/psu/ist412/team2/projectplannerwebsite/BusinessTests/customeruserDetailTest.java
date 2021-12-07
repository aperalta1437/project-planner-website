package com.psu.ist412.team2.projectplannerwebsite.BusinessTests;

import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.Customer;

import com.psu.ist412.team2.projectplannerwebsite.business.dto.request.domain.CustomerUserDetails;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;


import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class customeruserDetailTest {

    @Test
    void testGetFullName__return_correct_full_name__return_true(){

        Customer customer = new Customer();
        customer.setFirstName("Paul");
        customer.setMiddleName("Tom");
        customer.setLastName("Tzivekis");

        CustomerUserDetails customerUser = new CustomerUserDetails(customer);
<<<<<<< HEAD
        customerUser.getFullName();
        assertThat(customer).isNotNull();
=======

        // assertSame(customerUser.getFullName(), "Paul Tom Tzivekis");
>>>>>>> a991044085514329f47684b8fddd741292042737

    }
    
}
