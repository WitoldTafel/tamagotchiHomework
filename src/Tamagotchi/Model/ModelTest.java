package Tamagotchi.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private Model model = new Model();

    @Test
    void increaseAge(){
        model.increaseAge(3);
        assertEquals(model.age,3);
    }

    @Test
    void increaseHealth() {
        model.increaseHealth(2);
        assertEquals(model.health,100);
    }

    @Test
    void decreaseHealth() {
        model.decreaseHealth(102);
        assertEquals(model.health,0);
    }

    @Test
    void increaseEnergy() {
        model.increaseEnergy(2);
        assertEquals(model.energy,10);
    }

    @Test
    void decreaseEnergy() {
        model.decreaseEnergy(2);
        assertEquals(model.energy,8);
    }

    @Test
    void increaseHappiness() {
        model.increaseHappiness(12);
        assertEquals(model.happiness,10);
    }

    @Test
    void decreaseHappiness() {
        model.decreaseHappiness(12);
        assertEquals(model.happiness,-10);
    }

    @Test
    void getHungry() {
        model.getHungry();
        assertEquals(model.hungry, true);
    }

    @Test
    void eat() {
        model.eat();
        assertEquals(model.hungry, false);
    }

    @Test
    void getSleepy() {
        model.getSleepy();
        assertEquals(model.sleepy, true);
    }

    @Test
    void sleep() {
        model.sleep();
        assertEquals(model.sleepy, false);
    }
    @Test
    void die() {
        model.die();
        assertEquals(model.dead, true);
    }




}