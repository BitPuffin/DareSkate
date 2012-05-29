import it.randomtower.engine.Camera;
import it.randomtower.engine.World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Area extends World {
	
	//The maximum height of the generated area
	int MaximumHeight = 20;
	//The width of a generated area
	int AreaWidth = 500;

	public Area( int id, GameContainer container ) {
		super( id, container );
		
	}
	
	public
	void init( GameContainer container, StateBasedGame game ) throws SlickException {
		super.init( container, game );
		generateLevel();
		
		Skater skater = new Skater( 150, 300 );
		add( skater );
		setCamera( new Camera( skater, getWidth(), getHeight() ) );
		
		for( int i = 0; i<1100; i+=100 ) {
			Ground ground = new Ground( i, 450 );
			add( ground );
		}
		for( int i = 1000; i<2500; i+=100 ) {
			Ground ground = new Ground( i, 350 );
			add( ground );
		}
		for( int i = 2400; i <= 5000; i+=100 ) {
			Ground ground = new Ground( i, 450 );
			add( ground );
		}
		for( int i = 250; i <=350; i+=100 ) {
			Ground ground = new Ground( 3000, i );
			add( ground );
		}
		
		addRail( 1600, 250, 1 );
		addRail( 3200, 350, 3);
		
		for( int i = -1050; i <=350; i+=100 ) {
			Ground ground = new Ground( 5000, i );
			add( ground );
		}
				
	}
	
	private void addRail( int startx, int y, int middles ) {
		RailStart railstart = new RailStart( startx, y );
		add( railstart );
		for ( int i = startx+100; i <= startx + 100 * middles; i += 100 ) {
			RailBody railbody = new RailBody( i, y );
			add( railbody );
		}
		
		RailEnd railend = new RailEnd( startx + 100*middles + 100, y );
		add( railend );
	}

	private
	void generateLevel() {
		//TODO Make shit
	}

}
