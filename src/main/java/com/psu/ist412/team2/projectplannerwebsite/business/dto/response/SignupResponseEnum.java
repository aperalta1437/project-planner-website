package com.psu.ist412.team2.projectplannerwebsite.business.dto.response;

public enum SignupResponseEnum {
    SUCCESS("You have signed up successfully!"),
    EXISTING_EMAIL("The email you provided is already associated with an existing account"),
    SERVER_ERROR("An error occurred while processing your request. Please try again later.");

    private final String signupMessage;

    SignupResponseEnum(String signupMessage) {
        this.signupMessage = signupMessage;
    }

    public String getSignupMessage() {
        return this.signupMessage;
    }
}
