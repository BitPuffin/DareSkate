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
		setCamera(new Camera(skater, getWidth(), getHeight()));
		for(int i = 0; i<1100; i+=100){
			Ground ground = new Ground(i, 450);
			add(ground);
		}
		for(int i = 1000; i<2500; i+=100){
			Ground ground = new Ground(i, 350);
			add(ground);
		}
		
		RailStart railstart = new RailStart(1600, 250);
		RailBody railbody = new RailBody(1700, 250);
		RailEnd railend = new RailEnd(1800, 250);
		add(railstart);
		add(railbody);
		add(railend);
		
		
	}

	private void generateLevel() {
		
		
	}

}
