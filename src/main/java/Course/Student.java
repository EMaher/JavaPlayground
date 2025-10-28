package Course;

import java.util.Objects;

/**
 * Simple Student model.
 */
public class Student extends Person {
    private double currentGrade;

    public Student() {
        this("", "", 0.0);
    }

    public Student(String firstName, String lastName, double currentGrade) {
        super(firstName, lastName);
        this.currentGrade = currentGrade;
    }

    public double getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(double currentGrade) {
        this.currentGrade = currentGrade;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Grade " + currentGrade +
                '}';
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
        Student student = (Student) o;
        return Double.compare(student.currentGrade, currentGrade) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentGrade);
    }
}
