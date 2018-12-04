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
        System.out.println(model.health);

        model.decreaseHealth(102);
        System.out.println(model.health);
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
        model.startHunger();
        assertTrue(model.hungry);
    }

    @Test
    void eat() {
        model.eat();
        assertFalse(model.hungry);
    }

    @Test
    void getSleepy() {
        model.startSleepiness();
        assertTrue(model.sleepy);
    }

    @Test
    void sleep() {
        model.sleep();
        assertFalse(model.sleepy);
    }
    @Test
    void die() {
        model.die();
        assertTrue(model.dead);
    }




}