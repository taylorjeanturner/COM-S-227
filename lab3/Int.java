package lab3;

public class Int {
	public static void main(String[] args) {
		int x = 42;
	    String s = "" + x;
	    
	    String t = "42";
	    int y = Integer.parseInt(t);
	    
	    System.out.println(s);
	    System.out.println(t);
	    
//	    String r = "hello";
//	    int z = Integer.parseInt(r);
	    
	    
	    int max = Integer.MAX_VALUE;
	    int min = Integer.MIN_VALUE;
	    
	    System.out.println(max);
	    System.out.println(min);
	    
	    System.out.println(max + 1);
	    
	    System.out.println(max + 2);
	    
	    System.out.println(max + min);
	}

}
