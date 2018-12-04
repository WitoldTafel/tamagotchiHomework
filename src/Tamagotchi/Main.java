package Tamagotchi;

import Tamagotchi.Model.Model;
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

        new Controller(model, view);


        primaryStage.setScene(new Scene(view, View.WIDTH, View.HEIGHT));
        primaryStage.show();

    }
}
