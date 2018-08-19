package Tamagotchi;

import Tamagotchi.Model.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Model model = new Model();
        Pane view = new View(model);

        new Controller(model, view);


        primaryStage.setScene(new Scene(view, View.WIDTH, View.HEIGHT));
        primaryStage.show();

    }
}
