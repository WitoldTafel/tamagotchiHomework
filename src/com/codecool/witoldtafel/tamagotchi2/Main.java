package com.codecool.witoldtafel.tamagotchi2;

import com.codecool.witoldtafel.tamagotchi2.controller.MainController;
import com.codecool.witoldtafel.tamagotchi2.model.Model;
import com.codecool.witoldtafel.tamagotchi2.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Model model = new Model();
        View view = new View(model);

        new MainController(model, view);


        primaryStage.setScene(new Scene(view, View.WIDTH, View.HEIGHT));
        primaryStage.show();

    }
}
