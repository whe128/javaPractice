package X1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class JFXHelloWorld extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("JFXHelloWorld");
        //first create a group
        Group group = new Group();

        //then create scene, which concludes the group
        //at this step, we can set the size of scene
        Scene scene = new Scene(group,400,320);

        //let the scene to the stage
        stage.setScene(scene);

        //create the rectangle
        Rectangle rect = new Rectangle(380,130);
        group.getChildren().add(rect);
        rect.setFill(Color.BLUE);

        /**
        add a text to a group
         */
        Text text=new Text("hello World");
        text.setFont(new Font("Tahoma",70));
        text.setFill(Color.GREEN);
        text.setX((400-380)/2);
        text.setY((320-130)/2);
        group.getChildren().add(text);


        group.setLayoutX((400-380)/2);
        group.setLayoutY((320-130)/2);
        stage.setOpacity(0.8);
        stage.show();
    }

}
