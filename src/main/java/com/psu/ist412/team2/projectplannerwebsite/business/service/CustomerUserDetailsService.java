package com.psu.ist412.team2.projectplannerwebsite.business.service;

import com.psu.ist412.team2.projectplannerwebsite.business.dto.request.domain.CustomerUserDetails;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.Customer;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomerUserDetails(customer);
    }
}
