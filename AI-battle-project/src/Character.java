import java.awt.Graphics;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


abstract class Character{
        protected int x;
        protected int y;
        boolean LIFE = true;
        Texture texture;
        Sprite sprite;
    	final static int NUM_CHAR_SPACES = 6;
    	Field field;
    	Sprite[] rocks;
    	Team one, two;
        
	public Character(){
	    this(0,0);
	}
	
	public Character(int x,int y)
	{
	    this.x = x;
	    this.y = y;
	}
	
	public void draw(SpriteBatch batch){
	    sprite.setPosition(x, y);
        sprite.draw(batch);
//stuffsrwer
	}
	
	public void moveRight(){
		x+=AIBattle.CHARACTER_SIZE*NUM_CHAR_SPACES * Gdx.graphics.getDeltaTime();
	}
	
	public void moveLeft(){		
		x-=AIBattle.CHARACTER_SIZE*NUM_CHAR_SPACES * Gdx.graphics.getDeltaTime();
	}
	
	public void moveUp(){		
		y+=AIBattle.CHARACTER_SIZE*NUM_CHAR_SPACES * Gdx.graphics.getDeltaTime();
	}
	
	public void moveDown(){		
		y-=AIBattle.CHARACTER_SIZE*NUM_CHAR_SPACES * Gdx.graphics.getDeltaTime();
	}
	
	public boolean canMove(int direction) {
		return true;
	}
}
