import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Team {
    Character characters[];
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
    }
    
    public void draw(SpriteBatch batch)
    {
        for(int i = 0; i < size; i++)
        {
            characters[i].draw(batch);
        }
    }
    
    
}
