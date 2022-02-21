package tasks4;

import java.util.Arrays;
import java.util.*;
public class task4 {

	//4.1
	public static String sevenBoom(int[] arr) {
		String str="";
		for (int i : arr) {
			str+=Integer.toString(i);
		}
		if (str.contains("7")) {
			return "Boom!";
		}
		return "There is no 7 in array";
	}
	//4.2
	public static boolean cons(int[] arr) {
		Arrays.sort(arr);
		for (int i=1;i< arr.length;i++) {
			if(arr[i]-1!=arr[i-1])
				return false;
		}
		return true;
	}
	//4.3
	public static String unmix(String str) {
		String res="";
		for (int i=0;i<str.length()/2;i++) {
			res+=str.charAt(i*2+1);
			res+=str.charAt(i*2);
		}
		if(str.length()%2==1) {
			res+=str.charAt(str.length()-1);
		}
		return res;
	}
	//4.4
	public static String noYelling(String str) {
		int i=str.length()-1;
		while ((str.charAt(i)=='!' || str.charAt(i)=='?') && i!=0 && (str.charAt(i-1)=='!' ||str.charAt(i-1)=='?') ) {
			str = str.substring(0,i);
			i-=1;
		}
		return str;
	}
	//4.5
	public static String xPronounce(String str) {
		String res="";
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i)=='x') {
				if(i==str.length()-1 && str.charAt(i-1)==' ' || i==0 && str.charAt(i+1)==' ' || i!=0 && i!=str.length()-1 && str.charAt(i-1)==' ' && str.charAt(i+1)==' ') {
					res+="ecks";
					continue;
				}
				
				if(i==0 || str.charAt(i-1)==' ') {
					res+="z";
					continue;
				}
				res+="cks";
				continue;
			}
			if(str.charAt(i)=='X') {
				if(i==str.length()-1 && str.charAt(i-1)==' ' || i==0 && str.charAt(i+1)==' ' || i!=0 && i!=str.length()-1 && str.charAt(i-1)==' ' && str.charAt(i+1)==' ') {
					res+="ecks";
					continue;
				}
				
				if(i==0 || str.charAt(i-1)==' ') {
					res+="Z";
					continue;
				}
				res+="cks";
				continue;
			}
			res+=str.charAt(i);
		}
		return res;
	}
	//4.6
	public static int largestGap(int[] arr) {
		int res=0;
		Arrays.sort(arr);
		for (int i=1;i<arr.length;i++) {
			if (res<arr[i]-arr[i-1])
				res=arr[i]-arr[i-1];
		}
		return res;
	}
	//4.7
	public static int watafak(int a) {
		StringBuilder t= new StringBuilder(Integer.toString(a)).reverse();
		int dif = Integer.parseInt(t.toString())-a;
		return dif<0?0:dif;
	}
	//4.8
	public static String commonLastVowel(String str) {
		String[] strs = str.split(" ");
		String patern = "AaEeQqYyUuIiOoJj";
		Map<String,Integer> dictionary = new HashMap<String,Integer>();
		for (int i=0;i<strs.length;i++) {
			String lastChar=Character.toString(Character.toLowerCase(strs[i].charAt(strs[i].length()-1)));
			if(patern.contains(lastChar)) {
				if(!dictionary.containsKey(lastChar))
					dictionary.put(lastChar,1);
				else {
					dictionary.put(lastChar, dictionary.get(lastChar)+1);
				}
			}
		}
		int max=0;
		String key="Nothing";
		for (Map.Entry<String,Integer> i : dictionary.entrySet()) {
			if(i.getValue()>max) {
				max=i.getValue();
				key=i.getKey();
			}
		}
		return key;
	}
	//4.9
	public static int memeSum(int a, int b) {
		String res="";
		int maxlen=(int)Math.log10(Math.max(a, b));
		for (int i=0;i<=maxlen;i++) {
			res+=Integer.toString(a/(int)Math.pow(10, maxlen-i)+(int)b/(int)Math.pow(10, maxlen-i));
			a%=(int)Math.pow(10, maxlen-i);
			b%=(int)Math.pow(10, maxlen-i);
		}
		return Integer.parseInt(res) ;
	}
	//4.10
	public static String unrepeated(String str) {
		String res="";
		for (int i=0;i<str.length();i++) {
			if(!res.contains(Character.toString(str.charAt(i)))) {
				res+=str.charAt(i);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(xPronounce("Xylophone"));
	}

}
