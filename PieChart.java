package com.labs.lab10;
import javafx.application.*;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.layout.Pane;
public class PieChart extends Application{
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Scene scene = new Scene(pane,420,420);

        double[] percentages = new double[]{0.20,0.10,0.30,0.40};
        String[] names = new String[]{"Java","C++","Python","JavaScript"};
        Color[] colors = new Color[]{Color.RED,Color.BLUE,Color.GREEN,Color.ORANGE};
        CreatePieChart(pane,percentages,names,colors);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pie Chart");
        primaryStage.show();


    }

    public void CreatePieChart(Pane pane,double[] percentages,String[] names,Color[] colors){

        double cx = pane.getWidth()/2, cy = pane.getHeight()/2, radius = pane.getHeight() * 0.4;
        double lastAngle = 0;
        for(int i=0;i<percentages.length;i++){
            double newAngle = percentages[i]*360;
            Arc arc = new Arc(cx,cy,radius,radius,lastAngle, newAngle);
            arc.setFill(colors[i]);
            arc.setType(ArcType.ROUND);
            pane.getChildren().add(arc);
            double midAngle = Math.toRadians((lastAngle + lastAngle + newAngle)/2);
            double width = names[i].length() * 20;
            Text label = new Text(
                    cx + Math.cos(midAngle) * radius*0.6 - width*0.25,
                    cy - Math.sin(midAngle) * radius*0.6,
                    names[i] + String.format("\n%.0f%%",100*percentages[i]));
            label.setFill(Color.WHITE);
            label.setFont(Font.font("Arial",radius*0.1));
            pane.getChildren().add(label);

            lastAngle += newAngle;
        }
    }
    public static void main(String[] args){
        Application.launch(args);
    }
}
