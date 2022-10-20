import java.util.*;

public class Robot {
	public int[] field; 
	public int[] pos; //pos[0] = x, pos[1] = y, 0-based
	public int dir; //north = 0, east = 1, south = 2, west = 3
	public boolean wallsBreak; //true if robot breaks (throws exception) after trying to penetrate a wall
	
	public void Check(boolean start) throws Exception {
		if (wallsBreak || start) {
			if (pos[0] >= field[0] || pos[1] >= field[1] || pos[0]<0 || pos[1]<0) throw new Exception("Invalid coordinates or field size"); 
		}
		else {
			for (int j = 0; j < 2; j++) {
				if (pos[j] >= field[j]) pos[j] = field[j]-1;
				if (pos[j] < 0) pos[j] = 0;
			}				
		}
	}
	
	public Robot() {
		this.field = new int[2]; 
		this.pos = new int[2];
		this.wallsBreak = false; 
	}
	
	public Robot(int[] field, int[] pos, int dir, boolean wallsBreak) throws Exception {
		this.field = field; 
		this.pos = pos;
		this.dir = dir; 
		this.wallsBreak = wallsBreak; 
		Check(true); 
	}
	
	public void Move(String command) throws Exception {
		Check(true); 
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'L') dir = ((dir-1)%4 + 4)%4;
			else if (command.charAt(i) == 'R') dir = (dir+1)%4;
			else if (command.charAt(i) == 'F') pos[1-dir%2] += (dir==1 || dir==2 ? 1 : -1);  
			else throw new Exception("Invalid symbol in command");
			Check(false); 
		}
	}

}