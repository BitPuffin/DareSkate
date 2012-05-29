package unrelated;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ShowThatICanUseListAndFileIO {
	
	/*
	 * Just to show that I can use this stuff
	 */
	
	private String filename = "FILEOFNUMBERS.md";
	
	private ArrayList< Integer > 	randomNums;
	private LinkedList< Integer > 	readList;	//	Silly to use Linked list in this case but it's just to show that I know that they can be used
	private PrintWriter				writer;
	Scanner mrScanner;
	
	
	public ShowThatICanUseListAndFileIO() {
		randomNums = new ArrayList< Integer >();
		readList = new LinkedList< Integer >();
		
		try {
			writer = new PrintWriter( new BufferedWriter( new FileWriter( filename, false ) ) ); // Gotta love markdown
			mrScanner = new Scanner( new File( filename ) );
		}	catch ( IOException e ) {
			e.printStackTrace();
			System.exit( -1 ); 	// Program did not succeed
		}
		
	}
	
	public
	void start() {
		randomNums = addRandomNumbersToAnIntegerList( randomNums, 10 );
		Collections.sort( randomNums );
		printIntegerListToTheFile( randomNums );
		readNumbersIntoTheLinkedList();
		lookFor1337();
	}
	
	private
	ArrayList<Integer> addRandomNumbersToAnIntegerList( ArrayList< Integer > list, int howmany ) {
		
		Random rand = new Random();
		
		for ( int i = 0; i < howmany; i++ ) {
			list.add( i, rand.nextInt( 20 ) + 1325 );
		}
		
		return list;
	}
	
	private
	void printIntegerListToTheFile( ArrayList< Integer > list ) {
		
		String text = "Our text file!";
		writer.println(text);
		
		for( int i=0; i<text.length(); i++ ) {
			writer.print("=");
		}
		writer.println();
		writer.println();
		
		for( int i = 0; i < list.size(); i++) {
			writer.println( "* " + list.get( i ) );	// Markdown syntax!!
		}
		
		writer.close();	//EASY TO FORGET
		
	}
	
	private
	void readNumbersIntoTheLinkedList() {
		mrScanner.reset();	// Reset the scanner in case it has read before
		readList.clear();	// Clear the list so it's empty
		
		mrScanner.reset();
		
		//	TODO ASK KARL WHY THIS SHIT DOESN'T WORK
		while( mrScanner.hasNext() ) {
			if ( mrScanner.hasNextInt() ){
				readList.add( mrScanner.nextInt() );	// Hurray!
			}
			else {
				mrScanner.next();
			}
		}
		
		// DEBUG Print list
		System.out.println("printing");
		for ( int i = 0; i < readList.size(); i++ ){ 
			System.out.println( readList.get( i ) );
		}
	}
	
	private
	void lookFor1337() {
		boolean found = false;	// For readability
		int index = -1;
//		for( int i = 0; i < readList.size(); i++ ) {	// Linear search because it's a linked list
//			if ( readList.get(i) == 1337 ) {
//				index = i;
//				found = true;
//			}
//		}
		
		index = Collections.binarySearch( readList, 1337 );
		found = index > 0;
		
		if ( !found ) {
			JOptionPane.showMessageDialog( null, "Fuck this shit, 1337 wasn't generated" );
		}
		else {
			JOptionPane.showMessageDialog( null, "Fuck yes, an instance of 1337 found at index #" + index +" possibly at other indices as well but that's unlikely");
		}
	}
	
	public
	static void main( String args[] ) {
		ShowThatICanUseListAndFileIO program = new ShowThatICanUseListAndFileIO();
		program.start();
	}

}
