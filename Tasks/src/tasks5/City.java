package tasks5;

public class City {
	public int years,months,days,hours, minutes;
	public int GMThours,GMTminutes;
	public String name;
	public City(String name, int hours, int minutes) {
		this.name=name;
		GMThours=hours;
		GMTminutes=minutes;
	}
	public void setTime(City city){
		
	}
	@Override
	public String toString() {
		return years+"-"+months+"-"+days+" "+hours+":"+minutes;
	}
}
