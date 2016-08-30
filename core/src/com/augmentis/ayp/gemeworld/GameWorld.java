package com.augmentis.ayp.gemeworld;

import com.augmentis.ayp.gameobjects.Bird;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Tanaphon on 8/30/2016.
 */
public class GameWorld {
    private static final String TAG = "GameWorld";

    private Bird bird;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {
        bird.update(delta);
    }

    public Bird getBird() {
        return bird;
    }
}
