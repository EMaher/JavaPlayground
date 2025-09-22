package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student s;
    private Course algebra;
    private Course history;

    @BeforeEach
    void setUp() {
        s = new Student("John", "Doe", 10.0);

        Set<Integer> grades = new HashSet<>();
        grades.add(10);
        algebra = new Course("Algebra I", "Math", "Ms. Lee", grades);

        history = new Course("World History", "Social Studies", "Mr. Brown", new HashSet<>(List.of(9)));
    }

    @Test
    void addAndRemoveCourses() {
        assertTrue(s.addClassToSchedule(algebra), "should be able to add algebra");

        assertFalse(s.addClassToSchedule(algebra), "should not add duplicate course");

        List<Course> schedule = s.getSchedule();
        assertEquals(1, schedule.size(), "schedule size should be 1 after adding one course");
        assertEquals(algebra, schedule.get(0), "course in schedule should be algebra");

        assertFalse(s.removeClassFromSchedule(history), "removing a course not present should return false");

        assertTrue(s.removeClassFromSchedule(algebra), "removing an existing course should return true");

        assertEquals(0, s.getSchedule().size(), "schedule should be empty after removal");
    }

    @Test
    void helloTeacher() {
        // Test with no courses scheduled
        String greeting = s.helloTeacher(1);
        assertEquals("Hello! I don't have a class during period 1.", greeting);

        // Add a course and test greeting
        s.addClassToSchedule(algebra);
        greeting = s.helloTeacher(1);
        assertEquals("Hello Ms. Lee!", greeting);

        // Add another course and test second period
        s.addClassToSchedule(history);
        greeting = s.helloTeacher(2);
        assertEquals("Hello Mr. Brown!", greeting);

        // Test period out of range
        greeting = s.helloTeacher(5);
        assertEquals("Hello! I don't have a class during period 5.", greeting);

        // Test period 0 (invalid)
        greeting = s.helloTeacher(0);
        assertEquals("Hello! I don't have a class during period 0.", greeting);
    }
}
