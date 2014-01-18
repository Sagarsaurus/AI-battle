
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class AIBattle implements ApplicationListener {
    Texture dropImage;
    Texture bucketImage;
    Sound dropSound;
    Music rainMusic;
    SpriteBatch batch;
    OrthographicCamera camera;
    Rectangle bucket;
    Array<Rectangle> raindrops;
    long lastDropTime;
    ShapeRenderer shapeRenderer;
    float x, y = 0;
    Field field;
    Team team;
    static final int CHARACTER_SIZE = 32;
    Castle castle1, castle2;
    List<Swordsman> swordsmen;
    @Override
    public void create() {
    	swordsmen = new ArrayList<Swordsman>();
    	for(int i = 0; i < 20; i++) {
    		swordsmen.get(i).x = 0;
    		swordsmen.get(i).y = 10 * i;
    	}
        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CHARACTER_SIZE * 30, CHARACTER_SIZE * 20);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        field = new Field();
        team = new Team(20,0);
    }

    @Override
    public void render() {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0.2f, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        batch.begin();
        field.draw(batch);
        for(Swordsman swordsman:swordsmen) {
            swordsman.draw(batch);
            swordsman.moveRight();	
            team.draw(batch);
        }
        batch.end();
        x +=1;
        y +=1;
        
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
