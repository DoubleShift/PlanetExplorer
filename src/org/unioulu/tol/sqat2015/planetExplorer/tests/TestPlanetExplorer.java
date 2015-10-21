package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	// Rule 1. The planet
	@Test
	public void test_create_planet() {
		int[][] planet_array = new int[][]{
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0}
		      
		};
		PlanetExplorer planet = new PlanetExplorer(6,6,"");
		assertArrayEquals(planet_array, planet.displayPlanet());
		
	}
	
	// Rule 7. Placing obstacles
	@Test
	public void test_create_obstacles(){
		int[][] planet_array = new int[][]{
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,1,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,1}
		      
		};
		PlanetExplorer planet = new PlanetExplorer(6,6,"(5,5)(2,2)");
		assertArrayEquals(planet_array, planet.displayPlanet());
	}
	
	
	// Rule 2.Landing
	@Test
	public void test_landing(){
		String position = "(0,0,N)";
		PlanetExplorer planet = new PlanetExplorer(6,6,"");
		assertEquals(position,planet.executeCommand(""));
	}
	
	// Rule 3.Turning
	@Test
	public void test_turning(){
		String position = "(0,0,E)";
		PlanetExplorer planet = new PlanetExplorer(6,6,"");
		assertEquals(position,planet.executeCommand("r"));
		
	}
	
	// Rule 4.Moving
	@Test
	public void test_moving(){
		String position = "(0,1,N)";
		PlanetExplorer planet = new PlanetExplorer(6,6,"");
		assertEquals(position,planet.executeCommand("f"));
	}
	
	//Rule 5.Moving and truning combined
	@Test
	public void test_truning_moving(){
		String position = "(2,2,E)";
		PlanetExplorer planet = new PlanetExplorer(6,6,"");
		assertEquals(position,planet.executeCommand("ffrff"));
	}
	
	//Rule 6. Wrapping
	// not finish, I don't understand the mapping rule
	@Test
	public void test_wrapping(){
		String position = "(5,5,N)";
		PlanetExplorer planet = new PlanetExplorer(6,6,"");
		assertEquals(position,planet.executeCommand("b"));
	}
	
	//Rule 8.Location a single obstacle
	@Test
	public void test_locating_obstacle(){
		String report = "(1,2,E)(2,2)";
		PlanetExplorer planet = new PlanetExplorer(6,6,"(2,2)");
		planet.executeCommand("ffrfff");
		assertEquals(report,planet.report());
	}
	
	//Rule 8.Location multiple  obstacles

	@Test
	public void test_locating_obstacles(){
		String report = "(1,2,E)(2,2)(2,1)";
		PlanetExplorer planet = new PlanetExplorer(6,6,"");
		planet.executeCommand("b");
		assertEquals(report,planet.report());
	}
}
