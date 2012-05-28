import org.newdawn.slick.Image;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.entity.Entity;


public class RailStart extends Entity {
	
	// The Start of a rail

	public RailStart( float x, float y ) {
		super( x, y );
		Image img = ResourceManager.getImage( "railstart" );
		setGraphic( img );
		setHitBox( 40, 40, img.getWidth()-40, img.getHeight()-40 );
		addType( "railstart" );
		
	}

}
