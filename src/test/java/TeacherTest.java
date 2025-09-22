package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    private Teacher teacher;
    private Course algebra;
    private Course history;

    @BeforeEach
    void setUp() {
        teacher = new Teacher("Jane", "Smith", "Ms.");

        Set<Integer> grades = new HashSet<>();
        grades.add(10);
        algebra = new Course("Algebra I", "Math", "Ms. Smith", grades);

        history = new Course("World History", "Social Studies", "Ms. Smith", new HashSet<>(Set.of(9, 10)));
    }

    @Test
    void teacherProperties() {
        assertEquals("Jane", teacher.getFirstName(), "firstName should match");
        assertEquals("Smith", teacher.getLastName(), "lastName should match");
        assertEquals("Ms.", teacher.getHonorific(), "honorific should match");
        assertTrue(teacher.getSchedule().isEmpty(), "schedule should be empty initially");
    }

    @Test
    void scheduleManagement() {
        // Add courses to schedule
        assertNull(teacher.addCourseToSchedule(1, algebra), "should return null when adding to empty period");
        assertEquals(algebra, teacher.addCourseToSchedule(1, history), "should return previous course when replacing");

        // Check schedule
        Map<Integer, Course> schedule = teacher.getSchedule();
        assertEquals(1, schedule.size(), "schedule should have one entry");
        assertEquals(history, schedule.get(1), "period 1 should have history course");

        // Remove course
        assertEquals(history, teacher.removeCourseFromSchedule(1), "should return removed course");
        assertNull(teacher.removeCourseFromSchedule(1), "should return null when removing from empty period");
        assertTrue(teacher.getSchedule().isEmpty(), "schedule should be empty after removal");
    }

    @Test
    void sayHelloToClass() {
        // Test with no course scheduled
        String greeting = teacher.sayHelloToClass(1);
        assertEquals("Hello class! I don't have a course scheduled for period 1.", greeting);

        // Test with course scheduled
        teacher.addCourseToSchedule(1, algebra);
        greeting = teacher.sayHelloToClass(1);
        assertEquals("Hello Algebra I class!", greeting);

        // Test different period
        teacher.addCourseToSchedule(2, history);
        greeting = teacher.sayHelloToClass(2);
        assertEquals("Hello World History class!", greeting);
    }

    @Test
    void nullHandling() {
        // Test null course
        assertThrows(IllegalArgumentException.class, () -> teacher.addCourseToSchedule(1, null));

        // Test null constructor parameters
        Teacher nullTeacher = new Teacher(null, null, null, null);
        assertEquals("", nullTeacher.getFirstName());
        assertEquals("", nullTeacher.getLastName());
        assertEquals("", nullTeacher.getHonorific());
        assertTrue(nullTeacher.getSchedule().isEmpty());
    }

    @Test
    void constructors() {
        // Default constructor
        Teacher defaultTeacher = new Teacher();
        assertEquals("", defaultTeacher.getFirstName());
        assertEquals("", defaultTeacher.getLastName());
        assertEquals("", defaultTeacher.getHonorific());
        assertTrue(defaultTeacher.getSchedule().isEmpty());

        // Three-parameter constructor
        Teacher threeParamTeacher = new Teacher("John", "Doe", "Mr.");
        assertEquals("John", threeParamTeacher.getFirstName());
        assertEquals("Doe", threeParamTeacher.getLastName());
        assertEquals("Mr.", threeParamTeacher.getHonorific());
        assertTrue(threeParamTeacher.getSchedule().isEmpty());

        // Full constructor with schedule
        Map<Integer, Course> initialSchedule = new HashMap<>();
        initialSchedule.put(1, algebra);
        Teacher fullTeacher = new Teacher("Bob", "Johnson", "Dr.", initialSchedule);
        assertEquals("Bob", fullTeacher.getFirstName());
        assertEquals("Johnson", fullTeacher.getLastName());
        assertEquals("Dr.", fullTeacher.getHonorific());
        assertEquals(1, fullTeacher.getSchedule().size());
        assertEquals(algebra, fullTeacher.getSchedule().get(1));
    }
}