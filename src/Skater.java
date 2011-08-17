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
	private int state = FALL;
	
	float speed = 0.3f;
	float velocity;
	float gravity = 0.4f;
	boolean jumping;
	boolean lost = false;
	
	Image sprite;
	Image jump;
	
	/*
	 * position += velocity;
	 * velocity -= gravity;
	 * velocity += input;
	*/

	public Skater(float x, float y) {
		super(x, y);
		sprite = ResourceManager.getImage("skater");
		jump = ResourceManager.getImage("skaterjump");
		setGraphic(sprite);
		setHitBox(10, 10, sprite.getWidth()-20, sprite.getHeight()-10);
		define("ollie", Input.KEY_UP, Input.KEY_SPACE);
	}
	
	public void update(GameContainer gc, int delta) {
		//check if the skater is colliding with the ground
		if(lost == false)
		x += (speed * delta);
		
		switch(state) {
        	case FALL:
        		setGraphic(jump);
                if(collide(SOLID, x, y)!= null){
                        state = GROUND;
                }
                else{
                	state = FALL;
                	if(check("ollie")){
                		gravity = 0.4f;
                	}
                	else{
                		if(gravity <= 0.8){
                			gravity+= 0.01;
                		}
                	}
                	y -= velocity;
                	velocity -= gravity;
                }
                break;

        	case GROUND:
        		setGraphic(sprite);
        		gravity=0;
                if(check("ollie")){
                        state = JUMP;
                }
                if(collide(SOLID, x, y)== null)
                	state = FALL;
                
                break;
                
        	case JUMP:
        		setGraphic(jump);
        		y-=10;
        		velocity = 10;
        		
        		state = FALL;
        		break;
		}
		
			if (collide(SOLID, x+1, y-30)!= null){
				lost = true;
			}
		
	}

}
