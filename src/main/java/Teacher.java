package com.example;

import java.util.Objects;

/**
 * Represents a teacher with their basic information.
 */
public class Teacher {
    private String firstName;
    private String lastName;
    private String honorific;

    public Teacher() {
        this("", "", "");
    }

    public Teacher(String firstName, String lastName, String honorific) {
        this.firstName = firstName == null ? "" : firstName;
        this.lastName = lastName == null ? "" : lastName;
        this.honorific = honorific == null ? "" : honorific;
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
     * Returns the teacher's full name with title.
     *
     * @return honorific + first name + last name
     */
    public String getFullNameWithTitle() {
        return honorific + " " + firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", honorific='" + honorific + '\'' +
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
                Objects.equals(honorific, teacher.honorific);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, honorific);
    }
}