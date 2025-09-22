package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple demonstration of the Teacher and Student classes interaction.
 */
public class SchoolDemo {

    public static void main(String[] args) {
        System.out.println("=== School Demo ===\n");

        // Create a teacher
        Teacher teacher = new Teacher("Jane", "Smith", "Ms.");
        System.out.println("Created teacher: " + teacher.getHonorific() + " " + teacher.getFirstName() + " " + teacher.getLastName());

        // Create some courses
        Set<Integer> grades = new HashSet<>();
        grades.add(10);
        Course algebra = new Course("Algebra I", "Math", "Ms. Smith", grades);
        Course history = new Course("World History", "Social Studies", "Ms. Smith", new HashSet<>(Set.of(9, 10)));

        // Set up teacher's schedule
        teacher.addCourseToSchedule(1, algebra);
        teacher.addCourseToSchedule(3, history);
        System.out.println("Teacher's schedule: " + teacher.getSchedule());

        // Teacher greets classes
        System.out.println("\nTeacher greetings:");
        System.out.println("Period 1: " + teacher.sayHelloToClass(1));
        System.out.println("Period 2: " + teacher.sayHelloToClass(2));
        System.out.println("Period 3: " + teacher.sayHelloToClass(3));

        // Create a student
        Student student = new Student("John", "Doe", 10.0);
        student.addClassToSchedule(algebra);
        student.addClassToSchedule(history);
        System.out.println("\nCreated student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student's schedule: " + student.getSchedule());

        // Student greets teachers
        System.out.println("\nStudent greetings:");
        System.out.println("Period 1: " + student.helloTeacher(1));
        System.out.println("Period 2: " + student.helloTeacher(2));
        System.out.println("Period 3: " + student.helloTeacher(3));
    }
}