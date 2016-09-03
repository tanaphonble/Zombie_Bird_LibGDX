package com.augmentis.ayp.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by Tanaphon on 9/1/2016.
 */
public class Pipe extends Scrollable {

    private Random r;

    private Rectangle skullUp, skullDown, barUp, barDown;
    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;
    private float groundY;


    // When Pipe's constructor is invoked, invoke the super (Scrollable)
    // Constructor
    public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY) {
        super(x, y, width, height, scrollSpeed);
        // Initialize a Random object for Random number generation
        r = new Random();
        skullUp = new Rectangle();
        skullDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();
        this.groundY = groundY;
    }

    @Override
    public void update(float delta) {
        // Call the update method in super class (Scrollable)
        super.update(delta);

        // The set() method allows you to set the top left corner's x, y, coordinates
        // along with the width and height of rectangle

        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width,
                groundY - (position.y + height + VERTICAL_GAP));

        // Our skull with is 24. The bar is only 22 pixels wide.
        // So the skull must be shifted by 1 pixel to the left
        // (so that skull is centered with respect to its bar)

        // This shift is equivalent to: (SKULL_WIDTH)/2
        skullUp.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height - SKULL_HEIGHT,
                SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y,
                SKULL_WIDTH, SKULL_HEIGHT);
    }

    @Override
    public void reset(float newX) {
        // Call the reset method in the superclass (Scrollable)
        super.reset(newX);
        // Change the height to a random number
        height = r.nextInt(90) + 15;
    }

    public Rectangle getBarDown() {
        return barDown;
    }

    public Rectangle getBarUp() {
        return barUp;
    }

    public Rectangle getSkullDown() {
        return skullDown;
    }

    public Rectangle getSkullUp() {
        return skullUp;
    }

    public boolean collides(Bird bird) {
        if (position.x < bird.getX() + bird.getWidth()) {
            return (Intersector.overlaps(bird.getBoundingCircle(), barUp)
            || Intersector.overlaps(bird.getBoundingCircle(), barDown)
            || Intersector.overlaps(bird.getBoundingCircle(), skullUp)
            || Intersector.overlaps(bird.getBoundingCircle(), skullDown));
        }
        return false;
    }
}
