package mypack;

public class FractalApp {

	public static void main(String[] args) {
		FractalExplorer fractalExplorer = new FractalExplorer(600);
		fractalExplorer.createAndShowGUI();
		fractalExplorer.drawFractal();
	}

}
