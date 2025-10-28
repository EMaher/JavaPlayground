package Course;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MasterScheduleTest {

    private MasterSchedule masterSchedule;
    private Teacher teacher1;
    private Teacher teacher2;
    private Student student1;
    private Student student2;
    private Course algebra;
    private Course history;

    @BeforeEach
    void setUp() {
        masterSchedule = new MasterSchedule(6);

        teacher1 = new Teacher("Jane", "Smith", "Ms.");
        teacher2 = new Teacher("John", "Doe", "Mr.");

        student1 = new Student("Alice", "Johnson", 10.0);
        student2 = new Student("Bob", "Wilson", 9.0);

        Set<Integer> grades10 = new HashSet<>();
        grades10.add(10);
        algebra = new Course("Algebra I", "Math", 1, grades10);

        Set<Integer> grades9and10 = new HashSet<>();
        grades9and10.add(9);
        grades9and10.add(10);
        history = new Course("World History", "Social Studies", 3, grades9and10);
    }

    @Test
    void masterScheduleBasics() {
        assertEquals(6, masterSchedule.getTotalPeriods(), "should have 6 periods");

        // Test period time setting
        masterSchedule.setPeriodTime(1, "8:00-8:50 AM");
        assertEquals("8:00-8:50 AM", masterSchedule.getPeriodTime(1));
        assertEquals("Period 2", masterSchedule.getPeriodTime(2)); // Default format
    }

    @Test
    void teacherManagement() {
        assertTrue(masterSchedule.addTeacher(teacher1), "should add teacher1");
        assertFalse(masterSchedule.addTeacher(teacher1), "should not add duplicate teacher");
        assertFalse(masterSchedule.addTeacher(null), "should not add null teacher");

        assertTrue(masterSchedule.addTeacher(teacher2), "should add teacher2");

        List<Teacher> teachers = masterSchedule.getTeachers();
        assertEquals(2, teachers.size(), "should have 2 teachers");
        assertTrue(teachers.contains(teacher1), "should contain teacher1");
        assertTrue(teachers.contains(teacher2), "should contain teacher2");
    }

    @Test
    void studentManagement() {
        assertTrue(masterSchedule.addStudent(student1), "should add student1");
        assertFalse(masterSchedule.addStudent(student1), "should not add duplicate student");
        assertFalse(masterSchedule.addStudent(null), "should not add null student");

        assertTrue(masterSchedule.addStudent(student2), "should add student2");

        List<Student> students = masterSchedule.getStudents();
        assertEquals(2, students.size(), "should have 2 students");
        assertTrue(students.contains(student1), "should contain student1");
        assertTrue(students.contains(student2), "should contain student2");
    }

    @Test
    void courseManagement() {
        assertTrue(masterSchedule.addCourse(algebra), "should add algebra");
        assertFalse(masterSchedule.addCourse(algebra), "should not add duplicate course");
        assertFalse(masterSchedule.addCourse(null), "should not add null course");

        assertTrue(masterSchedule.addCourse(history), "should add history");

        List<Course> courses = masterSchedule.getCourses();
        assertEquals(2, courses.size(), "should have 2 courses");
        assertTrue(courses.contains(algebra), "should contain algebra");
        assertTrue(courses.contains(history), "should contain history");
    }

    @Test
    void teacherCourseMapping() {
        // Test adding teacher to course
        assertNull(masterSchedule.addTeacherToCourse(algebra, teacher1), "should return null for new assignment");
        assertEquals(teacher1, masterSchedule.getTeacherForCourse(algebra), "teacher1 should be assigned to algebra");

        // Test replacing teacher
        assertEquals(teacher1, masterSchedule.addTeacherToCourse(algebra, teacher2), "should return previous teacher");
        assertEquals(teacher2, masterSchedule.getTeacherForCourse(algebra), "teacher2 should now be assigned to algebra");

        // Test removing teacher
        assertEquals(teacher2, masterSchedule.removeTeacherFromCourse(algebra), "should return removed teacher");
        assertNull(masterSchedule.getTeacherForCourse(algebra), "no teacher should be assigned to algebra");

        // Test null handling
        assertThrows(IllegalArgumentException.class, () -> masterSchedule.addTeacherToCourse(null, teacher1));
        assertThrows(IllegalArgumentException.class, () -> masterSchedule.addTeacherToCourse(algebra, null));
    }

    @Test
    void studentCourseMapping() {
        // Test adding student to course with correct grade
        assertTrue(masterSchedule.addStudentToCourse(algebra, student1), "student1 (grade 10) should be added to algebra");
        assertFalse(masterSchedule.addStudentToCourse(algebra, student1), "student1 should not be added again");

        // Test adding student to course with wrong grade
        Student wrongGradeStudent = new Student("Charlie", "Brown", 11.0);
        assertFalse(masterSchedule.addStudentToCourse(algebra, wrongGradeStudent), "student with grade 11 should not be added to algebra (grade 10 only)");

        // Test adding student with correct grade range
        assertTrue(masterSchedule.addStudentToCourse(history, student2), "student2 (grade 9) should be added to history");

        // Test getting students in course
        List<Student> algebraStudents = masterSchedule.getStudentsInCourse(algebra);
        assertEquals(1, algebraStudents.size(), "algebra should have 1 student");
        assertTrue(algebraStudents.contains(student1), "algebra should contain student1");

        // Test removing student
        assertTrue(masterSchedule.removeStudentFromCourse(algebra, student1), "should remove student1 from algebra");
        assertFalse(masterSchedule.removeStudentFromCourse(algebra, student1), "should return false when removing non-existent student");

        // Test null handling
        assertThrows(IllegalArgumentException.class, () -> masterSchedule.addStudentToCourse(null, student1));
        assertThrows(IllegalArgumentException.class, () -> masterSchedule.addStudentToCourse(algebra, null));
    }

    @Test
    void scheduleGeneration() {
        // Set up courses and assignments
        masterSchedule.addTeacherToCourse(algebra, teacher1);
        masterSchedule.addTeacherToCourse(history, teacher1);
        masterSchedule.addStudentToCourse(algebra, student1);
        masterSchedule.addStudentToCourse(history, student1);

        // Test teacher schedule
        Map<Integer, Course> teacherSchedule = masterSchedule.getSchedule(teacher1);
        assertEquals(2, teacherSchedule.size(), "teacher should have 2 courses");
        assertEquals(algebra, teacherSchedule.get(1), "teacher should have algebra in period 1");
        assertEquals(history, teacherSchedule.get(3), "teacher should have history in period 3");

        // Test student schedule
        List<Course> studentSchedule = masterSchedule.getSchedule(student1);
        assertEquals(2, studentSchedule.size(), "student should have 2 courses");
        assertTrue(studentSchedule.contains(algebra), "student should have algebra");
        assertTrue(studentSchedule.contains(history), "student should have history");

        // Test null handling
        assertTrue(masterSchedule.getSchedule((Teacher) null).isEmpty(), "null teacher should return empty schedule");
        assertTrue(masterSchedule.getSchedule((Student) null).isEmpty(), "null student should return empty schedule");
    }
}