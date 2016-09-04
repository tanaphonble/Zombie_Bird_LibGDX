package com.augmentis.ayp.gameobjects;

import com.augmentis.ayp.zbhelpers.AssetLoader;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tanaphon on 8/30/2016.
 */
public class Bird {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private boolean isAlive = true;

    private float rotation;
    private int width;
    private int height;

    private Circle boundingCircle;

    public Bird(float x, float y, int width, int height) {
        this.height = height;
        this.width = width;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
        boundingCircle = new Circle();
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }
        position.add(velocity.cpy().scl(delta));

        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);

        // Rotate counterclockwise
        if (velocity.y < 0) {
            rotation -= 600 * delta;
            if (rotation < -20) {
                rotation = -20;
            }
        }

        // Rotate clockwise
        if (isFalling() || !isAlive) {
            rotation += 480 * delta;
            if (rotation > 90) {
                rotation = 90;
            }
        }
    }

    public boolean isFalling() {
        return velocity.y > 110;
    }

    public boolean shoudntFlap() {
        return velocity.y > 70 || !isAlive;
    }

    public void die() {
        isAlive = false;
        velocity.y = 0;
    }

    public void decelerete() {
        // We want the bird to stop accelerating downwards once it is dead.
        acceleration.y = 0;
    }

    public void onClick() {
        AssetLoader.flap.play();
        velocity.y = -140;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public float getRotation() {
        return rotation;
    }

    public Circle getBoundingCircle() {
        return boundingCircle;
    }

    public boolean isAlive() {
        return isAlive;
    }
}