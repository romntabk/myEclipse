package mypack;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class MandelbrotFractal extends FractalGenerator {
	public static final int MAX_ITERATIONS = 2000;

	@Override
	public void getInitialRange(Rectangle2D.Double neponyal) {
	     neponyal.width = 3;
	     neponyal.height = 3;
	     neponyal.y = -1.5;
	     neponyal.x = -2;
	}
	@Override
	public int numIterations(double x, double y) {
		// 0 0 
		// 0.995  -0.6
		// 
		int countIterations=0;
		ComplexNumber complexNumber= new ComplexNumber(0,0);
		ComplexNumber complexNumberBefore;
		ComplexNumber complexNumberConst= new ComplexNumber(x,y);
		//System.out.print(countIterations);	
		while(complexNumber.lenPow2()<4) {
			if(countIterations++==MAX_ITERATIONS)
				return -1;
			complexNumberBefore=(complexNumber.multiply(complexNumber)).sum(complexNumberConst);

			complexNumber=complexNumberBefore.sum(new ComplexNumber(0,0));
		}
		return countIterations;
	}
	
}
