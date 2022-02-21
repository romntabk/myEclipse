package mypack;

public class ComplexNumber {
	public double realPart;
	public double imaginaryPart;
	public ComplexNumber(double real, double imaginary) {
		realPart=real;
		imaginaryPart=imaginary;
	}
	public double lenPow2() {
		return realPart*2+imaginaryPart*2;
	}
	public ComplexNumber sum(ComplexNumber complexNumber) {
		return new ComplexNumber(realPart+complexNumber.realPart,imaginaryPart+complexNumber.imaginaryPart);
	}
	public ComplexNumber multiply(ComplexNumber complexNumber) {
		return new ComplexNumber(realPart*complexNumber.realPart-imaginaryPart*complexNumber.imaginaryPart,-(realPart*complexNumber.imaginaryPart+imaginaryPart*complexNumber.realPart));
	}
	public void pair() {
		imaginaryPart*=-1;
	}
}
