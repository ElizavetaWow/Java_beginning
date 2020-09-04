public class N4
{
	public static void main(String[] args) {
	    int a = 13, b = 10, c;
	    System.out.println(a +" "+ b);
	    c = a;
	    a = b;
	    b = c;
		System.out.println(a +" "+ b);
		c = b;
	    b = a;
	    a = c;
		System.out.println(a +" "+ b);
	}
}
