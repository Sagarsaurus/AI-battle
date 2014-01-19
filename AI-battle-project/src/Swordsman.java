import java.lang.reflect.InvocationTargetException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Swordsman extends Character{
	boolean LIFE = true;
	final static int NUM_CHAR_SPACES = 6;
	
	public Swordsman(){
		this(0,0,0, null, null);
		
	}
	
	public Swordsman(int x, int y, int teamNum, CollisionDetection collisionDetection, Class aiClass)
	{
	    super(x,y, teamNum, collisionDetection, aiClass);
	    texture = new Texture(Gdx.files.internal("assets/swordsman.png"));
	    sprite = new Sprite(texture, 0, 0, GameController.CHARACTER_SIZE, GameController.CHARACTER_SIZE);
	    hp = 2;
	    sideView = 2;
	    backView = 1;
	    frontView = 4;
	    attackSpeed = 0.25;
	}
	
	public boolean canMove(int direction){
		return true;
	}

	
	public Sprite getSprite() {
		return sprite;
	}
	
	public String getType(int perspectiveTeam) 
    {
        if(perspectiveTeam == teamNum)
        {
            return "FS";
        }
        else
        {
            return "ES";
        }
    }
	
	public void update()
	{
	    super.update();
	    try {
	        
            aiClass.getMethod("swordsmanAI", Swordsman.class).invoke(null, this);
            
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
