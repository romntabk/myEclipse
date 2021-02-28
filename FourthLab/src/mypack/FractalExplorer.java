package mypack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		buttonReset.addActionListener(new buttonResetHandler());
		buttonReset.setVisible(true);
		jFrame.add(buttonReset,BorderLayout.NORTH);
		jImageDisplay.addMouseListener(new MouseHandler());	
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);
	}
	public void drawFractal()
	{
		for (int x=0; x<size; ++x){
			for (int y=0; y<size; ++y){        
				double xCoord = FractalGenerator.getCoord(complexRange.x, complexRange.x + complexRange.width, size, x);
				double yCoord = FractalGenerator.getCoord(complexRange.y, complexRange.y + complexRange.height, size, y);  	
				//System.out.println(xCoord+ " " +yCoord);
				int iter = fractalGenerator.numIterations(xCoord, yCoord);
				if (iter < 0) {
					jImageDisplay.drawPixel(x, y, 0);
					continue;
				}
				float hue = 0.7f + (float) iter / 200f;
				int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
				jImageDisplay.drawPixel(x, y, rgbColor);
			}
		}
		jImageDisplay.repaint();
	}
	class buttonResetHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			fractalGenerator.getInitialRange(complexRange);
			drawFractal();
		}	
	}
	class MouseHandler extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			double x = FractalGenerator.getCoord(complexRange.x, complexRange.x+complexRange.width, size, e.getX());
			double y = FractalGenerator.getCoord(complexRange.y, complexRange.y+complexRange.height, size, e.getY());
			fractalGenerator.recenterAndZoomRange(complexRange, x, y, 0.5);
			drawFractal();
		}
	}

}
