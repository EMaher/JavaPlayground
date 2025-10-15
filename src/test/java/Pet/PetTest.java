package Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PetTest {

    private Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet("Buddy");
    }

    @Test
    void testConstructor() {
        Pet newPet = new Pet("Max");
        assertNotNull(newPet);
        assertEquals("Max", newPet.getName());
    }

    @Test
    void testGetName() {
        assertEquals("Buddy", pet.getName());
    }

    @Test
    void testSetName() {
        pet.setName("Charlie");
        assertEquals("Charlie", pet.getName());
    }

    @Test
    void testSetNameWithEmptyString() {
        pet.setName("");
        assertEquals("", pet.getName());
    }

    @Test
    void testSetNameWithNull() {
        pet.setName(null);
        assertEquals(null, pet.getName());
    }
}