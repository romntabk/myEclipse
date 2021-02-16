package mypack;
public class PointsDemonstation {

	public static mypack.Point3d createPoint(String x, String y, String z){
		return new Point3d (
				Integer.parseInt(x),
				Integer.parseInt(y),
				Integer.parseInt(z)
				);
	}
	public static double computeArea(Point3d x, Point3d y, Point3d z) {
		double a=x.distanceTo(y),
				b=y.distanceTo(z),
				c=z.distanceTo(x);
		double halfP=(a+b+c)/2;
		return Math.sqrt(
				halfP*(halfP-a)*
				(halfP-b)*(halfP-c)
				);
	}
	
	public static void main(String[] args) {
		Point3d point1,point2,point3;
		if(args.length<6)
			return;
		point1=createPoint(args[0],args[1],args[2]);
		point2=createPoint(args[3],args[4],args[5]);
		point3=new Point3d(0,0,0);
		if( args.length>=9)
			point3 = createPoint(args[6],args[7],args[8]);
		if(point1.equals(point2) ||
				point2.equals(point3) ||
				point1.equals(point3)) {
			System.out.println("2 identical points found!");
			return;
		}
		System.out.println("Area = " + computeArea(point1,point2,point3));
		
	}

}
