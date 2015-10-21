package org.unioulu.tol.sqat2015.planetExplorer;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:101
// Finish time:
public class PlanetExplorer {
	
	// 0: white space
	// 1: obstacle
	// 2: explorer
	private int[][] planet_array;
	
	
	// (0,0,N) when landing
	private int x = 0;
	private int y = 0;
	
	// explorer current direction
	// 0: N
	// 1: E
	// 2: S
	// 3: W
	private int direct = 0;
	
	private String[] direction = {"N","E","S","W"};
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		planet_array = new int[x][y];
		for (int[] row: planet_array)
		    Arrays.fill(row, 0);
		
		this._setObstacles(obstacles);
	}
	
	
	private void _setObstacles(String obstacles){
		if (obstacles != ""){
		obstacles = obstacles.replaceAll("\\)\\(",",");
		obstacles =	obstacles.replaceAll("\\)","");
		obstacles =	obstacles.replaceAll("\\(","");

		String[] parts = obstacles.split(Pattern.quote(",")); 
			for(int i =0;i<parts.length;i=i+2){
				int x = Integer.parseInt(parts[i]);
				int y = Integer.parseInt(parts[i+1]);
				this.planet_array[x][y] = 1;
			}
		}

                
   
	}
	
	
	public int[][] displayPlanet(){
		return planet_array;
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		if(command == ""){
			return this._getPosition();
		}
		
		
		char[] command_array = command.toCharArray();
		int len = command_array.length;
		for(int i =0;i<len;i++){
			switch(command_array[i]){
				case 'l':
					this._turnLeft();
					break;
				case 'r':
					this._turnRight();
					break;
				case 'f':
					this._forward();
					break;
				case 'b':
					this._back();
					break;
			}
			
		}
		
		return this._getPosition();
	}
	
	private void _forward(){
		switch(this.direct){
			case 0://North
				this.y+=1;
				break;
			case 1://South
				this.y-=1;
				break;		
			case 2://West
				this.x-=1;
				break;		
			case 3://East
				this.x+=1;
				break;
		}
	}
	
	private void _back(){
		switch(this.direct){
			case 0://North
				this.y-=1;
				break;
			case 1://South
				this.y+=1;
				break;		
			case 2://West
				this.x+=1;
				break;		
			case 3://East
				this.x-=1;
				break;
		}
		
	}
	
	private void _turnLeft(){
		if(this.direct == 0){
			this.direct = 3;
		}else{
			this.direct-=1;
		}
	}
	
	private void _turnRight(){
		if(this.direct == 3){
			this.direct = 0;
		}else{
			this.direct+=1;
		}
	}
	
	private String _getPosition(){
		return "(0,0,"+this.direction[this.direct]+")";
	}
}
