package com.codecool.witoldtafel.tamagotchi2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private Model model = new Model();

    @Test
    void increaseAge(){
        model.increaseAge(3);
        assertEquals(model.getAge(),3);
    }

    @Test
    void increaseHealth() {
        model.increaseHealth(2);
        assertEquals(model.getHealth(),100);
    }

    @Test
    void decreaseHealth() {
        System.out.println(model.getHealth());

        model.decreaseHealth(102);
        System.out.println(model.getHealth());
        assertEquals(model.getHealth(),0);
    }

    @Test
    void increaseEnergy() {
        model.increaseEnergy(2);
        assertEquals(model.getEnergy(),10);
    }

    @Test
    void decreaseEnergy() {
        model.decreaseEnergy(2);
        assertEquals(model.getEnergy(),8);
    }

    @Test
    void increaseHappiness() {
        model.increaseHappiness(12);
        assertEquals(model.getHappiness(),10);
    }

    @Test
    void decreaseHappiness() {
        model.decreaseHappiness(12);
        assertEquals(model.getHappiness(),-10);
    }

    @Test
    void getHungry() {
        model.startHunger();
        assertTrue(model.isHungry());
    }

    @Test
    void eat() {
        model.eat();
        assertFalse(model.isHungry());
    }

    @Test
    void getSleepy() {
        model.startSleepiness();
        assertTrue(model.isSleepy());
    }

    @Test
    void sleep() {
        model.sleep();
        assertFalse(model.isSleepy());
    }
    @Test
    void die() {
        model.die();
        assertTrue(model.isDead());
    }




}