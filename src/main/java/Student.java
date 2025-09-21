package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Simple Student model with a schedule represented as a list of Course objects.
 */
public class Student {
    private String firstName;
    private String lastName;
    private double currentGrade;
    private final List<Course> schedule;

    public Student() {
        this("", "", 0.0, new ArrayList<>());
    }

    public Student(String firstName, String lastName, double currentGrade) {
        this(firstName, lastName, currentGrade, new ArrayList<>());
    }

    public Student(String firstName, String lastName, double currentGrade, List<Course> schedule) {
        this.firstName = firstName == null ? "" : firstName;
        this.lastName = lastName == null ? "" : lastName;
        this.currentGrade = currentGrade;
        this.schedule = schedule == null ? new ArrayList<>() : new ArrayList<>(schedule);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName;
    }

    public double getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(double currentGrade) {
        this.currentGrade = currentGrade;
    }

    /**
     * Returns an unmodifiable view of the student's schedule.
     */
    public List<Course> getSchedule() {
        return Collections.unmodifiableList(schedule);
    }

    /**
     * Adds a Course to the student's schedule if it isn't already present.
     *
     * @param course the Course to add
     * @return true if the Course was added, false if it was already present
     * @throws IllegalArgumentException if course is null
     */
    public synchronized boolean addClassToSchedule(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("course cannot be null");
        }
        if (schedule.contains(course)) {
            return false;
        }
        return schedule.add(course);
    }

    /**
     * Removes a Course from the student's schedule.
     *
     * @param course the Course to remove
     * @return true if the Course was removed, false if it was not present
     */
    public synchronized boolean removeClassFromSchedule(Course course) {
        if (course == null) {
            return false;
        }
        return schedule.remove(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", currentGrade=" + currentGrade +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return Double.compare(student.currentGrade, currentGrade) == 0 &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(schedule, student.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, currentGrade, schedule);
    }
}
