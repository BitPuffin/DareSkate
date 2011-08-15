import org.newdawn.slick.GameContainer;

import it.randomtower.engine.World;

/*
 * The World is supposed to manage all the things for me
 * sort of like the way a server would.
 * 
 * Therefore all of my MarteEngine "Worlds" should extend
 * TheWorld and not MarteEngine. That is, if I'll even have 
 * more "Worlds"
 * 
 * Oh and by the way, Worlds are the same things as States!
 * 
 * TheWorld will be able to access every class except the Main class.
 */


public class TheWorld  {
	
	Area area;
	

	public TheWorld(int id, GameContainer container) {
		area = new Area(id, container);
		
	}

}
