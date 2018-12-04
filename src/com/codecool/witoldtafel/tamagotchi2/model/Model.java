package com.codecool.witoldtafel.tamagotchi2.model;

import java.util.Random;

public class Model {

    int age = 0;
    double health = 100;
    double energy = 10;
    double happiness = 0;
    private int numberOfDrugs = 5;
    private int nuberOfBeers = 5;

    int lastMealTime;
    int lastWakeUpTime;


    boolean hungry;
    boolean dead;
    boolean sleepy;
    boolean sick;
    boolean asleep;

    public void increaseAge(int i) {
        this.age += i;
    }

    void increaseHealth(int i) {
        if (health + i <= 100) {  //not tdd
            health += i;
        } else {
            health = 100;
        }
    }

    public void decreaseHealth(int i) {
        if (health - i >= 0) {
            health -= i;
        } else {
            health = 0;
            die();
        }
    }

    void increaseEnergy(int i) {
        if (energy + i <= 10) {
            energy += i;
        } else {
            energy = 10;
        }
    }

    public void decreaseEnergy(int i) {
        if (energy - i >= 0) {  //not tdd
            energy -= i;
        } else {
            energy = 0;
        }
    }

    void increaseHappiness(int i) {
        if (happiness + i <= 10) {
            happiness += i;
        } else {
            happiness = 10;
        }
    }

    public void decreaseHappiness(int i) {
        if (happiness - i >= -10) {  //not tdd
            happiness -= i;
        } else {
            happiness = -10;
        }
    }

    public void startHunger() {
        hungry = true;
    }

    public void startSleepiness() {
        sleepy = true;
    }

    void die() {
        dead = true;
    }

    public void startSickness() {
        double chanceOfSickness = 10 + age / 60 - happiness / 2 - energy / 4;

        if (chanceOfSickness > new Random().nextInt(100)) {
            sick = true;
        }
    }

    //////////// USER ACTIONS //////////////////////////

    public String eat() {
        if (hungry) {
            hungry = false;
            lastMealTime = age;
            return "Mniam mniam";
        } else {
            return "I'm not hungry!";
        }
    }

    public String sleep() {
        if (sleepy) {
            sleepy = false;
            increaseEnergy(5);
            lastWakeUpTime = age;
            return "Goodnight!";
        } else {
            return "I'm not sleepy!";
        }
    }

    public String drinkBeer() {
        if (nuberOfBeers > 0) {
            increaseHappiness(3);
            nuberOfBeers--;
            return "Psssst";
        }else{
            return "Beer is gone!!!!!!!";
        }
    }

    public String takeDrugs() {
        if (numberOfDrugs > 0) {
            numberOfDrugs--;
            increaseEnergy(5);
            sick = false;
            return "Feels goooooood";
        }else{
            return "Got anymore of them pills?";
        }
    }

    public String sing() {
        if (energy >= 3) {
            decreaseEnergy(3);
            increaseHappiness(2);
            return "LaLAlalalaLA lalal LA la LA la";
        }else{
            return "To tired to sing :(";
        }
    }

    //////////// GETTERS //////////////////////////


    public double getHealth() {
        return health;
    }

    public double getEnergy() {
        return energy;
    }

    public double getHappiness() {
        return happiness;
    }

    public int getAge() {
        return age;
    }

    public int getNuberOfBeers() {
        return nuberOfBeers;
    }

    public int getNumberOfDrugs() {
        return numberOfDrugs;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isHungry() {
        return hungry;
    }

    public boolean isSick() {
        return sick;
    }

    public boolean isSleepy() {
        return sleepy;
    }

    public boolean isAsleep() {
        return asleep;
    }

    public int getLastMealTime() { return lastMealTime; }

    public int getLastWakeUpTime() { return lastWakeUpTime; }
}
