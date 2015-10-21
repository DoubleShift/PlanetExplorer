package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

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
		PlanetExplorer planet = new PlanetExplorer(6,6,"(5,5)(2,2)");
		assertArrayEquals(planet_array, planet.displayPlanet());
		
	}
}
