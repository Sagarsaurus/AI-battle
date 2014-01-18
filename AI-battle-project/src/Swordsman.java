import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Swordsman extends Character{
	boolean LIFE = true;
	Texture texture;
	Sprite sprite;
	int HP;
	
	public Swordsman(){
		texture = new Texture(Gdx.files.internal("assets/swordsman.png"));
		sprite = new Sprite(texture, 0, 0, 32, 32);
		HP = 1;
	}
	
	public void draw(SpriteBatch batch){
			
			sprite.setPosition(100, 100);
			sprite.draw(batch);
		}
	
	public boolean canMove(int direction){
		return true;
	}
	
	public boolean isDead(int hp){
		return HP==0;
	}
	
	public int returnHP(int isStruck){
		if (isStruck==1){
			HP-=1;
			if (HP==1){
				sprite.setColor(1,0,0,0);
			}
		}
		return HP;
	}
}
