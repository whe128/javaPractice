package X2;

import com.sun.scenario.animation.shared.TimerReceiver;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game extends AnimationTimer {
    double WIDTH = 50;
    double HEIGHT=50;

    Canvas canvas;
    public Game(Canvas canvas){
        this.canvas = canvas;
    }

    double x=5;
    double y=50;
    double xSpeedBase = 5;
    double ySpeedBase = 10;
    double xSpeed = xSpeedBase;
    double ySpeed = ySpeedBase;

    @Override
    public void handle(long l) {
        x+=xSpeed;
        //
        if(x>=canvas.getWidth()-WIDTH/2 && xSpeed>0){
            xSpeed = -xSpeedBase;
        }
        else if (x<=WIDTH/2 && xSpeed<0) {
            xSpeed = xSpeedBase;
        }

        //
        y+=ySpeed;
        if(y>=canvas.getWidth()-HEIGHT/2 && ySpeed>0){
            ySpeed = -ySpeedBase;
        }
        else if (y<=HEIGHT/2 && ySpeed<0) {
            ySpeed = ySpeedBase;
        }

        GraphicsContext ctx = canvas.getGraphicsContext2D();
        //Fill all the range ,is erased
        ctx.setFill(Color.WHITE);
        ctx.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        //draw again with a new position
        ctx.setFill(Color.GREEN);
        ctx.fillRect(x-WIDTH/2,y-HEIGHT/2, WIDTH, HEIGHT);
    }
}
