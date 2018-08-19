package Tamagotchi;

import Tamagotchi.Model.Model;
import Tamagotchi.Model.TimeLoop;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;

public class Controller {

    private Model model;
    private Pane view;
    TimeLoop timeLoop;

    public Controller(Model model, Pane view){
        this.model = model;
        this.view = view;
        this.timeLoop = new TimeLoop(model);
        timeLoop.start();
        addListenerToSlider((View) this.view);
        ((View) this.view).beer.setOnMouseClicked(e ->model.drinkBeer());
        ((View) this.view).pill.setOnMouseClicked(e ->model.takeDrugs());
        ((View) this.view).pizza.setOnMouseClicked(e ->model.eat());
        ((View) this.view).workout.setOnMouseClicked(e ->model.excersise());
        ((View) this.view).sleep.setOnMouseClicked(e ->{model.sleep();((View) this.view).makeNight();});
    }

    private void addListenerToSlider(View view){
        view.slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                timeLoop.setMultiplier(new_val.intValue());
            }
        });
    }


}
