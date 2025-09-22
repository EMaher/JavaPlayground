package com.example;

import java.util.*;

/**
 * Manages the master schedule for a school, including courses, teachers, students,
 * and the mapping between them.
 */
public class MasterSchedule {
    private int totalPeriods;
    private final Map<Integer, String> periodTimes; // period number -> time description
    private final List<Teacher> teachers;
    private final List<Student> students;
    private final List<Course> courses;
    private final Map<Course, Teacher> courseTeacherMap;
    private final Map<Course, List<Student>> courseStudentsMap;

    public MasterSchedule(int totalPeriods) {
        this.totalPeriods = totalPeriods;
        this.periodTimes = new HashMap<>();
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.courseTeacherMap = new HashMap<>();
        this.courseStudentsMap = new HashMap<>();
    }

    public int getTotalPeriods() {
        return totalPeriods;
    }

    public void setTotalPeriods(int totalPeriods) {
        this.totalPeriods = totalPeriods;
    }

    /**
     * Sets the time description for a specific period.
     */
    public void setPeriodTime(int period, String timeDescription) {
        periodTimes.put(period, timeDescription);
    }

    /**
     * Gets the time description for a specific period.
     */
    public String getPeriodTime(int period) {
        return periodTimes.getOrDefault(period, "Period " + period);
    }

    /**
     * Adds a teacher to the master schedule.
     */
    public boolean addTeacher(Teacher teacher) {
        if (teacher == null || teachers.contains(teacher)) {
            return false;
        }
        return teachers.add(teacher);
    }

    /**
     * Adds a student to the master schedule.
     */
    public boolean addStudent(Student student) {
        if (student == null || students.contains(student)) {
            return false;
        }
        return students.add(student);
    }

    /**
     * Adds a course to the master schedule.
     */
    public boolean addCourse(Course course) {
        if (course == null || courses.contains(course)) {
            return false;
        }
        return courses.add(course);
    }

    /**
     * Maps a teacher to a course.
     */
    public Teacher addTeacherToCourse(Course course, Teacher teacher) {
        if (course == null || teacher == null) {
            throw new IllegalArgumentException("Course and teacher cannot be null");
        }
        if (!courses.contains(course)) {
            addCourse(course);
        }
        if (!teachers.contains(teacher)) {
            addTeacher(teacher);
        }
        return courseTeacherMap.put(course, teacher);
    }

    /**
     * Removes a teacher from a course.
     */
    public Teacher removeTeacherFromCourse(Course course) {
        if (course == null) {
            return null;
        }
        return courseTeacherMap.remove(course);
    }

    /**
     * Adds a student to a course if they are the correct grade.
     */
    public boolean addStudentToCourse(Course course, Student student) {
        if (course == null || student == null) {
            throw new IllegalArgumentException("Course and student cannot be null");
        }
        if (!course.isGradeAllowed((int) student.getCurrentGrade())) {
            return false; // Student's grade is not allowed for this course
        }
        if (!courses.contains(course)) {
            addCourse(course);
        }
        if (!students.contains(student)) {
            addStudent(student);
        }

        List<Student> courseStudents = courseStudentsMap.computeIfAbsent(course, k -> new ArrayList<>());
        if (courseStudents.contains(student)) {
            return false; // Student already in course
        }
        return courseStudents.add(student);
    }

    /**
     * Removes a student from a course.
     */
    public boolean removeStudentFromCourse(Course course, Student student) {
        if (course == null || student == null) {
            return false;
        }
        List<Student> courseStudents = courseStudentsMap.get(course);
        if (courseStudents == null) {
            return false;
        }
        return courseStudents.remove(student);
    }

    /**
     * Gets the schedule for a specific teacher.
     */
    public Map<Integer, Course> getSchedule(Teacher teacher) {
        if (teacher == null) {
            return Collections.emptyMap();
        }

        Map<Integer, Course> schedule = new HashMap<>();
        for (Map.Entry<Course, Teacher> entry : courseTeacherMap.entrySet()) {
            if (entry.getValue().equals(teacher)) {
                Course course = entry.getKey();
                schedule.put(course.getPeriod(), course);
            }
        }
        return schedule;
    }

    /**
     * Gets the schedule for a specific student.
     */
    public List<Course> getSchedule(Student student) {
        if (student == null) {
            return Collections.emptyList();
        }

        List<Course> schedule = new ArrayList<>();
        for (Map.Entry<Course, List<Student>> entry : courseStudentsMap.entrySet()) {
            if (entry.getValue().contains(student)) {
                schedule.add(entry.getKey());
            }
        }
        // Sort by period for consistent ordering
        schedule.sort(Comparator.comparing(Course::getPeriod));
        return schedule;
    }

    /**
     * Gets the teacher for a specific course.
     */
    public Teacher getTeacherForCourse(Course course) {
        return courseTeacherMap.get(course);
    }

    /**
     * Gets the students enrolled in a specific course.
     */
    public List<Student> getStudentsInCourse(Course course) {
        return courseStudentsMap.getOrDefault(course, Collections.emptyList());
    }

    /**
     * Gets all teachers.
     */
    public List<Teacher> getTeachers() {
        return Collections.unmodifiableList(teachers);
    }

    /**
     * Gets all students.
     */
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    /**
     * Gets all courses.
     */
    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}