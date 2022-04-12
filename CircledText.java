package com.labs.lab10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CircledText extends Application {

    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Scene scene = new Scene(pane,420,360);
        CreateCircledText(pane,"WELCOME TO JAVAFX ",
                pane.getWidth()/2,pane.getHeight()/2,pane.getHeight()*0.35,0,true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Circled Text");
        primaryStage.show();
    }
    public void CreateCircledText(Pane pane, String text, double cx, double cy, double radius, int startingAngle, boolean clockWise){
        int currentAngle = startingAngle;

        double step = 360.0 / text.length();
        for(int i=0;i<text.length(); ++i){
            char c = text.charAt(i);
            double x = cx + radius * Math.cos(Math.toRadians(currentAngle));
            double y = cy + radius * Math.sin(Math.toRadians(currentAngle));
            Text character = new Text(x,y,c+"");
            character.setFill(new Color(Math.random(),Math.random(),Math.random(),1));
            character.setRotate(currentAngle + 90);
            character.setFont(Font.font("Arial",FontWeight.BOLD,radius*0.35));
            pane.getChildren().add(character);
            if(clockWise)
                currentAngle += step;
            else
                currentAngle -= step;

        }
    }
    public static void main(String[] args){
        Application.launch(args);
    }
}
