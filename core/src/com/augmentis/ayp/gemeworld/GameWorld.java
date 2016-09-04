package com.augmentis.ayp.gemeworld;

import com.augmentis.ayp.gameobjects.Bird;
import com.augmentis.ayp.gameobjects.ScrollHandler;
import com.augmentis.ayp.zbhelpers.AssetLoader;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Tanaphon on 8/30/2016.
 */
public class GameWorld {
    private static final String TAG = "GameWorld";

    private int score = 0;

    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        // The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);
    }

    public void update(float delta) {

        // Add a delta cap so that the game takes too long to update,
        // we will not break our collision detection
        if (delta > .15f) {
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);

        if (bird.isAlive() && scroller.collides(bird)) {
            // Clean up on game over
            AssetLoader.dead.play();
            scroller.stop();
            bird.die();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerete();
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment){
        score += increment;
    }
}
