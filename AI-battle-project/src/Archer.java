import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Archer extends Character {
	
	public Archer(){
		this(0,0,0, null, null);
	}

	public Archer(int x, int y, int teamNum, CollisionDetection collisionDetection, Class aiClass) {
		super(x, y, teamNum, collisionDetection, aiClass);
		texture = new Texture(Gdx.files.internal("assets/archer.png"));
		sprite = new Sprite(texture, 0, 0, GameController.CHARACTER_SIZE, GameController.CHARACTER_SIZE);
	    hp = 2;
        sideView = 4;
        backView = 3;
        frontView = 15;
        attackSpeed = 5;
        currentAttackSpeed = 5;
	}

	@Override
	public String getType(int perspectiveTeam) {
		 if(perspectiveTeam == teamNum)
	        {
	            return "FA";
	        }
	        else
	        {
	            return "EA";
	        }
	}
	
	public boolean canShoot()
	{
	    return currentAttackSpeed >= attackSpeed;
	}
	
	public void shoot(int targetX, int targetY) {
	    if(canShoot())
	    {
	        float deltaX = (targetX-getX());
            float deltaY = (targetY-getY());
            double normalization = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            deltaX /= normalization;
            deltaY /= normalization;
            
            
            Arrow a = new Arrow(x, y, this.teamNum, collisionDetection, null, Math.toDegrees(Math.atan2(deltaY, deltaX)));
            
            a.deltaX = deltaX;
            a.deltaY = deltaY;
            GameController.entities.add(a);
            currentAttackSpeed = 0;
	    }
        
    }
	
	public void update()
	{
	    super.update();
	    try {
	        
            aiClass.getMethod("archerAI", Archer.class).invoke(null, this);
            
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
