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
//stuffs
	}
}
