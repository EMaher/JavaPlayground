package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {
    private Student s;

    @BeforeEach
    void setUp() {
        s = new Student("John", "Doe", 10.0);
    }

    @Test
    void studentProperties() {
        assertEquals("John", s.getFirstName(), "firstName should match");
        assertEquals("Doe", s.getLastName(), "lastName should match");
        assertEquals(10.0, s.getCurrentGrade(), "currentGrade should match");
    }

    @Test
    void studentSetters() {
        s.setFirstName("Jane");
        s.setLastName("Smith");
        s.setCurrentGrade(11.0);
        
        assertEquals("Jane", s.getFirstName(), "firstName should be updated");
        assertEquals("Smith", s.getLastName(), "lastName should be updated");
        assertEquals(11.0, s.getCurrentGrade(), "currentGrade should be updated");
    }
}
