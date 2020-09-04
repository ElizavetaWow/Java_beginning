public class Main
{
	public static void main(String[] args) {
	    double a = 1.0, b = 2.0;
	    dist(a, b, 3.7, 4.5);
	}
	public static void dist(double x1, double y1, double x2, double y2) {
	    double c;
	    c = Math.pow(Math.abs(x1-x2), 2) +  Math.pow(Math.abs(y1-y2), 2);
	    System.out.println(Math.sqrt(c));
	}
}
