package Course;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a course offered to students.
 * id is generated when the Course is created and used for identity.
 */
public class Course {
    private final String id;
    private String courseName;
    private String subjectName;
    private int period;
    private final Set<Integer> allowedGrades;

    public Course(String courseName, String subjectName, int period, Set<Integer> allowedGrades) {
        this.id = UUID.randomUUID().toString();
        this.courseName = courseName == null ? "" : courseName;
        this.subjectName = subjectName == null ? "" : subjectName;
        this.period = period;
        this.allowedGrades = allowedGrades == null ? new HashSet<>() : new HashSet<>(allowedGrades);
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? "" : courseName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? "" : subjectName;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    /**
     * Returns an unmodifiable view of which grade levels are allowed to take this
     * course.
     */
    public Set<Integer> getAllowedGrades() {
        return Collections.unmodifiableSet(allowedGrades);
    }

    public boolean isGradeAllowed(int grade) {
        return allowedGrades.contains(grade);
    }

    public boolean addAllowedGrade(int grade) {
        return allowedGrades.add(grade);
    }

    public boolean removeAllowedGrade(int grade) {
        return allowedGrades.remove(grade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", period=" + period +
                ", allowedGrades=" + allowedGrades +
                '}';
    }
}
