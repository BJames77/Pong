package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Controller {
    @FXML private Circle ball; //pulls the Circle "ball" from sample.fxml
    @FXML private Rectangle p1paddle; //pulls the Rectangle "p1paddle" from sample.fxml
    @FXML private Rectangle p2paddle; //pulls the Rectangle "p2paddle" from sample.fxml
    @FXML private AnchorPane pane;
    private double p1paddleDY;
    private double p2paddleDY;
    private double ballDX;
    private double ballDY;

    //AnimationTimer allows for a continuous input to be registered.
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            double p1paddleY = p1paddle.getY(); //sets a height variable for p1 equivalent to p1paddle's Y location
            double p2paddleY = p2paddle.getY(); //sets a height variable for p2 equivalent to p2paddle's Y location
            double ballX = ball.getLayoutX();
            double ballY = ball.getLayoutY();
            double maxSpeed = 6; //the maximum pixels per frame that the ball will move

            //adds the ball x and y deltas to the ball's coordinates
            ballX += ballDX;
            ballY += ballDY;
            //makes sure the ball doesn't go out of bounds
            if (ballY > pane.getHeight()-10 || ballY < pane.getMinHeight()+10) {
                ballDY = ballDY * -1;
            }
            //for testing: the ball won't go too far left or right
            /*if (ballX > pane.getWidth()-10 || ballX < pane.getMinWidth()+10) {
                ballDX = ballDX * -1;
            }*/

            //if the ball hits paddle 1, its speed will be inverted and increased slightly
            if ((ballY >= p1paddleY && ballY <= p1paddleY+100) && (ballX <= pane.getMinWidth()+25 && ballX >= pane.getMinWidth()+15)) {
                if (ballDX < maxSpeed && ballDX > -maxSpeed) {
                    ballDX = ballDX * -1.5;
                } else {
                    ballDX = ballDX * -1;
                }
            }
            //if the ball hits paddle 2, its speed will be inverted and increased slightly
            if ((ballY >= p2paddleY && ballY <= p2paddleY+100) && (ballX >= pane.getWidth()-25 && ballX <= pane.getWidth()-15)) {
                if (ballDX < maxSpeed && ballDX > -maxSpeed) {
                    ballDX = ballDX * -1.5;
                } else {
                    ballDX = ballDX * -1;
                }
            }

            //sets the ball's coordinates from the xml to the local x and y coordinates
            ball.setLayoutX(ballX);
            ball.setLayoutY(ballY);


            p1paddleY += p1paddleDY;
            p2paddleY += p2paddleDY;

            //prevents paddle 1 from going higher than the pane's height
            if (p1paddleY < 0) {
                p1paddleY = 0;
            }
            //prevents paddle 2 from going higher than the pane's height
            if (p2paddleY < 0) {
                p2paddleY = 0;
            }
            //prevents paddle 1 from going lower than the pane's height
            if (p1paddleY > 500) {
                p1paddleY = 500;
            }
            //prevents paddle 2 from going lower than the pane's height
            if (p2paddleY > 500) {
                p2paddleY = 500;
            }
            p1paddle.setY(p1paddleY);
            p2paddle.setY(p2paddleY);
        }
    };

    //method called by the AnchorPane and is accessed on every keypress
    public void paddleMove(KeyEvent event) {

        //switch that takes the keyboard input and changes the outcome according to which key was pressed
        switch (event.getCode()) {
            case W:
                p1paddle.getY();
                p1paddleDY = -5; //updates the Y delta to be -5 pixels per frame (goes up)
                break;
            case S:
                p1paddleDY = 5; //updates the Y delta to be 5 pixels per frame (goes down)
                break;
            case UP:
                p2paddleDY = -5; //updates the Y delta for paddle 2 to be -5 pixels per frame (goes up)
                break;
            case DOWN:
                p2paddleDY = 5; //updates the Y delta for paddle 2 to be 5 pixels per frame (goes down)
                break;
            default:
                break;
        }
    }

    public void paddleStop(KeyEvent event2) {
        switch (event2.getCode()) {
            case W:
            case S:
                p1paddleDY = 0; //updates the Y coordinate of paddle 1 down 15 pixels
                break;
            case UP:
            case DOWN:
                p2paddleDY = 0; //updates the Y coordinate of paddle 2 down 15 pixels
                break;
            default:
                break;
        }
    }

    public void ballMove(MouseEvent event) {
        timer.start();
        if (event.getButton()== MouseButton.PRIMARY) {
            ballDX = -1;
            ballDY = -1;
        }
    }
}
