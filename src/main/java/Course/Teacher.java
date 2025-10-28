package Course;

import java.util.Objects;

/**
 * Represents a teacher with their basic information.
 */
public class Teacher extends Person {
    private String honorific;

    public Teacher() {
        this("", "", "");
    }

    public Teacher(String firstName, String lastName, String honorific) {
        super(firstName, lastName);
        this.honorific = honorific == null ? "" : honorific;
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
        return honorific + " " + getFirstName() + " " + getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Teacher teacher = (Teacher) o;
        return Objects.equals(honorific, teacher.honorific);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), honorific);
    }
}