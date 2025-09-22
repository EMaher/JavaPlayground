package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a teacher with their schedule of courses by period.
 */
public class Teacher {
    private String firstName;
    private String lastName;
    private String honorific;
    private final Map<Integer, Course> schedule;

    public Teacher() {
        this("", "", "", new HashMap<>());
    }

    public Teacher(String firstName, String lastName, String honorific) {
        this(firstName, lastName, honorific, new HashMap<>());
    }

    public Teacher(String firstName, String lastName, String honorific, Map<Integer, Course> schedule) {
        this.firstName = firstName == null ? "" : firstName;
        this.lastName = lastName == null ? "" : lastName;
        this.honorific = honorific == null ? "" : honorific;
        this.schedule = schedule == null ? new HashMap<>() : new HashMap<>(schedule);
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

    public String getHonorific() {
        return honorific;
    }

    public void setHonorific(String honorific) {
        this.honorific = honorific == null ? "" : honorific;
    }

    /**
     * Returns an unmodifiable view of the teacher's schedule.
     */
    public Map<Integer, Course> getSchedule() {
        return Map.copyOf(schedule);
    }

    /**
     * Adds a course to the teacher's schedule for a specific period.
     *
     * @param period the period number
     * @param course the course to teach during that period
     * @return the previous course taught during that period, or null if none
     * @throws IllegalArgumentException if course is null
     */
    public Course addCourseToSchedule(int period, Course course) {
        if (course == null) {
            throw new IllegalArgumentException("course cannot be null");
        }
        return schedule.put(period, course);
    }

    /**
     * Removes a course from the teacher's schedule for a specific period.
     *
     * @param period the period number
     * @return the course that was removed, or null if no course was scheduled for that period
     */
    public Course removeCourseFromSchedule(int period) {
        return schedule.remove(period);
    }

    /**
     * Says hello to the class for a specific period.
     *
     * @param period the period number
     * @return the greeting message, or an appropriate message if no course is scheduled
     */
    public String sayHelloToClass(int period) {
        Course course = schedule.get(period);
        if (course == null) {
            return "Hello class! I don't have a course scheduled for period " + period + ".";
        }
        return "Hello " + course.getCourseName() + " class!";
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", honorific='" + honorific + '\'' +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(firstName, teacher.firstName) &&
                Objects.equals(lastName, teacher.lastName) &&
                Objects.equals(honorific, teacher.honorific) &&
                Objects.equals(schedule, teacher.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, honorific, schedule);
    }
}