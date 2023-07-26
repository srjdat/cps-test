package com.example.cpstest;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application  {

    Button btn, btn2;

    int test;
    public static int count1;

    @Override
    public void start(Stage stage) throws IOException {
        //the main scene
        //doing all the stuff with the buttons
        btn = new Button("5 Second CPS Test");
        btn2 = new Button("10 Second CPS Test");
        btn.setOnAction(e -> {
            new FiveCPS().display();
        });

        VBox pane = new VBox(15);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(btn, btn2);

        Scene s = new Scene(pane, 300, 200);

        //all the stage stuff
        stage.setTitle("CPS Test");
        stage.setScene(s);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    public static class CPS {
        private int cps;

        public CPS(int cps) {
            this.cps = cps;
        }

        public void setCPS(int cps) {
            this.cps = cps;
        }
    }
}