import java.awt.Graphics;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

abstract class Character extends Entity {
    boolean LIFE = true;
    
    int attackStength = 1;
    protected double attackSpeed = 0;
    protected double currentAttackSpeed = 0;
    protected int frontView = 0;
    protected int backView = 0;
    protected int sideView = 0;
    ArrayList<Coordinates> coordinates;

    protected Class aiClass;

    public Character() {
        this(0, 0, 0, null, null);
    }

    public Character(int x, int y, int teamNum,
            CollisionDetection collisionDetection, Class aiClass) {
        super(x, y, collisionDetection);
        this.teamNum = teamNum;
        this.aiClass = aiClass;
        if (teamNum == 0)
	    {
	        facing = Direction.RIGHT;
	    }
	    else
	    {
	        facing = Direction.LEFT;
	    }
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
	
	public boolean attack(Direction direction)
	{
	    Entity entity;
	    if(direction == Direction.FORWARD)
        {
            if(facing == Direction.RIGHT)
            {
                entity = collisionDetection.collisionAt(this, Direction.RIGHT);
            }
            else
            {
               entity = collisionDetection.collisionAt(this, Direction.LEFT);
            }
        }
        else if(direction == Direction.BACKWARD)
        {
            if(facing == Direction.LEFT)
            {
                entity = collisionDetection.collisionAt(this, Direction.RIGHT);
            }
            else
            {
                entity =collisionDetection.collisionAt(this, Direction.LEFT);
            }
        }
        else
        {
            
            entity = collisionDetection.collisionAt(this, direction);
        }
        
        
	    if(entity != null && entity.teamNum != -1 && entity.teamNum != this.teamNum && currentAttackSpeed >= attackSpeed)
	    {
	        entity.hp -= this.attackStength;
	        attackSpeed = 0;
	        return true;
	    }
	    return false;
	    
	}
	
	
	
	public boolean canMove(Direction direction)
	{
	    if(direction == Direction.FORWARD)
	    {
	        if(facing == Direction.RIGHT)
	        {
	            return collisionDetection.collisionAt(this, Direction.RIGHT) == null &&
	                   !collisionDetection.collisionWall(this, Direction.RIGHT);
	        }
	        else
	        {
	            return collisionDetection.collisionAt(this, Direction.LEFT) == null &&
	                   !collisionDetection.collisionWall(this, Direction.LEFT);
	        }
	    }
	    else if(direction == Direction.BACKWARD)
	    {
	        if(facing == Direction.LEFT)
            {
                return collisionDetection.collisionAt(this, Direction.RIGHT) == null &&
                       !collisionDetection.collisionWall(this, Direction.RIGHT);
            }
            else
            {
                return collisionDetection.collisionAt(this, Direction.LEFT) == null &&
                       !collisionDetection.collisionWall(this, Direction.LEFT);
            }
	    }
	    
	    return collisionDetection.collisionAt(this, direction) == null && !collisionDetection.collisionWall(this, direction);
	}
	
	public boolean canAttack(Direction direction)
    {
	    if(direction == Direction.FORWARD)
        {
            if(facing == Direction.RIGHT)
            {
                return collisionDetection.collisionAt(this, Direction.RIGHT) != null && currentAttackSpeed >= attackSpeed;
            }
            else
            {
                return collisionDetection.collisionAt(this, Direction.LEFT) != null && currentAttackSpeed >= attackSpeed;
            }
        }
        else if(direction == Direction.BACKWARD)
        {
            if(facing == Direction.LEFT)
            {
                return collisionDetection.collisionAt(this, Direction.RIGHT) != null && currentAttackSpeed >= attackSpeed;
            }
            else
            {
                return collisionDetection.collisionAt(this, Direction.LEFT) != null && currentAttackSpeed >= attackSpeed;
            }
        }
        return collisionDetection.collisionAt(this, direction) != null && currentAttackSpeed >= attackSpeed;
    }
	
	public void moveUp()
    {
        if((collisionDetection.collisionAt(this, Direction.UP) == null) &&
            !collisionDetection.collisionWall(this, Direction.UP))
        {
            y += GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	
	public void moveDown()
    {
        if(collisionDetection.collisionAt(this, Direction.DOWN) == null &&
           !collisionDetection.collisionWall(this, Direction.DOWN))
        {
            y -= GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	
	private void moveLeft()
    {
        if(collisionDetection.collisionAt(this, Direction.LEFT) == null &&
           !collisionDetection.collisionWall(this, Direction.LEFT))
        {
            x -= GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	private void moveRight()
    {
        if(collisionDetection.collisionAt(this, Direction.RIGHT) == null &&
           !collisionDetection.collisionWall(this, Direction.RIGHT))
        {
            x += GameController.CHARACTER_SIZE*6 * Gdx.graphics.getDeltaTime();
        }
    }
	
	
	public void moveForward()
	{
	    
	    if(facing == Direction.LEFT)
	    {
	        moveLeft();
	    }
	    else
	    {
	        moveRight();
	    }
	}
	
	public void moveBackward()
	{
	    if(facing == Direction.RIGHT)
        {
            moveLeft();
        }
        else
        {
            moveRight();
        }
	}
	
	public void update()
	{
	    if(currentAttackSpeed <= attackSpeed)
	    {
	        currentAttackSpeed += Gdx.graphics.getDeltaTime();
	    }
	}
	
	public abstract String getType(int perspectiveTeam);
	
	public HashMap<String,ArrayList<Coordinates>> getView(){
	    HashMap<String, ArrayList<Coordinates>> fieldValues = new HashMap<String, ArrayList<Coordinates>>();
		int x = this.x;
		int y = this.y;
		
		int viewTopX = 0;
        int viewTopY = 0;
        
        if(facing == Direction.RIGHT)
        {
            viewTopX = x - (int)(GameController.CHARACTER_SIZE * backView + 0.5);
            viewTopY = y + (int)(GameController.CHARACTER_SIZE * sideView + 0.5);
        }
        else
        {
            viewTopX = (int)(x - GameController.CHARACTER_SIZE * frontView + 0.5);
            viewTopY = (int)(y + GameController.CHARACTER_SIZE * sideView + 0.5); 
        }
        
		for(Entity each: GameController.entities){
			int eachX = each.getX();
			int eachY = each.getY();
			
			
			if(eachY < viewTopY && eachY > viewTopY - GameController.CHARACTER_SIZE*5){
				if (eachX > viewTopX && eachX < viewTopX + GameController.CHARACTER_SIZE*6){
					String assign = each.getType(teamNum);;	
					
					if(!fieldValues.containsKey(assign)){
						
				        ArrayList<Coordinates> temp = new ArrayList<Coordinates>();
				        temp.add(new Coordinates(eachX,eachY));
				        fieldValues.put(assign,temp);
					}
					else{
						fieldValues.get(assign).add(new Coordinates(eachX, eachY));
					}
				}	
			}
			
		}
	/**	Set keyset = fieldValues.keySet();
		System.out.println("View");
		for(Object str: keyset)
		{
		    ArrayList<Coordinates> temp = fieldValues.get(str);
		    
		    for(Coordinates cords: temp)
		    {
		        
		        System.out.println(str + " x:" + cords.getX() + " y:" + cords.getY());
		    }
		    System.out.println();
		}**/
		return fieldValues;
	}

	private class Pair<E, A>{
		public final E e;
		public final A a;
		
		public Pair(A a, E e){
			this.a = a ;
			this.e = e;
		}
	}
}
