package com.augmentis.ayp.gemeworld;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Tanaphon on 8/30/2016.
 */
public class GameWorld {
    private static final String TAG = "GameWorld";

    private Rectangle rect = new Rectangle(0, 0, 17, 12);

    public void update(float delta) {
//        Gdx.app.log(TAG, "world --> update");
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
    }

    public Rectangle getRect(){
        return rect;
    }
}
