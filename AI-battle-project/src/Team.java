import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Team {
    
    Character characters[];
    Castle castle;
    int size;
    
    public Team(int numSwordsman, int numArchers)
    {
        size = numSwordsman + numArchers;
        characters = new Character[size];
        int y = 0;
        for(int i = 0; i < numSwordsman; i++)
        {
            characters[i] = new Swordsman(0,y);
            y += AIBattle.CHARACTER_SIZE;
        }
        
        castle = new Castle(0,AIBattle.CHARACTER_SIZE * 10);
    }
    
    public void draw(SpriteBatch batch)
    {
        for(int i = 0; i < size; i++)
        {
            characters[i].draw(batch);
        }
        castle.draw(batch);
    }
    
    
}
