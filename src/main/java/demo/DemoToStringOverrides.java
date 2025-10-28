package demo;

import Course.Student;
import Course.Teacher;
import Course.Person;

/**
 * Demo class to showcase toString() method overrides in the Person hierarchy.
 * 
 * To run:
 *  mvn clean compile
 *  java -cp target/classes demo.DemoToStringOverrides
 */
public class DemoToStringOverrides {
    
    public static void main(String[] args) {
        System.out.println("=== Demo: toString() Method Overrides ===\n");
        
        // Create a Student instance
        Student student = new Student("Alice", "Johnson", 95.5);
        System.out.println("Student toString():");
        System.out.println(student.toString());
        System.out.println("Student implicit toString() (via println):");
        System.out.println(student);
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // Create a Teacher instance
        Teacher teacher = new Teacher("Robert", "Smith", "Dr.");
        System.out.println("Teacher toString():");
        System.out.println(teacher.toString());
        System.out.println("Teacher implicit toString() (via println):");
        System.out.println(teacher);
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // Demonstrate polymorphism - treating objects as Person references
        System.out.println("Polymorphic toString() calls:");
        
        // Note: Person is abstract, so we can't instantiate it directly
        // But we can use Person references to point to subclass instances
        Student student2 = new Student("Bob", "Wilson", 87.3);
        Teacher teacher2 = new Teacher("Maria", "Garcia", "Prof.");
        
        // Array of Person references pointing to different subclass instances
        Object[] people = {student2, teacher2};
        
        for (int i = 0; i < people.length; i++) {
            System.out.println("Person " + (i + 1) + ": " + people[i]);
        }
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // Demonstrate additional methods
        System.out.println("Additional Person methods:");
        System.out.println("Student full name: " + student.getFullName());
        System.out.println("Teacher full name: " + teacher.getFullName());
        System.out.println("Teacher full name with title: " + teacher.getFullNameWithTitle());


        //Compile Error:
        Person personVar = teacher2;

        //Show that toString works via Person reference
        System.out.println("Person reference to Teacher: " + personVar);

        //Show that can't access subclass-specific methods
        //System.out.println("Honorific via Person reference: " + personVar.getHonorific());

        //Show casting to be able to call subclass-specific methods
        if (personVar instanceof Teacher) {
            System.out.println("Honorific via casted Person reference: " + ((Teacher) personVar).getHonorific());
        }
    }
}