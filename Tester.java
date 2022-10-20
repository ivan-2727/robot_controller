import java.util.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class Tester {

	@Test(expected = Exception.class)
	public void test_Check() throws Exception {        
		Robot robot = new Robot(new int[] {1,1}, new int[] {2,2}, 0, false); 
	}
	
	@Test
	public void test_Move() throws Exception {   
		Robot robot = new Robot(new int[] {5,5}, new int[] {1,2}, 0, false); 
		robot.Move("RFRFFRFRF"); 
		assertArrayEquals(robot.pos, new int[]{1,3}); 
		assertEquals(robot.dir, 0); 
		robot = new Robot(new int[] {5,5}, new int[] {0,0}, 1, false); 
		robot.Move("RFLFFLRF"); 
		assertArrayEquals(robot.pos, new int[]{3,1}); 
		assertEquals(robot.dir, 1); 
	}
	
	@Test(expected = Exception.class)
	public void test_WallsBreak() throws Exception {
		Robot robot = new Robot(new int[] {2,2}, new int[] {0,0}, 0, true); 
		robot.Move("FFF");
	}
	
	@Test 
	public void test_WallsDontBreak() throws Exception {
		Robot robot = new Robot(new int[] {2,2}, new int[] {0,0}, 0, false); 
		robot.Move("FFF");
		assertArrayEquals(robot.pos, new int[]{0,0}); 
		assertEquals(robot.dir, 0); 
	}
	
} 
