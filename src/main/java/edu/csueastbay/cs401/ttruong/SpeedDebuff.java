package edu.csueastbay.cs401.ttruong;

import edu.csueastbay.cs401.pong.Collidable;
import edu.csueastbay.cs401.pong.Collision;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

//create class for debuff obj

/**
 *  * class that extends circle by creating circular objects
 *  * while tracking type to ensure that collisionhandler can handle
 *  * the collisions with puck in classicpong. when collided,
 *  * this will decrease the speed of the puck.
 */
public class SpeedDebuff extends Circle implements Collidable {
    private final double fieldWidth;
    private final double fieldHeight;
    private String id;

    /**
     * SpeedDebuff constructor takes in
     * @param fieldWidth - width of the field
     * @param fieldHeight - height of the field
     */
    public SpeedDebuff(double fieldWidth, double fieldHeight) {
        super();
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
    }

    @Override
    public Collision getCollision(Shape shape) {
        return new Collision(
                "SpeedDebuff",
                this.id,
                this.getLayoutBounds().intersects(shape.getLayoutBounds()),
                this.getLayoutBounds().getMinY(),
                this.getLayoutBounds().getMaxY(),
                this.getLayoutBounds().getMinX(),
                this.getLayoutBounds().getMaxX()
        );
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getType() {
        return "NoSpeedBoost";
    }
}
