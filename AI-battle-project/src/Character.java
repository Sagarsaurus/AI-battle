import java.awt.Graphics;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


abstract class Character extends Entity{
        boolean LIFE = true;
        int HP;
        int teamNum;
        
	public Character(){
	    this(0,0,0);
	}
	
	public Character(int x,int y, int teamNum)
	{
	    super(x,y);
	    this.teamNum = teamNum;
	}

	public int getHP()
	{
	    return HP;
	}
	
	public int getWidth()
	{
	    return (int)sprite.getWidth();
	}
	
	public int getHeight()
    {
        return (int)sprite.getHeight();
    }
	
	public int getX()
    {
        return x;
    }
	
	public int getY()
    {
        return y;
    }
}
