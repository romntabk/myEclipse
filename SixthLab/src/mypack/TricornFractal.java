package mypack;

import java.awt.geom.Rectangle2D.Double;

public class TricornFractal extends FractalGenerator {
	public static final int MAX_ITERATIONS = 2000;
	@Override
	public void getInitialRange(Double range) {
		 range.width = 4;
	     range.height = 4;
	     range.y = -2;
	     range.x = -2;		
	}

	@Override
	public int numIterations(double x, double y) {
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

			complexNumber.pair();
		
		}
		return countIterations;
	}
}
