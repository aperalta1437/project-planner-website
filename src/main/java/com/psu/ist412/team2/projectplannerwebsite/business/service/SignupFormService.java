package com.psu.ist412.team2.projectplannerwebsite.business.service;

import com.psu.ist412.team2.projectplannerwebsite.business.dto.request.form.SignupForm;
import com.psu.ist412.team2.projectplannerwebsite.business.dto.response.SignupResponseEnum;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity.Customer;
import com.psu.ist412.team2.projectplannerwebsite.data.single_table.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupFormService {
    private final CustomerRepository customerRepository;

    @Autowired
    public SignupFormService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public SignupResponseEnum processNewSignup(SignupForm signupForm) {
        if (this.customerRepository.existsByEmail(signupForm.getEmail())) {
            return SignupResponseEnum.EXISTING_EMAIL;
        } else {
            if (this.signupNewCustomer(signupForm)) {
                return SignupResponseEnum.SUCCESS;
            } else {
                return SignupResponseEnum.SERVER_ERROR;
            }
        }
    }

    public boolean signupNewCustomer(SignupForm signupForm) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();        // TODO replaced this encoder with spring security bean for customer.
        String encodedPassword = encoder.encode(signupForm.getPassword());
        Customer newCustomer = new Customer(signupForm.getEmail(), encodedPassword, signupForm.getFirstName(),
                signupForm.getMiddleName(), signupForm.getLastName(), signupForm.getCellPhoneNumber(), false);

        boolean isNewCustomerSaved;
        try {
            this.customerRepository.save(newCustomer);
            isNewCustomerSaved = true;
        } catch (Exception ex) {
            // TODO - Log the exception message.
            isNewCustomerSaved = false;
        }
        return isNewCustomerSaved;
    }
}

