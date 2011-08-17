import org.newdawn.slick.Image;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;


public class RailEnd extends Entity {

	public RailEnd(float x, float y) {
		super(x, y);
		Image img = ResourceManager.getImage("railend");
		setGraphic(img);
		setHitBox(0, 40, img.getWidth()-40, img.getHeight()-40);
	}

}
