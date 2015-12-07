package ballBounceWithThreads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;

public class BounceFrame extends JFrame {

    private JPanel canvas;
    private JButton startButton;
    private JButton closeButton;
    private JButton stopLastButton;
    private JButton stopFirstButton;
    private JButton stopAllButton;
    
    public BounceFrame() {
        setSize(300, 200);
        setTitle("Bounce");
        canvas = new JPanel();
        add(canvas, "Center");

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        closeButton = new JButton("Close");
        stopLastButton = new JButton("Stop Last");
        stopFirstButton = new JButton("Stop First");
        stopAllButton = new JButton("Stop All");

        buttonPanel.add(startButton);
        buttonPanel.add(closeButton);
        buttonPanel.add(stopFirstButton);
        buttonPanel.add(stopLastButton);
        buttonPanel.add(stopAllButton);

        ButtonHandler handler = new ButtonHandler();

        startButton.addActionListener(handler);
        closeButton.addActionListener(handler);
        stopLastButton.addActionListener(handler);
        stopFirstButton.addActionListener(handler);
        stopAllButton.addActionListener(handler);
                

        add(buttonPanel, "South");
    }

    private class ButtonHandler implements ActionListener {
        Ball r1;
        LinkedList<Ball> myBalls = new LinkedList<Ball>();
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == startButton) {
                r1 = new Ball(canvas);
                myBalls.add(r1);
                Thread t1 = new Thread(r1);
                t1.start();
            } else if (event.getSource() == closeButton) {
                System.exit(0);
            } else if (event.getSource() == stopAllButton) {
                for(Ball b: myBalls)
                {
                    Ball tempBall = b;
                    tempBall.stop();   
                }   
            } else if (event.getSource() == stopFirstButton) {
                Ball tempBall = myBalls.removeFirst();// stop first ball
                tempBall.stop();
            } else if (event.getSource() == stopLastButton) {
                Ball tempBall = myBalls.removeLast();// stop first ball
                tempBall.stop();
            }
        }
    }
}
