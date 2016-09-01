package com.augmentis.ayp.gemeworld;

import com.augmentis.ayp.gameobjects.Bird;
import com.augmentis.ayp.zbhelpers.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * Created by Tanaphon on 8/30/2016.
 */
public class GameRenderer {
    private static final String TAG = "GameRenderer";
    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    private int midPointY;
    private int gameHeight;

    // Game Objects
    private Bird bird;

    // Game Assets
    private TextureRegion bg, grass;
    private Animation birdAnimation;
    private TextureRegion birdMid, birdDown, birdUp;
    private TextureRegion skullUp, skullDown, bar;

    private void initGameObject(){
        bird = myWorld.getBird();
    }

    private void initAssets(){
        bg = AssetLoader.bg;
        grass = AssetLoader.grass;
        birdAnimation = AssetLoader.birdAnimation;
        birdMid = AssetLoader.bird;
        birdDown = AssetLoader.birdDown;
        birdUp = AssetLoader.birdUp;
        skullUp = AssetLoader.skullUp;
        skullDown = AssetLoader.skullDown;
        bar = AssetLoader.bar;
    }

    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;

        // The world "this" refers to this instance.
        // We are setting the instance variable' values to be that of the
        // parameters passed in from GameScreen
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        initGameObject();
        initAssets();
    }

    public void render(float runTime) {

        // We will move these outside of the loop for performance letter.
        // Now we have bird from method initGameObject
        // Bird bird = myWorld.getBird();

        // Fill the entire screen width black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRender
        shapeRenderer.begin(ShapeType.Filled);

        // Draw background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Draw grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw dirt
        shapeRenderer.setColor(147 / 2550.f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);

        // End ShapeRender
        shapeRenderer.end();

        // Begin SpriteBatch
        batcher.begin();
        // Disable transparency
        // This is good for performance when drawing image that do not require transparency
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);

        // The bird needs transparency, so we enable that again
        batcher.enableBlending();

        // Draw bird at its coordinates. Retrieve the Animation object from AssertLoader
        // Pass in the RunTime variable to get the current frame
        batcher.draw(AssetLoader.birdAnimation.getKeyFrame(runTime),
                bird.getX(),
                bird.getY(),
                bird.getWidth(),
                bird.getHeight()
        );
        // End SpriteBatch
        batcher.end();
    }
}
