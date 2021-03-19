package mypack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FractalExplorer{
	private int size;
	private JImageDisplay jImageDisplay;
	private FractalGenerator fractalGenerator;
	private Rectangle2D.Double complexRange;
	public FractalExplorer(int size) {
		this.size=size;
		jImageDisplay = new JImageDisplay(size,size);
		fractalGenerator = new MandelbrotFractal();
		complexRange = new Rectangle2D.Double();
		fractalGenerator.getInitialRange(complexRange);
	}
	public String[] items = {"Mandelbrot","Burning Ship", "Tricorn"};
	public void createAndShowGUI() {
		jImageDisplay.setLayout(new BorderLayout());
		
		JFrame jFrame = new JFrame("Fractals");
		JButton buttonReset = new JButton("Reset");
		JButton buttonSave = new JButton("Save");
		JComboBox comboBox = new JComboBox(items);
		JPanel panelBottom = new JPanel();
		JPanel panelTop= new JPanel();
		JLabel label = new JLabel("Выберите фрактал:");
		
		panelBottom.add(buttonSave);
		panelBottom.add(buttonReset);
		panelTop.add(label);
		panelTop.add(comboBox);

		jFrame.add(jImageDisplay,BorderLayout.CENTER);
		jFrame.add(panelTop,BorderLayout.NORTH);
		jFrame.add(panelBottom,BorderLayout.SOUTH);
		
		
		jImageDisplay.addMouseListener(new MouseHandler());	
		buttonReset.addActionListener(new buttonResetHandler());
		buttonSave.addActionListener(new buttonSaveHandler());
		comboBox.addActionListener(new comboBoxHandler());
		
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
	class comboBoxHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JComboBox combo = (JComboBox)e.getSource();
			String nameFractal = (String)combo.getSelectedItem();
			if(nameFractal=="Mandelbrot") {
				fractalGenerator=new MandelbrotFractal();
			}
			if(nameFractal=="Burning Ship") {
				fractalGenerator= new BurningShipFractal();
			}
			if(nameFractal=="Tricorn") {
				fractalGenerator= new TricornFractal();
			}
			fractalGenerator.getInitialRange(complexRange);
			drawFractal();
		}
		
	}
	class buttonResetHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fractalGenerator.getInitialRange(complexRange);
			drawFractal();
		}	
	}
	class buttonSaveHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
			chooser.setFileFilter(filter);
			chooser.setAcceptAllFileFilterUsed(false);
			
			int result = chooser.showSaveDialog(jImageDisplay);
			if(result==JFileChooser.APPROVE_OPTION) {
				try {
					ImageIO.write(jImageDisplay.image, "png",chooser.getSelectedFile());
				}catch(Exception exception) {
					JOptionPane.showMessageDialog(chooser, exception.getMessage(),"Произошла ошибка", JOptionPane.ERROR_MESSAGE);
				}
			}
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
