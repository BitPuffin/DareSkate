import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import it.randomtower.engine.entity.PhysicsEntity;
import it.randomtower.engine.entity.PlatformerEntity;

public class Skater extends Entity {

	int TheWorldId = 1;

	private final int GROUND = 0;
	private final int JUMP = 1;
	private final int FALL = 2;
	private final int GRIND = 3;
	private int state = FALL;

	float vx = 0.4f;
	float maxspeed = 0.84f;
	float vy;
	final float gravity = 0.03f;
	final float grindacc = 0.001f;
	float startx;
	float starty;
	boolean jumping;
	boolean lost = false;
	boolean canhover = false;
	boolean jumped = false;
	boolean canrestart = false;
	Image sprite;
	Image jump;

	/*
	 * position += velocity; velocity -= gravity; velocity += input;
	 */

	public Skater( float x, float y ) throws SlickException {
		super( x, y );
		startx = x;
		starty = y;
		sprite = ResourceManager.getImage( "skater" );
		// jump = ResourceManager.getImage( "skaterjump.png "); This fails for some reason
		jump = new Image("media/skater/skaterjump.png");
		setGraphic( sprite );
		setHitBox( 10, 10, sprite.getWidth() - 20, sprite.getHeight() - 10 );
		define( "ollie", Input.KEY_UP, Input.KEY_SPACE );
		define( "restart", Input.KEY_ENTER );
	}

	public
	void update( GameContainer gc, int delta ) throws SlickException {
		// check if the skater is colliding with the ground
		if ( lost == false )
			x += ( vx * delta );

		switch ( state ) {
		case FALL:
			if ( collide(SOLID, x, y) != null ) {
				state = GROUND;
				setGraphic( sprite );
				canrestart = true;
			} else if ( collide("railbody", x, y ) != null
					|| collide( "railend", x, y ) != null) {
				state = GRIND;
			} else {
				state = FALL;
				if ( check("ollie") && canhover == true ) {
					vy += 0.011;
				} else {
					canhover = false;
				}
				y -= ( vy * delta );
				vy -= gravity;
			}
			if ( collide( "railstart", x + 2, y - 10 ) != null ) {
				lost = true;
			}
			if ( collide( "railstart", x, y + 1 ) != null ) {
				state = GRIND;
			}
			break;

		case GROUND:
			// Make sure that the skater isn't buried in the ground
			while ( collide( SOLID, x, y - 2 ) != null ) {
				y--;
			}
			
			vy = 0;
			if ( check( "ollie" ) ) {
				state = JUMP;
				
				//Fails to find jump..
				setGraphic( jump );
			}
			if ( collide( SOLID, x+3, y ) == null ) {
				state = FALL;
			}
			if ( collide( "railstart", x + 2, y ) != null ) {
				lost = true;
			}
			if ( collide( SOLID, x + 5, y - 10 ) != null ) {
				lost = true;
			}
			break;

		case JUMP:
			canhover = true;
			jumped = true;
			y -= 10;
			vy = 0.6f;

			state = FALL;
			break;

		case GRIND:
			while ( collide( "raildbody", x, y - 1 ) != null
					|| collide( "railend", x, y ) != null ) {
				y--;
			}
			if( vx <= maxspeed ){
			vx += ( grindacc * delta );
			}

			if ( collide( "railbody", x, y ) == null
					|| collide( "railend", x, y ) == null ) {
				vy = 0;
				state = FALL;
			}

			if ( check( "ollie" ) ) {
				state = JUMP;
			}

			break;
		}

		if ( collide( SOLID, x + 1, y - 15 ) != null ) {
			lost = true;
		}
		
		if( check( "restart" ) ){
			if ( canrestart ){
			x = startx-50;
			y = starty-50;
			vx = 0.4f;
			lost = false;
			canrestart = false;
			}
		}

	}

	@Override
	public
	void render( GameContainer gc, Graphics g ) throws SlickException {
		super.render( gc, g );
		if( jumped == false ){
		g.drawString( "Space or up to jump", x - 200, y - 100 );
		}
		if ( lost ) {
			g.drawString( "You Lose!, press enter to restart!", x, y - 200 );
		}
	}

}
