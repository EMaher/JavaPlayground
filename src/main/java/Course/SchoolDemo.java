package Course;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple demonstration of the MasterSchedule system with Teacher and Student classes.
 */
public class SchoolDemo {

    public static void main(String[] args) {
        System.out.println("=== School Demo with MasterSchedule ===\n");

        // Create a master schedule for 6 periods
        MasterSchedule masterSchedule = new MasterSchedule(6);
        masterSchedule.setPeriodTime(1, "8:00-8:50 AM");
        masterSchedule.setPeriodTime(2, "9:00-9:50 AM");
        masterSchedule.setPeriodTime(3, "10:00-10:50 AM");

        // Create a teacher
        Teacher teacher = new Teacher("Jane", "Smith", "Ms.");
        System.out.println("Created teacher: " + teacher.getFullNameWithTitle());

        // Create some courses with period numbers
        Set<Integer> grades = new HashSet<>();
        grades.add(10);
        Course algebra = new Course("Algebra I", "Math", 1, grades);
        Course history = new Course("World History", "Social Studies", 3, new HashSet<>(Set.of(9, 10)));

        // Add teacher and courses to master schedule
        masterSchedule.addTeacher(teacher);
        masterSchedule.addCourse(algebra);
        masterSchedule.addCourse(history);

        // Assign teacher to courses
        masterSchedule.addTeacherToCourse(algebra, teacher);
        masterSchedule.addTeacherToCourse(history, teacher);

        System.out.println("Teacher's schedule: " + masterSchedule.getSchedule(teacher));

        // Create a student
        Student student = new Student("John", "Doe", 10.0);
        masterSchedule.addStudent(student);

        // Add student to courses
        masterSchedule.addStudentToCourse(algebra, student);
        masterSchedule.addStudentToCourse(history, student);

        System.out.println("\nCreated student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student's schedule: " + masterSchedule.getSchedule(student));

        // Show course information
        System.out.println("\nCourse Information:");
        for (Course course : masterSchedule.getCourses()) {
            Teacher courseTeacher = masterSchedule.getTeacherForCourse(course);
            System.out.println(course.getCourseName() + " (Period " + course.getPeriod() +
                    ") taught by " + (courseTeacher != null ? courseTeacher.getFullNameWithTitle() : "No teacher assigned"));
        }
    }
}