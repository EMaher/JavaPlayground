package Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DogTest {

    private Dog dog;

    @BeforeEach
    void setUp() {
        dog = new Dog("Rex", "German Shepherd");
    }

    @Test
    void testConstructor() {
        Dog newDog = new Dog("Bella", "Labrador");
        assertNotNull(newDog);
        assertEquals("Bella", newDog.getName());
        assertEquals("Labrador", newDog.getBreed());
    }

    @Test
    void testInheritanceFromPet() {
        assertTrue(dog instanceof Pet);
    }

    @Test
    void testGetName() {
        assertEquals("Rex", dog.getName());
    }

    @Test
    void testSetName() {
        dog.setName("Max");
        assertEquals("Max", dog.getName());
    }

    @Test
    void testGetBreed() {
        assertEquals("German Shepherd", dog.getBreed());
    }

    @Test
    void testSetBreed() {
        dog.setBreed("Golden Retriever");
        assertEquals("Golden Retriever", dog.getBreed());
    }

    @Test
    void testSetBreedWithEmptyString() {
        dog.setBreed("");
        assertEquals("", dog.getBreed());
    }

    @Test
    void testSetBreedWithNull() {
        dog.setBreed(null);
        assertEquals(null, dog.getBreed());
    }

    @Test
    void testConstructorWithNullValues() {
        Dog nullDog = new Dog(null, null);
        assertEquals(null, nullDog.getName());
        assertEquals(null, nullDog.getBreed());
    }
}