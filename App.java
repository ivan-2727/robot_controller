import java.util.*;
import java.util.List; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {
	
	public static List<JTextField> space = new ArrayList<>(); 
		
	public static String evaluate() throws Exception {
		
		Robot robot = new Robot(); 
		
		String[] splitted = space.get(0).getText().split("\\s+");
		if (splitted.length != 2) throw new Exception("Invalid input"); 
		for (int j = 0; j < 2; j++) robot.field[j] = Integer.parseInt(splitted[j]);
		
		splitted = space.get(1).getText().split("\\s+");
		if (splitted.length != 3) throw new Exception("Invalid input"); 
		for (int j = 0; j < 2; j++) robot.pos[j] = Integer.parseInt(splitted[j]);
		if (splitted[2].equals("N")) robot.dir = 0;
		else if (splitted[2].equals("E")) robot.dir = 1;
		else if (splitted[2].equals("S")) robot.dir = 2;
		else if (splitted[2].equals("W")) robot.dir = 3;
		else throw new Exception("Invalid input"); 
		robot.Move(space.get(2).getText()); 
		
		String res = "Position of robot: ";
		res += Integer.toString(robot.pos[0]) + " ";
		res += Integer.toString(robot.pos[1]) + " ";
		if (robot.dir == 0) res += "N"; 
		else if (robot.dir == 1) res += "E"; 
		else if (robot.dir == 2) res += "S"; 
		else if (robot.dir == 3) res += "W"; 
		return res; 
	}
		
	public static JPanel makePanel() {
        JPanel panel = new JPanel();
        		
		List<JLabel> label = new ArrayList<>();
		Font font = new Font("Arial", Font.PLAIN, 18); 
		for (String name : new String[]{"Field size", "Starting position", "Command"}) {
			label.add(new JLabel(name)); 
			space.add(new JTextField()); 
			label.get(label.size()-1).setFont(font); 
			space.get(space.size()-1).setFont(font); 
		}
		
		JButton submit = new JButton("Submit");
        submit.setFont(font);
        submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane answer = new JOptionPane();  
				JLabel label = new JLabel();
				label.setFont(font);
				answer.add(label);
                try {
					label.setText(evaluate());
					answer.showMessageDialog(null, label);
				}
				catch (Exception exc) {
					label.setText(exc.getMessage());
					answer.showMessageDialog(null, label);
				}
            }
        });

		for (int i = 0; i <= 2; i++) {
			panel.add(label.get(i));
			panel.add(space.get(i)); 
		}
		panel.add(submit); 

        return panel; 
	}
	
	public static void main(String[] arg) throws Exception {
		JFrame frame = new JFrame("Rooms manager");
        JPanel panel = makePanel(); 
        frame.add(panel);         
        panel.setLayout(new GridLayout(10,1));
        frame.setContentPane(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}