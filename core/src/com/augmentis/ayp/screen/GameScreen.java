package com.augmentis.ayp.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Tanaphon on 8/30/2016.
 */
public class GameScreen implements Screen {
    private static final String TAG = "GameScreen";
    public GameScreen(){
        Gdx.app.log(TAG, "Attached");
    }

    @Override
    public void show() {
        Gdx.app.log(TAG, "Show called");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
