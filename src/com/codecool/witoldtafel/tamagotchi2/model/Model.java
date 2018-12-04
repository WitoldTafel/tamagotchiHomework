package com.codecool.witoldtafel.tamagotchi2.model;

import java.util.Random;

public class Model {

    private final int initialAge = 0;
    private final int initialHealth = 100;
    private final int initialEnergy = 10;
    private final int initialNubreOfDrugs = 5;
    private final int initialNumberOfBeers = 5;
    private final int maxHappiness = 10;


    private int age = initialAge;
    private double health = initialHealth;
    private double energy = initialEnergy;
    private double happiness = 0;
    private int numberOfDrugs = initialNubreOfDrugs;
    private int nuberOfBeers = initialNumberOfBeers;

    private int lastMealTime;
    private int lastWakeUpTime;

    private boolean hungry;
    private boolean dead;
    private boolean sleepy;
    private boolean sick;
    private boolean asleep;

    private double chanceOfSickness = 10 + age / 60 - happiness / 2 - energy / 4;


    public void increaseAge(int i) {

        this.age += i;
    }

    void increaseHealth(int i) {
        if (health + i <= initialHealth) {  //not tdd
            health += i;
        } else {
            health = initialHealth;
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
        if (energy + i <= initialEnergy) {
            energy += i;
        } else {
            energy = initialEnergy;
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
        if (happiness + i <= maxHappiness) {
            happiness += i;
        } else {
            happiness = maxHappiness;
        }
    }

    public void decreaseHappiness(int i) {
        if (happiness - i >= -maxHappiness) {  //not tdd
            happiness -= i;
        } else {
            happiness = -maxHappiness;
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
        } else {
            return "Beer is gone!!!!!!!";
        }
    }

    public String takeDrugs() {
        if (numberOfDrugs > 0) {
            numberOfDrugs--;
            increaseEnergy(5);
            sick = false;
            return "Feels goooooood";
        } else {
            return "Got anymore of them pills?";
        }
    }

    public String sing() {
        if (energy >= 3) {
            decreaseEnergy(3);
            increaseHappiness(2);
            return "LaLAlalalaLA lalal LA la LA la";
        } else {
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

    public int getLastMealTime() {
        return lastMealTime;
    }

    public int getLastWakeUpTime() {
        return lastWakeUpTime;
    }


    public int getInitialHealth() {
        return initialHealth;
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }

    public int getMaxHappiness() {
        return maxHappiness;
    }
}
