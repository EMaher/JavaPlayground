/**
 * A simple Hello World application to demonstrate the Java workspace setup.
 * This file validates that Java compilation and execution work properly
 * in the GitHub Codespace.
 */
package Course;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, Java Playground!");
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("Java vendor: " + System.getProperty("java.vendor"));

        // Demonstrate some basic Java features
        demonstrateJavaFeatures();
    }

    private static void demonstrateJavaFeatures() {
        // String manipulation
        String message = "Welcome to the Java Playground!";
        System.out.println("Message length: " + message.length());

        // Array processing
        int[] numbers = { 1, 2, 3, 4, 5 };
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum of numbers 1-5: " + sum);

        // Object creation
        Person person = new Person("Developer", 25);
        System.out.println(person);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("Person{name='%s', age=%d}", name, age);
        }
    }
}
