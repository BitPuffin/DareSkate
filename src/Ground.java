import org.newdawn.slick.Image;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;
import it.randomtower.engine.entity.PhysicsEntity;


public class Ground extends Entity {
	
	// Just the ground you know

	public Ground( float x, float y ) {
		super( x, y );
		Image sprite = ResourceManager.getImage( "ground" );
		setGraphic( sprite );
		setHitBox( 0, 0, sprite.getWidth(), sprite.getHeight() );
		addType( SOLID );
	}

}
