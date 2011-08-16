import it.randomtower.engine.Camera;
import it.randomtower.engine.World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Area extends World {
	
	//The maximum height of the generated area
	int MaximumHeight = 20;
	//The width of a generated area
	int AreaWidth = 500;

	public Area(int id, GameContainer container) {
		super(id, container);
		
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException{
		super.init(container, game);
		
		generateLevel();
		
		Skater skater = new Skater(150, 300);
		add(skater);
		Camera camera = new Camera(skater, container.getWidth(), container.getHeight());
		for(int i = 0; i<500; i+=100){
			Ground ground = new Ground(i, 450);
			add(ground);
		}
		Ground g = new Ground(500, 350);
		Ground f = new Ground(600, 350);
		Ground a = new Ground(400, 350);
		add(g);
		add(a);
		add(f);
		
	}

	private void generateLevel() {
		
		
	}

}
