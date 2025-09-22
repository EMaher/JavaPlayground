package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Course c1;

    @BeforeEach
    void setUp() {
        Set<Integer> grades = new HashSet<>(Arrays.asList(9, 10));
        c1 = new Course("Algebra I", "Mathematics", 1, grades);
    }

    @Test
    void courseProperties() {
        assertEquals("Algebra I", c1.getCourseName(), "courseName should match");
        assertEquals("Mathematics", c1.getSubjectName(), "subjectName should match");
        assertEquals(1, c1.getPeriod(), "period should match");
    }

    @Test
    void allowedGradesManagement() {
        assertTrue(c1.isGradeAllowed(9), "grade 9 should be allowed");
        assertFalse(c1.isGradeAllowed(11), "grade 11 should not be allowed initially");

        assertTrue(c1.addAllowedGrade(11), "adding grade 11 should return true");
        assertTrue(c1.isGradeAllowed(11), "grade 11 should be allowed after adding");

        assertTrue(c1.removeAllowedGrade(10), "removing grade 10 should return true");
        assertFalse(c1.isGradeAllowed(10), "grade 10 should not be allowed after removal");
    }

    @Test
    void uniqueIds() {
        Course c2 = new Course("Geometry", "Mathematics", 2, new HashSet<>(Arrays.asList(9, 10)));
        assertNotEquals(c1.getId(), c2.getId(), "two courses should have unique ids");
    }
}
