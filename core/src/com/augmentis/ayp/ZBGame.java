package com.augmentis.ayp;

import com.augmentis.ayp.screen.GameScreen;
import com.augmentis.ayp.zbhelpers.AssetLoader;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class ZBGame extends Game {

    private static final String TAG = "ZBGame";
    @Override
    public void create() {
        AssetLoader.load();
        Gdx.app.log(TAG, "created");
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
