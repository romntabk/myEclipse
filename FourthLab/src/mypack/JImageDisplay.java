package mypack;
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;


class JImageDisplay extends JComponent
{
	private BufferedImage image;
	public JImageDisplay(int width, int height) {
		image = new BufferedImage(width, height,
	    BufferedImage.TYPE_INT_RGB);
	    Dimension dimension = new Dimension(width, height);
	    super.setPreferredSize(dimension); 
	} 
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image, 0, 0, image.getWidth(),image.getHeight(), null);
	}
	public void clearImage() {
		image.setRGB(0, 0, getWidth(), getHeight(), new int[getWidth()*getHeight()], 0, 1);
	}
	//draw pixel at x,y in color rgbColor
	public void drawPixel(int x, int y, int rgbColor) {
		image.setRGB(x, y, rgbColor);
	}
}
