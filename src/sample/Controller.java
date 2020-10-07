package sample;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Controller {
    @FXML private Circle ball;
    @FXML private Rectangle p1paddle;
    @FXML private Rectangle p2paddle;

    //method called by the AnchorPane and is accessed on every keypress
    public void paddleMove(KeyEvent event) {
        double heightP1 = p1paddle.getY(); //sets a local height variable for p1 equivalent to p1paddle's Y location
        double heightP2 = p2paddle.getY(); //sets a local height variable for p2 equivalent to p2paddle's Y location

        //switch that takes the keyboard input and changes the outcome according to which key was pressed
        switch (event.getCode()) {
            case W:
                p1paddle.setY(heightP1-15); //updates the Y coordinate of paddle 1 up 15 pixels
                break;
            case S:
                p1paddle.setY(heightP1+15); //updates the Y coordinate of paddle 1 down 15 pixels
                break;
            case UP:
                p2paddle.setY(heightP2-15); //updates the Y coordinate of paddle 2 up 15 pixels
                break;
            case DOWN:
                p2paddle.setY(heightP2+15); //updates the Y coordinate of paddle 2 down 15 pixels
                break;
            default:
                break;
        }

    }
}
