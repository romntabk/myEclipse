package tasks6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import tasks5.task5;
//import javafx.util.Pair;
public class task6 {

	//6.1
	public static String hiddenAnagram(String str1, String str2) {
		String first = "", second="";
		str1=str1.toLowerCase();
		str2=str2.toLowerCase();
		for (int i=0;i<str1.length();i++) {
			if(str1.charAt(i)>='a' && str1.charAt(i)<='z') {
				first+=str1.charAt(i);
			}
		}for (int i=0;i<str2.length();i++) {
			if(str2.charAt(i)>='a' && str2.charAt(i)<='z') {
				second+=str2.charAt(i);
			}
		}
		String anagram="";
		for (int i=0;i<first.length();i++) {
			for (int j=0;j<first.length()-i;j++) {
				anagram = first.substring(j, j+i+1);
				if(tasks5.task5.totalPoints(new String[] {second},anagram)>0) {	
					return anagram;
				}
			}
		}
		return "noutfond";
	}
	//6.2
	public static List<String> collect(String str,int n) {
		List<String> list= new ArrayList<String>();
		col(list,str,n);
		Collections.sort(list);
		return list;
	}
	public static void col(List<String> list,String str, int n) {
		if(str.length()<n)
			return;
		list.add(str.substring(0,n));
		col(list,str.substring(n),n);
	}
	//6.3
	public static String nicoCiper(String message, String key) {
		List<Pair> pairs = new ArrayList<Pair>();
		for (int i=0;i<key.length();i++) {
			List<Character> testList= new ArrayList<Character>();
			int j=i;
			while(j<message.length()+key.length()-message.length()%key.length()) {
				if(j<message.length())
					testList.add(message.charAt(j));
				else
					testList.add(' ');
				j+=key.length();
			}
			pairs.add(new Pair( key.charAt(i),testList));
		}
		Comparator<Pair> comparator = Comparator.comparing(obj->obj.value);
		Collections.sort(pairs,comparator);
		String result = "";
		for (int i=0;i<(message.length()+key.length()-message.length()%key.length())/key.length();i++) {
			for (int j =0;j<key.length();++j) {
				result+=pairs.get(j).list.get(i);
			}
		}
		return result;
	}
	//6.4
	public static int[] twoProduct(int[] arr, int val) {
		int first=0,second=0;
		int[] answer = new int[2];
		for(int i=arr.length-1;i>0;--i) {
			second=arr[i];
			for(int j=i-1;j>=0;--j) {
				first=arr[j];
				if(first*second==val) {
					answer[0]=first;
					answer[1]=second;
				}
			}
		}
		return answer;
	}
	//6.5
	public static int[] isExact(int val) {
		int[] answer = new int[0];
		int number = isFact(val,2);
		if(number!=-1)
		{
			answer=new int[] {val,number};
		}
		return answer;
	}
	public static int isFact(int number, int k) {
		if(number==1) {
			return k-1;
		}
		if(number%k!=0)
			return -1;
		return isFact(number/k,k+1);
	}
	//6.6
	public static String fractions(String numb) {
		//x=val.drob(kek)
		//x*(drob.len)=val_drob.(kek)
		//x*(drob.len-1)=(val_drob-val).(drob-kek)
		//0123456789012345
		//123.45(67891011) index=6; len = 11;  12345.678  
		//power1 100000x= 12345678.678    power2 100x=12345.678
		//x= (noSmiles-withoutDotOnly)/(power1-power2)
		String noSmiles="",withoutDotOnly="";
		int power1=0,power2=0,dotIndex=0,firstIndex=0,secondIndex=0;
		for (int i=0;i<numb.length();i++) {
			if(numb.charAt(i)=='.') {
				dotIndex=i;
			}else
			if(numb.charAt(i)=='(') {
				firstIndex=i;
			}else
			if(numb.charAt(i)==')')
				secondIndex=i;
			else
				noSmiles+=numb.charAt(i);
		}
		withoutDotOnly=noSmiles.substring(0,firstIndex-1);
		int firstNumber,secondNumber;
		power1=secondIndex-dotIndex-2;
		power2=firstIndex-dotIndex-1;
		firstNumber=(int)(Math.pow(10, power1)-Math.pow(10, power2));
		secondNumber=Integer.parseInt(noSmiles)-Integer.parseInt(withoutDotOnly);
		int[] pair=divide(secondNumber,firstNumber);
		return pair[0]+"/"+ pair[1];
	}
	public static int[] divide(int a, int b) {
		int k=2;
		int t =Math.max(a, b);
		while (k<t) {
			if(a%k==0 && b%k==0) {
				a/=k;
				b/=k;
			}else
			k++;
		}
		return new int[] {a,b};
	}
	//6.7
	public static String pilish_string(String str) {
		String st="314159265358979";
		String res="";
		int index=0;
		int len=0;
		for (int i=0;i<str.length();i++) {
			len++;
			res+=str.charAt(i);
			if(st.charAt(index)-'0'==len)
			{
				res+=" ";
				len=0;
				index++;
			}
			if(index==15)
				return res;
		}
		if(st.charAt(index)-'0'>len)
			while(st.charAt(index)-'0'>len) {
				res+=res.charAt(res.length()-1);
				len++;
			}
		return res;
	}
	//6.8
	public static String generateNonconsecutive(int n) {		
		return recurs(n,false,"");
	}
	public static String recurs(int n, boolean wasOne,String kek) {
		if(n==1) {
			if(wasOne)
				return kek+"0 ";
			else
				return kek+"0"+" "+kek+"1 ";
		}
		if(wasOne) {
			return recurs(n-1,false,kek+"0");
		}else {
			return recurs(n-1,false,kek+"0") + recurs(n-1,true,kek+"1");
		}
		
	}
	//6.9
	public static String isValid(String str) {
		int[] arr= new int[100000];
		for (int i=0;i<arr.length;i++) {
			arr[i]=0;
		}
		for (int i=0;i<str.length();i++) {
			arr[str.charAt(i)]++;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int first;
		boolean flag= true;
		for (int i=0;i<arr.length;i++) {
			if(arr[i]!=0)
			{
				if(!map.containsKey(arr[i]))
					map.put(arr[i], 1);
				else
					map.put(arr[i], map.get(arr[i])+1);
			}
		}
		if(map.size()>2)
			return "NO!";
		int[] arrL= new int[4];
		int z=0;
		for (Map.Entry i : map.entrySet()) {
			arrL[z]=(int)i.getKey();
			arrL[z+1]= (int)i.getValue();
//			
//			
//			System.out.println(arrL[z]+" "+ arrL[z+1]);
			z+=2;
		}
		if(map.size()==1)
			return "YES!";
		if (arrL[0]<arrL[2]) {
			if(arrL[1]==1)
				return "YES!";
		}else {
			if(arrL[3]==1)
				return "YES";
		}
		
		
		return "NO!";
	}
	//6.10
	public static List<Pair2> sumsUp(int[] arr){
		List<Pair2> listik = new ArrayList<Pair2>();
		for (int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==8) 
					listik.add(new Pair2(arr[i],arr[j]));
			}
		}
		return listik;
	}
	public static void main(String[] args) {
		
	}

}
