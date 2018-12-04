package com.codecool.witoldtafel.tamagotchi2.controller;

import com.codecool.witoldtafel.tamagotchi2.model.Model;
import javafx.animation.AnimationTimer;


public class TimeLoop extends AnimationTimer {

    private Model model;

    private int multiplier = 60;
    private int counter = 0;

    TimeLoop(Model model){
        this.model = model;
    }

    void setMultiplier(int value) {
        multiplier = 60/value ;
    }


    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {
        if(model.isDead()){
            this.stop();
        }
        counter++;


        if (counter % multiplier == 0) {
            model.increaseAge(1);

/////////////////////////SADNESS////////////////////////////////

            int getingSadinterval = 10;
            if(model.getAge()/ getingSadinterval == 0){
                if (model.getHappiness()>0){
                    model.decreaseHappiness(1);
                }
            }

/////////////////////////HUNGER////////////////////////////////

            int getingHungryInterval = 15;
            if((model.getAge() - model.getLastMealTime()) % getingHungryInterval == 0){
                model.startHunger();
            }
            if (model.isHungry() & model.getAge() % 5 == 0){
                model.decreaseHealth(3);
                model.decreaseHappiness(2);

            }
////////////////////////SLEEPINESS////////////////////////////////
            int getingSleepyInterval = 30;
            if((model.getAge() - model.getLastWakeUpTime()) % getingSleepyInterval == 0){
                model.startSleepiness();
            }
            if (model.isSleepy() & model.getAge() % 3 == 0){
                model.decreaseHealth(1);
                model.decreaseHappiness(1);
                model.decreaseEnergy(1);
            }
////////////////////////SICKNESS////////////////////////////////
            int getingSickInterval = 10;
            if(model.getAge()  % getingSickInterval == 0){
                model.startSickness();
            }
            if (model.isSick()){
                model.decreaseHealth(2);
            }
        }
    }
}





