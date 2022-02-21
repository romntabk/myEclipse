package tasks6;

public class Pair2 {
		int firstVal,secondVal;
		public Pair2(int a, int b)
		{
			if(a>b) {
				firstVal=b;
				secondVal=a;
			}else {
				secondVal=b;
				firstVal=a;
			}
		}
	
}
