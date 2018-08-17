package Main;

public class Model {

    int age = 1;
    int health = 100;
    int energy = 10;
    int happiness = 0;

    int sleepDuration = 10;
    int sicknessDuration = 20;
    int excersiseDuration = 2;

    int numberOfDrugs = 5;
    int nuberOfBeers = 5;

    double chanceOfSickness;

    boolean hungry;

    public void increaseAge(int i) {
        this.age += i;
    }

    public void increaseHealth(int i) {
        this.health += i;
    }

    public void decreaseHealth(int i) {
        this.health -= i;

    }
}
