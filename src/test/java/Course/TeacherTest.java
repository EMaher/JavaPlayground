package Course;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    private Teacher teacher;

    @BeforeEach
    void setUp() {
        teacher = new Teacher("Jane", "Smith", "Ms.");
    }

    @Test
    void teacherProperties() {
        assertEquals("Jane", teacher.getFirstName(), "firstName should match");
        assertEquals("Smith", teacher.getLastName(), "lastName should match");
        assertEquals("Ms.", teacher.getHonorific(), "honorific should match");
    }

    @Test
    void fullNameWithTitle() {
        assertEquals("Ms. Jane Smith", teacher.getFullNameWithTitle(), "full name with title should match");

        // Test with different values
        Teacher teacher2 = new Teacher("John", "Doe", "Dr.");
        assertEquals("Dr. John Doe", teacher2.getFullNameWithTitle(), "full name with title should match");
    }

    @Test
    void teacherSetters() {
        teacher.setFirstName("Joan");
        teacher.setLastName("Johnson");
        teacher.setHonorific("Dr.");

        assertEquals("Joan", teacher.getFirstName(), "firstName should be updated");
        assertEquals("Johnson", teacher.getLastName(), "lastName should be updated");
        assertEquals("Dr.", teacher.getHonorific(), "honorific should be updated");
        assertEquals("Dr. Joan Johnson", teacher.getFullNameWithTitle(), "full name should be updated");
    }

    @Test
    void nullHandling() {
        // Test null constructor parameters
        Teacher nullTeacher = new Teacher(null, null, null);
        assertEquals("", nullTeacher.getFirstName());
        assertEquals("", nullTeacher.getLastName());
        assertEquals("", nullTeacher.getHonorific());
        assertEquals("  ", nullTeacher.getFullNameWithTitle()); // Should be "honorific + space + firstName + space + lastName"
    }

    @Test
    void constructors() {
        // Default constructor
        Teacher defaultTeacher = new Teacher();
        assertEquals("", defaultTeacher.getFirstName());
        assertEquals("", defaultTeacher.getLastName());
        assertEquals("", defaultTeacher.getHonorific());

        // Three-parameter constructor
        Teacher threeParamTeacher = new Teacher("John", "Doe", "Mr.");
        assertEquals("John", threeParamTeacher.getFirstName());
        assertEquals("Doe", threeParamTeacher.getLastName());
        assertEquals("Mr.", threeParamTeacher.getHonorific());
    }
}