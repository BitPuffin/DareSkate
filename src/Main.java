import java.io.IOException;

import it.randomtower.engine.ResourceManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/*
 * @Author Isak Andersson
 * This game is totally open source
 */

public class Main extends StateBasedGame {

	public Main(String name ) {
		super( name );
		
	}

	@Override
	public
	void initStatesList( GameContainer gc ) throws SlickException {
		try {
			ResourceManager.loadResources( "media/resources.xml" );
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addState( new Area(1, gc) );
		
	}
	
	public
	static void main( String args[] ) throws SlickException{
			AppGameContainer container = new AppGameContainer( new Main( "DareSkate" ) );
			container.setDisplayMode( 800, 600, false );
			container.setTargetFrameRate( 60 );
			//container.setMaximumLogicUpdateInterval(100);
			//container.setMinimumLogicUpdateInterval(5);
			container.setIcon( "media/icon.png" );
			container.start();
	}

}
