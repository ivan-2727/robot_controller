### Robot controller 

Compile: `javac Robot.java App.java -classpath ".;junit-4.10.jar" Tester.java`

Run test: `java -classpath ".;junit-4.10.jar" org.junit.runner.JUnitCore Tester` 

Run app: `java App`

In the window, provide data on the robot movement in the same format as in the assignment (for example, `5 5`, `1 2 N`, `RFRFFRFRF`). Submit by pressing the button. You should get a popup window with the answer. 

##### The question with boundaries
In the task, it is not specified whether or not the robot "breaks" when trying to get outside of the field boundaries. The Robot class can handle both situations, and there are simple tests for both in the Test class. The GUI (class App) assumes assumes that the robot will just stop when reaching a wall (no exception in that case) until given a command to move in another direction.  
 
