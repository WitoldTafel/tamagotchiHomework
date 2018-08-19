package Tamagotchi;


import Tamagotchi.Model.Model;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class View extends BorderPane {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    Slider slider = new Slider();
    ImageView pizza = new ImageView(new Image("pizza.png"));
    ImageView sleep = new ImageView(new Image("sleep.png"));
    ImageView workout = new ImageView(new Image("workout.png"));
    ImageView beer = new ImageView(new Image("beer.png"));
    ImageView pill = new ImageView(new Image("pills.png"));
    private Model model;
    private ImageView sick = new ImageView(new Image("sick.png"));
    private ImageView hungry = new ImageView(new Image("hungry.png"));
    private ImageView tired = new ImageView(new Image("tired.png"));
    private ImageView dude = new ImageView(new Image("egg.png"));
    private VBox leftVBox = new VBox();
    private ProgressBar healthBar = new ProgressBar(1);
    private ProgressBar happinessBar = new ProgressBar(1);
    private ProgressBar energyBar = new ProgressBar(10);
    private Text age = new Text();
    private Label numberOfBeersLeft = new Label();
    private Label numberOfDrugsLeft = new Label();
    private VBox newsVBox = new VBox();
    int nightStart;

    private AnimationTimer updater = new AnimationTimer() {
        @Override
        public void handle(long now) {
            age.setText(String.valueOf(model.getAge()));
            energyBar.setProgress(model.getEnergy() / 10);
            healthBar.setProgress(model.getHealth() / 100);
            happinessBar.setProgress(model.getHappiness() / 20 + 0.5);
            numberOfBeersLeft.setText(model.getNuberOfBeers() + " beers left");
            numberOfDrugsLeft.setText(model.getNumberOfDrugs() + " pills left");
            sick.setVisible(model.isSick());
            hungry.setVisible(model.isHungry());
            tired.setVisible(model.isSleepy());
            leftVBox.getChildren().forEach(node -> node.setVisible(!model.isDead()));
            switch (model.getAge()) {
                case 10:
                    dude.setImage(new Image("dino1.png"));
                    break;
                case 30:
                    dude.setImage(new Image("dino2.png"));
                    break;
                case 70:
                    dude.setImage(new Image("dino3.png"));
                    break;
                case 130:
                    dude.setImage(new Image("dino4.png"));
                    break;
                case 200:
                    dude.setImage(new Image("dino5.png"));
                    break;
                case 300:
                    dude.setImage(new Image("dino6.png"));
                    break;
            }
            if(model.isDead())dude.setImage(new Image("rip.png"));
            if(model.getAge()>nightStart+5) View.this.setStyle("-fx-background-color: white;");//??????
        }
    };


    public View(Model model) {
        this.model = model;
        setHBox(this);
        setLeftVBox(this);
        setRightVBox(this);
        this.setCenter(dude);

        updater.start();
    }

    private void setHBox(BorderPane pane) {

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);

        Label healthLabel = new Label("Health:");
        healthBar.setStyle("-fx-accent: forestgreen");

        Label happinessLabel = new Label("Happiness:");
        happinessBar.setProgress(0.5);
        happinessBar.setStyle("-fx-accent: orange");

        Label energyLabel = new Label("Energy:");
        energyBar.setStyle("-fx-accent: blue");

        Label aligningLabel = new Label("                                                          ");
        Label ageLabel = new Label("Age:");
        VBox agePanel = new VBox();
        agePanel.getChildren().addAll(age, slider);
        agePanel.setAlignment(Pos.CENTER);
        setSlider();

        hBox.getChildren().addAll(
                healthLabel, healthBar,
                happinessLabel, happinessBar,
                energyLabel, energyBar,
                aligningLabel, ageLabel, agePanel);

        pane.setTop(hBox);
    }

    private void setSlider() {
        slider.setMin(1);
        slider.setMax(60);
        slider.setValue(1);
    }

    private void setLeftVBox(BorderPane pane) {
        leftVBox.setPadding(new Insets(15));
        leftVBox.setSpacing(40);
        leftVBox.setAlignment(Pos.CENTER);
        leftVBox.getChildren().addAll(pizza, sleep, workout, numberOfBeersLeft, beer, numberOfDrugsLeft, pill);
        pane.setLeft(leftVBox);
    }

    private void setRightVBox(BorderPane pane) {
        VBox rightVBox = new VBox();
        rightVBox.setPadding(new Insets(15));
        rightVBox.setSpacing(70);
        rightVBox.setAlignment(Pos.CENTER);
        rightVBox.getChildren().addAll(tired, hungry, sick);
        pane.setRight(rightVBox);
    }

    private void setNewsVBox(BorderPane pane) {
        newsVBox.setPadding(new Insets(15));
        newsVBox.setSpacing(10);
        newsVBox.setAlignment(Pos.CENTER);
        newsVBox.getChildren().addAll();
        pane.setRight(newsVBox);
    }

    void makeNight(){
        nightStart = model.getAge();
        this.setStyle("-fx-background-color: black;");
    }
}

