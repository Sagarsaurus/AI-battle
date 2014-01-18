import java.awt.Graphics;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

abstract class Character extends Entity{
        boolean LIFE = true;
        int HP;
        int teamNum;
        HashMap<String, ArrayList<Coordinates>> fieldValues;
        ArrayList<Coordinates> coordinates;
        
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
	
	public HashMap<String,ArrayList<Coordinates>> getView(){
		int x = this.x;
		int y = this.y;
		for(Entity each: GameController.entities){
			int eachX = each.getX();
			int eachY = each.getY();
			
			if(eachY<y+GameController.CHARACTER_SIZE*2|y>eachY+GameController.CHARACTER_SIZE*2){	
				if (eachX<=x+GameController.CHARACTER_SIZE*4|x>eachX+GameController.CHARACTER_SIZE){
					String sample = each.toString();
					String assign = determineAssignment(sample, each);	
					
					if(!fieldValues.containsKey(assign)){
						
				        Coordinates coord = new Coordinates(eachX,eachY);						
				        fieldValues.put(assign,new ArrayList<Coordinates>());
					}
					else{
						coordinates = fieldValues.get(assign);
						Coordinates coord = new Coordinates(eachX, eachY);
						coordinates.add(coord);
						fieldValues.put(assign, coordinates);
					}
				}	
			}
			
		}
		return fieldValues;
	}
	
	public String determineAssignment(String s, Entity e){
		int at = s.indexOf("@");
		String s2 = s.substring(0, at);
		
		if (e.teamNum==1){
			if(s2.equals("Swordsman")){
				return "FS";
			}
			else if(s2.equals("Castle")){
				return "FC";
			}
			
			else if(s2.equals("Archer")){
				return "FA";
			}
		}
		else if (e.teamNum==0){
			if(s2.equals("Swordsman")){
				return "ES";
			}
			else if(s2.equals("Castle")){
				return "EC";
			}
			
			else if(s2.equals("Archer")){
				return "EA";
			}
		}
		else if(s2.equals("Rock")){
			return "W";
		}
		return "N";
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
