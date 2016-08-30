package com.augmentis.ayp.screen;

import com.augmentis.ayp.gemeworld.GameRenderer;
import com.augmentis.ayp.gemeworld.GameWorld;
import com.augmentis.ayp.zbhelpers.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Tanaphon on 8/30/2016.
 */
public class GameScreen implements Screen {
    private static final String TAG = "GameScreen";
    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    // This is the constructor, not the class declaration
    public GameScreen() {
        Gdx.app.log(TAG, "Attached");
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);
        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world,(int) gameHeight, midPointY);
        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
    }

    @Override
    public void show() {
        Gdx.app.log(TAG, "Show called");
    }

    @Override
    public void render(float delta) {
        runTime+=delta;
        world.update(delta);
        renderer.render(runTime);
//        Gdx.app.log(TAG, "Game screen fps: " + 1 / delta);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log(TAG, "Resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log(TAG, "Pause calles");
    }

    @Override
    public void resume() {
        Gdx.app.log(TAG, "Resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log(TAG, "Hide called");
    }

    @Override
    public void dispose() {

    }
}
