package org.unioulu.tol.sqat2015.planetExplorer;

import static org.junit.Assert.assertArrayEquals;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] planet_array = new int[][]{
		      {0,0,0,0,0,1},
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,1,0,0,0},
		      {0,0,0,0,0,0},
		      {0,0,0,0,0,0}
		      
		};
		PlanetExplorer planet = new PlanetExplorer(6,6,"(5,5)(2,2)");
	}

}
