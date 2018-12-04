package com.codecool.witoldtafel.tamagotchi2.model;

import javafx.animation.AnimationTimer;


public class TimeLoop extends AnimationTimer {

    private Model model;

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

            int getingSadinterval = 10;
            if(model.age/ getingSadinterval == 0){
                if (model.happiness>0){
                    model.decreaseHappiness(1);
                }
            }

/////////////////////////HUNGER////////////////////////////////

            int getingHungryInterval = 15;
            if((model.age - model.lastMealTime) % getingHungryInterval == 0){
                model.startHunger();
            }
            if (model.hungry & model.age % 5 == 0){
                model.decreaseHealth(3);
                model.decreaseHappiness(2);

            }
////////////////////////SLEEPINESS////////////////////////////////
            int getingSleepyInterval = 30;
            if((model.age - model.lastWakeUpTime) % getingSleepyInterval == 0){
                model.startSleepiness();
            }
            if (model.sleepy & model.age % 3 == 0){
                model.decreaseHealth(1);
                model.decreaseHappiness(1);
                model.decreaseEnergy(1);
            }
////////////////////////SICKNESS////////////////////////////////
            int getingSickInterval = 10;
            if(model.age  % getingSickInterval == 0){
                model.startSickness();
            }
            if (model.sick){
                model.decreaseHealth(2);
            }
        }
    }
}





