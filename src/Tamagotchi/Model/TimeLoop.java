package Tamagotchi.Model;

import javafx.animation.AnimationTimer;


public class TimeLoop extends AnimationTimer {

    private Model model;

    private final int getingHungryInterval = 35;
    private final int getingSleepyInterval = 80;
    private final int getingSickInterval = 10;
    private final int getingSadinterval = 13;

    private int multiplier = 60;
    private int counter = 0;

    public TimeLoop(Model model){
        this.model = model;
    }

    public void setMultiplier(int value) {
        multiplier = 60/value ;
    }


    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {
        if(model.dead){
            this.stop();
        }
        counter++;


        if (counter % multiplier == 0) {
            model.increaseAge(1);

/////////////////////////SADNESS////////////////////////////////

            if(model.age/getingSadinterval == 0){
                if (model.happiness>0){
                    model.decreaseHappiness(1);
                }
            }

/////////////////////////HUNGER////////////////////////////////

            if((model.age - model.lastMealTime) % getingHungryInterval == 0){
                model.getHungry();
            }
            if (model.hungry & model.age % 5 == 0){
                model.decreaseHealth(3);
                model.decreaseHappiness(2);

            }
////////////////////////SLEEPINESS////////////////////////////////
            if((model.age - model.lastWakeUpTime) % getingSleepyInterval == 0){
                model.getSleepy();
            }
            if (model.sleepy & model.age % 3 == 0){
                model.decreaseHealth(1);
                model.decreaseHappiness(1);
                model.decreaseEnergy(1);
            }
////////////////////////SICKNESS////////////////////////////////
            if(model.age  % getingSickInterval == 0){
                model.getsick();
            }
            if (model.sick){
                model.decreaseHealth(2);
            }
        }
    }
}





