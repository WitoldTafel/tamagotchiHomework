package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private Model model = new Model();

    @Test
    void increaseAge(){
        model.increaseAge(3);
        assertEquals(model.age,4);
    }

    @Test
    void increaseHealth() {
        model.increaseHealth(2);
        assertEquals(model.health,102);
    }

    @Test
    void decreaseHealth() {
        model.decreaseHealth(2);
        assertEquals(model.health,98);
    }
}