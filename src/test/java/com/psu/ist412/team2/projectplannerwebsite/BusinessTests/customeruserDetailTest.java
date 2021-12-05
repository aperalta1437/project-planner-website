package com.psu.ist412.team2.projectplannerwebsite.BusinessTests;

import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.psu.ist412.team2.projectplannerwebsite.business.dto.request.domain.CustomerUserDetails;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository.CustomerRepository;

import org.hibernate.mapping.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class customeruserDetailTest {

    @Test
    void testGetFullName(){

        Customer customer = new Customer();
        customer.setFirstName("Paul");
        customer.setMiddleName("Tom");
        customer.setLastName("Tzivekis");

        CustomerUserDetails customerUser = new CustomerUserDetails(customer);
        customerUser.getFullName();

    }
    
}
