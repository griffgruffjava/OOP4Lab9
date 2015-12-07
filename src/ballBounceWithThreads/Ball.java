package ballBounceWithThreads;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Ball implements Runnable
{  
	private JPanel panel;
	private Color color = Color.BLACK;
	private final int XSIZE = 10;
	private final int YSIZE = 10;
	private int x = 0;
	private int y = 0;
	private int dx = 2;
	private int dy = 2;
        private boolean stayBouncing=true;
	
	public Ball(JPanel p) {
		panel = p;
	}
        
        public Ball(JPanel p,boolean stayBouncing) {
		panel = p;
                this.stayBouncing = stayBouncing;
	}

	public void draw(){
		Graphics g = panel.getGraphics();
		g.fillOval(x, y, XSIZE, YSIZE);
		g.dispose();
	}
	
	public void move(){
		Graphics g = panel.getGraphics();
		Color c = panel.getBackground();
		g.setColor(c);
		g.fillOval(x, y, XSIZE, YSIZE);
		
		//update ball coordinates for redrawing
		x += dx;
		y += dy;
		Dimension d = panel.getSize();
		if (x < 0){
			x = 0;
			dx = -dx;
		}
		if (x + XSIZE >= d.width){
			x = d.width - XSIZE;
			dx = -dx;
		}
		if (y < 0){
			y = 0;
			dy = -dy;
		}
		if (y + YSIZE >= d.height){
			y = d.height - YSIZE; 
			dy = -dy;
		}
		
		g.setColor(color);
		g.fillOval(x, y, XSIZE, YSIZE);
		g.dispose();
	}
	
	public void run(){
		draw();
		//for (int i = 1; i <= 1000; i++){
           while (stayBouncing) {
			move();
			try { 
                            Thread.sleep(10);
                        }                   
			catch(InterruptedException e) {}
		}
	}
        
        public void stop()
        {
            stayBouncing=false;
        }
        
        
}

