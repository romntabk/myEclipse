package tasks3;

import java.util.Arrays;

public class task3 {

	//3.1
	public static String[][] millionsRounding(String[][] arr) {
		Arrays.asList(arr).forEach((String[] pair)->{
			pair[1]=Integer.toString((Integer.parseInt(pair[1])+500000)/1000000*1000000);
		});
		return arr;
	}
	//3.2
	public static Double[] otherSides(double side) {
		return new Double[]{(((double)(int)(side*2*100))/100),((double)((int)(Math.sqrt(side*side*3)*100))/100)};
	}
	//3.3
	public static String rps(String first, String second) {
		if (first.equals(second))
			return "TIE";
		if (first.charAt(0)=='r' && second.charAt(0)=='p' 
				|| first.charAt(0)=='p' && second.charAt(0)=='s' 
				|| first.charAt(0)=='s' && second.charAt(0)=='r' )
			return "Player 2 win";
		else
			return "Player 1 win";
	}
	//3.4
	public static int warOfNumbers(int[] arr) {
		int a=0,b=0;
		for (int i : arr) {
			if (i%2==0)
				a=a+i;
			else
				b=b+i;
		}
		return Math.abs(a-b);
	}
	//3.5
	public static String reverseCase(String str) {
		String result = "";
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
				result+=Character.toLowerCase(str.charAt(i));
				continue;
			}
			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
				result+=Character.toUpperCase(str.charAt(i));
				continue;
			}
			result+= (str.charAt(i));
		}
		return result;
	}
	//3.6
	public static String inatorInator(String str) {
		String result = str;
		String patern = "AaEeQqYyUuIiOoJj";
		char lastChar = str.charAt(str.length()-1);
		if( patern.contains(Character.toString(lastChar)) ) {
			result+="-inator";
		}else {
			result+="inator";
		}
		return result + " "+ Integer.toString(str.length()*1000) ;
	}
	//3.7
	public static boolean doesBrickFit(int a, int b, int c, int h, int w) {
		return Math.min(a*b, Math.min(a*c, b*c))<=h*w;
	}
	//3.8
	public static double totalDistance(double fuelCount, double fuelLoss, int passangers, boolean cond) {
		
		return (int)(fuelCount/(fuelLoss*(1+passangers*0.05)*(1+0.1*(cond?1:0)))*10000)/100.0;
	}
	//3.9
	public static double mean (double[] arr) {
		double res=0;
		for (double i : arr) {
			res+=i;
		}
		return res/arr.length;
	}
	//3.10
	public static boolean parityAnalysis(int a) {
		int t=0;
		int k=a;
		for (int i=0;i<= Math.log10(a);i++) {
			t+=k%10;
			k/=10;
		}
		return a%2==t%2;
	}
	public static void main(String[] args) {
//3.1
//		String[][] arr= new String[][] {{"a","13923452"},{"b","7996830"},{"c","10770487"}};
//		arr=millionsRounding(arr);
//		for (int i=0;i<arr.length;i++) {
//			for (int j=0;j<2;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.print(totalDistance(36.1,8.6,3,true));
		
	}

}
