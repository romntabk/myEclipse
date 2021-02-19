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
		System.out.println(otherSides(1)[1]);
	}

}
