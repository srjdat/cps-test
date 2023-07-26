package com.example.cpstest;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class FiveCPS {

    private Button cpsBtn, resultBtn;
    private static Label lbl;
    public static int count;

    public void display() {
        //creating a new thread so the timer works
        //thank you, @xyve7, for helping me with this part
        Thread t = new Thread(new TimerThread());
        t.start();

        //the stage for the five cps thing
        Stage window = new Stage();

        //all the variables
        cpsBtn = new Button("Click Here!");
        cpsBtn.setOnAction(e -> {
            count++;
        });

        resultBtn = new Button("Results");
        resultBtn.setVisible(false);
        resultBtn.setOnAction(e -> {
            Stage results = new Stage();
            results.setTitle("Results");

            Label resultLbl = new Label();
            resultLbl.setFont(new Font(20));
            Label cpsLbl = new Label();
            cpsLbl.setFont(new Font(20));
            resultLbl.setText("Your CPS was: \n");
            cpsLbl.setText(String.format("%.2f", (double)count/5.0));

            VBox finalBox = new VBox(15);
            finalBox.setAlignment(Pos.CENTER);
            finalBox.getChildren().addAll(resultLbl, cpsLbl);

            Scene finalScene = new Scene(finalBox, 150, 150);
            results.setScene(finalScene);
            results.show();

            results.setOnCloseRequest(exit -> {
                results.close();
                window.close();
            });

        });

        lbl = new Label("Click on the Button as fast as you can!");

        //layout and setting the scene in the stage
        VBox pane = new VBox(15);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(cpsBtn, lbl, resultBtn);

        Scene cpsScene = new Scene(pane, 300, 200);
        window.setScene(cpsScene);

        window.show();
    }

    public int getCount() {
        return count;
    }

    class TimerThread implements Runnable {

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            long secondsElapsed;

            while(!cpsBtn.isDisabled()) {
                secondsElapsed = (System.currentTimeMillis() - startTime) / 1000;
                if (secondsElapsed == 5) {
                    cpsBtn.setDisable(true);
                    resultBtn.setVisible(true);
                }
            }
        }
    }
}