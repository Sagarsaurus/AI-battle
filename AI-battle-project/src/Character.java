import java.awt.Graphics;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Character{
	protected int x;
	protected int y;
	int yChange;
	boolean LIFE = true;
	Texture texture;
	Sprite sprite;

	public Character(){
		texture = new Texture(Gdx.files.internal("swordsman.png"));
		sprite = new Sprite(texture, 0, 0, 32, 64);
		Random randX = new Random();
		Random randY = new Random();
		x = randX.nextInt(500);
		y = randY.nextInt(500);
	}
	
	public Character(int newX, int newY){
		x=newX;
		y=newY;
	}
	
	public void draw(SpriteBatch batch){
		
		sprite.setPosition(10, 10);
		sprite.draw(batch);
	}
}