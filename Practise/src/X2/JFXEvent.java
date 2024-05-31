package X2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class JFXEvent extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group group =new Group();
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("rect animation");
        /**
         * create a new button
         * it is an event of exit button click
         */
        Button exit = new Button("Exit");
        group.getChildren().add(exit);
        exit.setOnMouseClicked(event->{stage.close();});


        /**
         * create a new canvas
         */
        Canvas canvas = new Canvas(800,800);
        group.getChildren().add(canvas);

        //get to draw
        //get the graphicsContext then in that we fill a rect(x,y,w,h)
        //then set the color of it

        GraphicsContext ctx = canvas.getGraphicsContext2D();
        ctx.setFill(Color.GREEN);
        ctx.fillRect(40,40,120,120);


        /**
         * create a game
         * in Game, we convey the canvas into game, then make drawing on the canvas
         * So we also need to make operation on GraphicsContext
         */
        Game game = new Game(canvas);
        game.start();

        /**
         * create an event of key presse
         */
        canvas.setOnKeyPressed(event->{
            System.out.println("Canvas" + event.getCode().toString());
            if(event.getCode() == KeyCode.UP){
                game.ySpeedBase+=5;
                game.xSpeedBase+=5;
            }
            if(event.getCode() == KeyCode.DOWN){
                if ((game.xSpeedBase - 5 > 0)) {
                    game.xSpeedBase -= 5;
                } else {
                    game.xSpeedBase = 0;
                }

                if ((game.ySpeedBase - 5 > 0)) {
                    game.ySpeedBase -= 5;
                } else {
                    game.ySpeedBase = 0;
                }

            }
            System.out.println(game.xSpeedBase+ "    " +game.ySpeedBase);
        });
        //it needs focus
        canvas.requestFocus();

        stage.show();

    }
}
