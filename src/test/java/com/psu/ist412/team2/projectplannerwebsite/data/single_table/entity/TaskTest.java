package com.psu.ist412.team2.projectplannerwebsite.data.single_table.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task newTestTask = new Task();

    @Test
    void getId() {
    }

    @Test
    void getName__get_correct_name__return_true() {
        newTestTask.setName("John");
        assertTrue(newTestTask.getName() == "John");
    }

    @Test
    void setName__input_non_string__throw_exception() {
    }

    @Test
    void setName__input_string__no_exception() {
    }

    @Test
    void getCustomerId__get_correct_ID__return_true() {
        newTestTask.setCustomerId((short)0);
        assertTrue(newTestTask.getCustomerId() == (short)0);
        assertEquals(newTestTask.getCustomerId(),(short) 0);
    }

    @Test
    void getCustomerId__get_wrong_ID__return_false() {
        newTestTask.setCustomerId((short)0);
        assertFalse(newTestTask.getCustomerId() == (short)1);
        assertNotEquals(newTestTask.getCustomerId(),(short) 1);
    }


    @Test
    void setCustomerId__pass_short__no_exception() {
    }

    @Test
    void getIsDeleted() {
    }

    @Test
    void setIsDeleted() {
    }

    @Test
    void getCreatedAt() {
    }

    @Test
    void getModifiedAt() {
    }

    @Test
    void getTasksList() {
    }

    @Test
    void setTasksList() {
    }
}