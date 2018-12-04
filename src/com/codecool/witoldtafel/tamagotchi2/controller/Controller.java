package com.codecool.witoldtafel.tamagotchi2.controller;

import com.codecool.witoldtafel.tamagotchi2.view.View;
import com.codecool.witoldtafel.tamagotchi2.model.Model;

public class Controller {

    private TimeLoop timeLoop;
    private View view;

    public Controller(Model model, View view) {
        this.view = view;
        this.timeLoop = new TimeLoop(model);

        timeLoop.start();
        addListenerToSlider();
        this.view.beer.setOnMouseClicked(e -> view.setMsg(model.drinkBeer()));
        this.view.pill.setOnMouseClicked(e -> view.setMsg(model.takeDrugs()));
        this.view.pizza.setOnMouseClicked(e -> view.setMsg(model.eat()));
        this.view.workout.setOnMouseClicked(e -> view.setMsg(model.sing()));
        this.view.sleep.setOnMouseClicked(e -> {
            if (model.isSleepy()) this.view.makeNight();
            view.setMsg(model.sleep());
        });
    }

    private void addListenerToSlider() {
        view.slider.valueProperty().addListener(
                (ov, old_val, new_val)
                        ->
                        timeLoop.setMultiplier(new_val.intValue())
        );
    }


}
