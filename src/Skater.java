import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import it.randomtower.engine.entity.PhysicsEntity;
import it.randomtower.engine.entity.PlatformerEntity;


public class Skater extends Entity {
	
	float speed = 0.5f;
	float velocity;
	float gravity = 0.3f;
	boolean jumping;
	
	/*
	 * position += velocity;
	 * velocity -= gravity;
	 * velocity += input;
	*/

	public Skater(float x, float y) {
		super(x, y);
		Image sprite = ResourceManager.getImage("skater");
		setGraphic(sprite);
		setHitBox(10, 10, sprite.getWidth()-20, sprite.getHeight()-10);
		define("ollie", Input.KEY_UP, Input.KEY_SPACE);
	}
	
	public void update(GameContainer gc, int delta) {
		//check if the skater is colliding with the ground
		
		if(collide(SOLID, x, y)== null){
			y += delta * gravity;
			jumping = false;
			
		}
		else
			jumping = true;
		
		if(check("ollie") && collide(SOLID, x, y)!= null){
			velocity = 1000;
			jumping = true;
		}
		if(check("ollie") && collide(SOLID, x, y)==null){
			y -= delta * velocity;
			velocity = (velocity/3)*2;
		}
		
	}

}
