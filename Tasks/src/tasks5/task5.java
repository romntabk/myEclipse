package tasks5;
import java.util.*;
import java.time.*;
public class task5 {
	//5.1
	public static boolean sameLetterPattern(String str1, String str2) {
		if( str1.length()!=str2.length())
			return false;
		int dif = str1.charAt(0)-str2.charAt(0);
		for (int i=0;i<str1.length();++i) {
			if(str1.charAt(i)-str2.charAt(i)!=dif)
				return false;
		}
		return true;
	}
	//5.2
	public static String spiderVsFly(String str1, String str2) {
		Dot spider = new Dot(str1.charAt(0),Integer.parseInt(Character.toString(str1.charAt(1))));
		Dot butterFly = new Dot(str2.charAt(0),Integer.parseInt(Character.toString(str2.charAt(1))));
		Dot.route=spider.getLetterString()+Integer.toString(spider.getLevel());
		int distance=spider.getDistanceAndDir(butterFly)[0],dir=spider.getDistanceAndDir(butterFly)[1];
		if(spider.getLevel()==0)
			spider.setLetter(butterFly.getLetterChar());
		if(butterFly.getLevel()==0)
			butterFly.setLetter(spider.getLetterChar());
		if(spider.getLevel()> butterFly.getLevel() || distance > 2) { //h4 b3
			while(spider.getLevel()>butterFly.getLevel()) {
				spider.changeLevel(-1);
			}
			if(distance>2) {
				while(spider.getLevel()!=0) {
					if(spider.getLevel()==1)
						spider.setLetter('A');
					spider.changeLevel(-1);
				}
				spider.setLetter(butterFly.getLetterChar());
				while(spider.getLevel()!=butterFly.getLevel()) {
					spider.changeLevel(1);
				}
			}else {
				while(spider.getLetterChar()!=butterFly.getLetterChar()) {
					spider.changeLetter(dir);
				}
			}
		}
		else {
			// вбок а потом наверх
			while(spider.getLetterChar()!=butterFly.getLetterChar()) {
				spider.changeLetter(dir);
			}
			while(spider.getLevel()!=butterFly.getLevel()) {
				spider.changeLevel(1);
			}
		}
		return Dot.route;
	}
	//5.3
	public static int digitsCount(long number) {
		if (Math.abs(number)<10)
			return 1;
		return digitsCount(number/10)+1;
	}
	//5.4
	public static int totalPoints(String[] arr, String str) {
		int result=0;
		boolean[] checker = new boolean[str.length()];
		next:
		for (String i : arr) {
			for (int j=0;j<str.length();j++) {
				checker[j]=false;
			}
			for (int z=0;z<i.length();z++) {
				if(str.contains(Character.toString(i.charAt(z))))
					for (int j=0;j<str.length();j++) {
						if (i.charAt(z)==str.charAt(j) && !checker[j])
						{
							//System.out.println(j + " " + i.charAt(z));
							checker[j]=true;
							break; //badcredit
						}
						if(j==str.length()-1)
							continue next;
					}
				else
					continue next;
			}
			result+=i.length()-2;
			if(i.length()==str.length()) {
				result+=50;
			}
		}
		return result;
	}
	//5.5
	public static int longestRun(int[] arr){
		int current=1, longest=1;
		for (int i=1;i<arr.length;i++) {
			if(arr[i]-1==arr[i-1] || arr[i]+1==arr[i-1]) {
				current++;
			}
			else {
				if(current>longest)
					longest=current;
				current =1;
			}
		}
		if(current>longest)
			longest=current;
		return longest;
	}
	//5.6
	public static String takeDownAverage(String[] arr) {
		// s/n =a  
		// (s+x)/(n+1)=a-0.05
		// x = (a-0.05)*(n+1)-s
		double sum=0, avg=0;
		for (String i : arr) {
			sum+= Integer.parseInt(i.substring(0,i.length()-1));
		}
		return Integer.toString((int)((sum/arr.length-5)*(arr.length+1)-sum+0.5))+"%";
	}
	//5.7
	public static String rearrange(String str) {
		String number = "";
		String word = "";
		String[] arr = str.split(" ");
		String[] myarr = new String[arr.length];
		for (String i : arr) {
			for (char j : i.toCharArray()) {
				if(Character.isDigit(j)) {
					number+=j;
				}else {
					word+=j;
				}
			}
			
			myarr[Integer.parseInt(number)-1]=word;
			word="";
			number="";
		}
		return String.join(" ", myarr);
	}
	//5.8
	public static String maxPossible(int a, int b) {
		char[] chars = Integer.toString(b).toCharArray();
		Arrays.sort(chars);
		String res="";
		for (int i=0;i<chars.length;i++) {
			res=chars[i]+res;
		}
		String astr=Integer.toString(a);
		int z=0;
		String result="";
		for (int i=0;i<astr.length();++i) {
			System.out.println(Integer.parseInt(Character.toString(astr.charAt(i)))+" "+Integer.parseInt(Character.toString(res.charAt(z))));
			if(z<chars.length && Integer.parseInt(Character.toString(astr.charAt(i)))<Integer.parseInt(Character.toString(res.charAt(z)))){
				
				result+=Character.toString(res.charAt(z));
				z++;
			}else {
				result+=Character.toString(astr.charAt(i));
			}
		}
		
		return result;
	}
	//5.9
	public static String timeDifference(String name1,String time1, String name2) {
		String[] arr = time1.split(" ");
		String mon="";
		if(arr[0].equals("December"))
			mon="12";
		if(arr[0].equals("November"))
			mon="11";
		if(arr[0].equals("October"))
			mon="10";
		if(arr[0].equals("September"))
			mon="9";
		if(arr[0].equals("August"))
			mon="8";
		if(arr[0].equals("July"))
			mon="7";
		if(arr[0].equals("June"))
			mon="6";
		if(arr[0].equals("May")) 
			mon="5";
		if(arr[0].equals("April"))
			mon="4";
		if(arr[0].equals("March")) 
			mon="3";
		if(arr[0].equals("February"))
			mon="2";
		if(arr[0].equals("Jenuary"))
			mon="1";
		String days =arr[1].substring(0,arr[1].length()-1);
		if(mon.length()==1)
			mon="0"+mon;
		if(days.length()==1)
			days="0"+days;
		String timezone="";
		int h=0,m=0;
		switch (name2) {
		case "Los Angeles":{
			timezone="-08:00";
			h=-8;
			break;
		}
		case "New York":{
			timezone="-05:00";
			h=-5;
			break;
		}
		case "Caracas":{
			timezone="-04:30";
			h=-4;
			m=-30;
			break;
		}
		case "Buenos Aires":{
			h=-3;
			timezone="-03:00";
			break;
		}
		case "London":{
			timezone="+00:00";
			break;
		}
		case "Rome":{
			h=1;
			timezone="+01:00";
			break;
		}
		case "Moscow":{
			
			h=3;
			timezone="+03:00";
			break;
		}
		case "Tehran":{
			h=3;
			m=30;
			timezone="+03:30";
			break;
		}
		case "New Delphi":{
			h=5;
			m=30;
			timezone="+05:30";
			break;
		}
		case "Beijing":{
			h=8;
			timezone="+08:00";
			break;
		}
		case "Canberra":{
			h=10;
			timezone="+10:00";
			break;
		}
		}
		switch (name1) {
		case "Los Angeles":{
			timezone="-08:00";
			h+=8;
			break;
		}
		case "New York":{
			h+=5;
		
			timezone="-05:00";
			break;
		}
		case "Caracas":{
			timezone="-04:30";
			h+=4;
			m+=30;
			break;
			
		}
		case "Buenos Aires":{
			timezone="-03:00";
			h+=3;
			break;
		}
		case "London":{
			timezone="+00:00";
			break;
		}
		case "Rome":{
			timezone="+01:00";
			h-=1;
			break;
		}
		case "Moscow":{
			timezone="+03:00";
			h-=3;
			break;
		}
		case "Tehran":{
			h-=3;
			m-=30;
			timezone="+03:30";
			break;
		}
		case "New Delphi":{
			timezone="+05:30";
			h-=5;
			m-=30;
			break;
		}
		case "Beijing":{
			h-=8;
			timezone="+08:00";
			break;
		}
		case "Canberra":{
			timezone="+10:00";
			h-=10;
			break;
		}
		}
		ZonedDateTime a = ZonedDateTime.parse(arr[2]+"-"+mon+"-"+days+"T"+arr[3]+timezone);
		int totalMin=h*60+m;
		if(totalMin<0)
			a=a.minusMinutes(-totalMin);
		else
			a=a.plusMinutes(totalMin);
		return a.toString();
		
	}
	//5.10
	public static boolean isNew(int number) {
		String str= Integer.toString(number);
		int pos=0;
		for (int i=1;i<str.length();i++) {
			if(str.charAt(i)!='0') {
				pos=i;
				break;
			}
		}
		for (int i=0;i<str.length();i++) {
			for (int j=i;j<str.length();j++) {
				if(j>=pos  && str.charAt(j)<str.charAt(i))
					return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println(totalPoints(new String[] {"badcredit"},"debitcar"));
	}

}
