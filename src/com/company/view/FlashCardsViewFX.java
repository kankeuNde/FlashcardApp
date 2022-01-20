package com.company.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashCardsViewFX extends Application {
    private Button quiz;
    private Button play;
    private Button close;

    private StackPane root;
    private Scene scene;

    public FlashCardsViewFX(){
        this.quiz = new Button("Add Quiz");
        this.play = new Button("Play");
        this.close = new Button("Close");
        this.root = new StackPane();
        root.getChildren().addAll(quiz, play, close);
        this.scene = new Scene(root);

    }
    @Override
    public void start(Stage flashStage) throws Exception {
        flashStage.setScene(scene);
        flashStage.setTitle("FlashCard App");
        flashStage.setWidth(300);
        flashStage.setHeight(300);
        flashStage.show();
    }

    public static void launchApp(String... args){
        launch(args);
    }
}
