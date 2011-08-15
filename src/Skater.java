import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import it.randomtower.engine.entity.PhysicsEntity;
import it.randomtower.engine.entity.PlatformerEntity;


public class Skater extends Entity {
	
	
	
	int TheWorldId = 1;
	
	private final int GROUND = 0;
	private final int JUMP = 1;
	private final int FALL = 2;
	private int state;
	
	float speed = 0.5f;
	float velocity;
	float gravity = 0.4f;
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
		x++;
		if(collide(SOLID, x, y)!= null){
			state = GROUND;
		}
		else
			state = FALL;
		
		switch(state) {
        	case FALL:
                if(collide(SOLID, x, y)!= null){
                        state = GROUND;
                }
                else
                	y -= velocity;
                	velocity -= gravity;
        			
                break;

        	case GROUND:                    
                if(check("ollie")){
                        state = JUMP;
                }
                break;
                
        	case JUMP:
        		velocity = 10;
        		break;
		}
		
		
	}

}
