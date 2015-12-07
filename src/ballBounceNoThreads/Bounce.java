package ballBounceNoThreads;

//This class does not use a thread for the ball
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bounce {
	public static void main(String[] args){
		BounceFrame frame = new BounceFrame();
		frame.setVisible(true);
           frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}

