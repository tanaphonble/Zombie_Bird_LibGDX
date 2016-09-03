package com.augmentis.ayp.gemeworld;

import com.augmentis.ayp.gameobjects.Bird;
import com.augmentis.ayp.gameobjects.ScrollHandler;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Tanaphon on 8/30/2016.
 */
public class GameWorld {
    private static final String TAG = "GameWorld";

    private Bird bird;
    private ScrollHandler scroller;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        // The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta) {
        bird.update(delta);
        scroller.update(delta);
        if(scroller.collides(bird)){
            // Clean up on game over
            scroller.stop();
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller(){
        return scroller;
    }
}
