import java.awt.Graphics;
import java.util.Random;

public class Character{
	protected int x;
	protected int y;
	int yChange;
	boolean LIFE = true;
	
	public Character(){
		Random randX = new Random();
		Random randY = new Random();
		x = randX.nextInt(500);
		y = randY.nextInt(500);
	}
	
	public Character(int newX, int newY){
		x=newX;
		y=newY;
	}
	
	public void draw(Graphics g){
		
	}
}
