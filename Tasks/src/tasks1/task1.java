package tasks1;

public class task1 {
	 //1.1
	public static int minutesToSeconds(int minutes) {
		return minutes*60;
	}
	//1.2
	public static int points(int doublescore, int tripplescore) {
		return doublescore*2+tripplescore*3;
	}
	//1.3
	public static int footballPoints(int wins, int draws, int loses) {
		return wins*3+draws-loses*2;
	}
	//1.4
	public static boolean divideByFive(int number) {
		return number%5==0;
	}
	//1.5
	public static boolean and(boolean a, boolean b) {
		return a||b;
	}
	//1.6
	public static int howManyWalls(int countWalls, int height, int weight) {
		return countWalls/(height*weight);
	}
	//1.7
	public static int squaed(int number) {
		return number * number;
	}
	//1.8
	public static boolean profitableGamble(double prob, double prize, double pay) {
		return prob*prize>pay;
	}
	//1.9
	public static int frames(int minutes, int fps) {
		return minutes*fps*60;
	}
	//1.10
	public static int mod(int a,int b) {
		return a-a/b*b;
	}
	public static int aa(int a) {
		return a*24*60*60;
	}
	public static void main(String[] args) {
		
	}

}
