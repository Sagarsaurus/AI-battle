import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
   public static void main(String[] args) {
      LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
      cfg.title = "AI Battle";
      cfg.width = AIBattle.CHARACTER_SIZE * 30;
      cfg.height = AIBattle.CHARACTER_SIZE * 20;
      new LwjglApplication(new AIBattle(), cfg);
   }
}