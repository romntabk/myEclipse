package mypack;

import java.awt.BorderLayout;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FractalExplorer{
	private int size;
	private JImageDisplay jImageDisplay;
	private FractalGenerator fractalGenerator;
	private Rectangle2D.Double complexRange;
	public FractalExplorer(int size) {
		this.size=size;
		jImageDisplay = new JImageDisplay(size,size);
		fractalGenerator = new Mandelbrot();
		complexRange = new Rectangle2D.Double();
		fractalGenerator.getInitialRange(complexRange);
	}
	public void createAndShowGUI() {
		jImageDisplay.setLayout(new BorderLayout());
		JFrame jFrame = new JFrame("Fractals");
		jFrame.add(jImageDisplay,BorderLayout.CENTER);
		JButton buttonReset = new JButton("Reset");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);
	}
	private void drawFractal()
	{
		for (int x=0; x<size; x++){
			for (int y=0; y<size; y++){        
				double xCoord = fractalGenerator.getCoord(complexRange.x, complexRange.x + complexRange.width, size, x);
				double yCoord = fractalGenerator.getCoord(complexRange.y, complexRange.y + complexRange.height, size, y);
				int iteration = fractal.numIterations(xCoord, yCoord);    
				if (iteration == -1){
					display.drawPixel(x, y, 0);
				}    
				else {
					float hue = 0.7f + (float) iteration / 200f;
					int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
	                
	                    /** Update the display with the color for each pixel. */
	                    display.drawPixel(x, y, rgbColor);
	                }
	                
	            }
	        }
	      
	        jImageDisplay.repaint();
	    }


}
