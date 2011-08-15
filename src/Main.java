import java.io.IOException;

import it.randomtower.engine.ResourceManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Main extends StateBasedGame {
	
	int TheWorldId = 1;

	public Main(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		try {
			ResourceManager.loadResources("media/resources.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addState(new Area(TheWorldId, gc));
		
	}
	
	public static void main(String args[]) throws SlickException{
		try {
			AppGameContainer container = new AppGameContainer(new Main("DareSkate"));
			container.setDisplayMode(800, 600, false);
			container.setTargetFrameRate(60);
			container.setMaximumLogicUpdateInterval(100);
			container.setMinimumLogicUpdateInterval(10);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
