import org.newdawn.slick.Image;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;


public class RailBody extends Entity {

	public RailBody(float x, float y) {
		super(x, y);
		Image img = ResourceManager.getImage("railbody");
		setGraphic(img);
		setHitBox(0, 40, img.getWidth(), 20);
		addType("railbody");
	}

}
