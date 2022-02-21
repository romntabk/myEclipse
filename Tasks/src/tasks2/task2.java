package tasks2;

import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
public class task2 {
	//2.1
	public static int oppositeHouse(int houseNumber, int streetLength ) {
		return streetLength*2+1-houseNumber;
	}
	//2.2
	public static String nameShuffle(String names) {
		return names.split(" ")[1]+" "+names.split(" ")[0];
	}
	//2.3
	public static double discount(double value, double procent) {
		return value*procent/100;
	}
	//2.4
	public static double differenceMaxMin(double[] arr) {
		double min=arr[0],max=arr[0];
		for (double i : arr) {
			if(i>max)
				max=i;
			if(i<min)
				min=i;
		}
		return max-min;
	}
	//2.5
	public static int equal(int a, int b, int c) {
		HashSet<Integer> set= new HashSet<Integer>(Arrays.asList(a,b,c));
		return 4-set.size()-set.size()/3;
	}
	//2.6
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	//2.7
	public static double programmers(double a, double b, double c) {
		return differenceMaxMin(new double[] {a,b,c});
	}
	//2.8
	public static boolean getXO(String str) {	
		return str.toLowerCase().codePoints().filter(ch-> ch=='x').count()==str.toLowerCase().codePoints().filter(ch-> ch=='o').count();
	}
	//2.9
	public static String bomb(String str) {
		return (str.toLowerCase().indexOf("bomb")==-1 ? "Relax, there's no bomb.":"DUCK!");
	}
	//2.10
	public static boolean saveAscii(String first, String second) {
		return first.chars().sum()==second.chars().sum();
		
	}
	public static void main(String[] args) {
	}

}
