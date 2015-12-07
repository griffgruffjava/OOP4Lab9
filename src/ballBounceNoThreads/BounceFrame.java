package ballBounceNoThreads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BounceFrame extends JFrame
{  
	private JPanel canvas;
	private JButton startButton;
	private JButton closeButton;
	private Ball ball;
	
	public BounceFrame(){
		setSize(300, 200);
		setTitle("Bounce");
		canvas = new JPanel();
		add(canvas, "Center");
                
         	JPanel buttonPanel = new JPanel();
           startButton = new JButton("Start");
           closeButton = new JButton("Close");

		buttonPanel.add(startButton);
		buttonPanel.add(closeButton);

		ButtonHandler handler = new ButtonHandler();
                
       	startButton.addActionListener(handler);
        	closeButton.addActionListener(handler);
                
         	add(buttonPanel, "South");
	}
	
	private class ButtonHandler implements ActionListener{
	   public void actionPerformed( ActionEvent event )
	   {
		   if (event.getSource() == startButton) {
			   ball = new Ball(canvas);
			   ball.bounce();
		   }
              else if (event.getSource() == closeButton) {
                       System.exit(0);
              }
        }
	}
}