package edu.csueastbay.cs401.pong;

import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.PopupWindow;

import java.util.Random;

/**
 * Class to intialize puck object. Implements puckable interface
 * @see Puckable
 */
public class Puck extends Circle implements Puckable {


    /**
     * Variables to manipulate puck
     */
    public static final double STARTING_SPEED = 5.0;
    public static final int STARTING_RADIOUS = 5;

    public static final double STARTING_SPEED = 5;
    public static final int STARTING_RADIUS = 5;

    private final double fieldWidth;
    private final double fieldHeight;
    private String id;
    private Double speed;
    private Double direction;

    /**
     * Constructor
     * @param fieldWidth width of the puck
     * @param fieldHeight Height of the puck
     */
    public Puck(double fieldWidth, double fieldHeight) {
        super();
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        reset();
    }

    /**
     * Method to reset the values.
     */
    @Override
    public void reset() {
        Random random = new Random();
        setCenterX(fieldWidth / 2);
        setCenterY(fieldHeight / 2);
        setRadius(STARTING_RADIUS);
        setFill(Color.WHITE);

        speed = STARTING_SPEED;
        if (random.nextInt(2) == 0) {
            direction = (random.nextDouble() * 90) - 45;
        } else {
            direction = (random.nextDouble() * 90) + 115;
        }

    }

    /**
     * Getter to getID
     * @return id
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * Setter to set id
     * @param id
     */
    @Override
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Getter to get speed
     * @return speed
     */
    @Override
    public double getSpeed() {
        return speed;
    }

    /**
     * Getter to get direction
     * @return direction
     */
    @Override
    public double getDirection() {
        return direction;
    }

    /**
     * Setter to set the speed
     * @param speed
     */
    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Settter to set the direction
     * @param angle
     */
    @Override
    public void setDirection(double angle) {
        this.direction = angle;
    }

    /**
     * Manipulate movement of the puck.
     * Should not be a vertical movement.
     * Using simple math tricks
     */

    @Override
    public void move() {
        double deltaX = speed * Math.cos(Math.toRadians(direction));
        double deltaY = speed * Math.sin(Math.toRadians(direction));
        setCenterX(getCenterX() + deltaX);
        setCenterY(getCenterY() + deltaY);
    }


}
