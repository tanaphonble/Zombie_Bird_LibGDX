package com.augmentis.ayp;

import com.augmentis.ayp.screen.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class ZBGame extends Game {

    private static final String TAG = "ZBGame";
    @Override
    public void create() {
        Gdx.app.log(TAG, "created");
        setScreen(new GameScreen());
    }
}
