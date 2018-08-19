package Tamagotchi.Model;

import java.util.Random;

public class Model {

    int age = 0;
    double health = 100;
    double energy = 10;
    double happiness = 0;
    int numberOfDrugs = 5;
    int nuberOfBeers = 5;

    int lastMealTime;
    int lastWakeUpTime;


    boolean hungry;
    boolean dead;
    boolean sleepy;
    boolean sick;
    boolean asleep;

    void increaseAge(int i) {
        this.age += i;
    }

    void increaseHealth(int i) {
        if (health + i <= 100) {  //not tdd
            health += i;
        } else {
            health = 100;
        }
    }

    void decreaseHealth(int i) {
        if (health - i >= 0) {  //not tdd
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

    void decreaseEnergy(int i) {
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

    void decreaseHappiness(int i) {
        if (happiness - i >= -10) {  //not tdd
            happiness -= i;
        } else {
            happiness = -10;
        }
    }

    void getHungry() { hungry = true; }

    void getSleepy() {
        sleepy = true;
    }

    void die() {
        dead = true;
    }

    void getsick() {
        double chanceOfSickness = 10 + age / 60 - happiness / 2 - energy / 4;

        if (chanceOfSickness > new Random().nextInt(100)) {
            sick = true;
        }
    }

    //////////// USER ACTIONS //////////////////////////

    public void eat() {
        hungry = false;
        lastMealTime = age;
    }

    public void sleep() {
        sleepy = false;
        increaseEnergy(5);
        lastWakeUpTime = age;
    }

    public void drinkBeer() {
        if(nuberOfBeers>0){
            increaseHappiness(3);
            nuberOfBeers--;
        }
    }

    public void takeDrugs() {
        if(numberOfDrugs>0){
            numberOfDrugs--;
            sick = false;
        }
    }

    public void excersise() {
        if (energy >= 3) {
            decreaseEnergy(3);
            increaseHappiness(2);
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
}
