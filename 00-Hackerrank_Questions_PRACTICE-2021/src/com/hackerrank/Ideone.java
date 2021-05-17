/*
 * package com.StringHandling.hk;
 * 
 * import java.util.Scanner;
 * 
 * public class Square_n {
 * 
 * String n_squares(int n) { StringBuffer s = new StringBuffer("0"); int
 * n_squared = n*n;
 * 
 * for (int i=0; i<n_squared; i++) { s.append (", " + i); } return s.toString();
 * }
 * 
 * public static void main (String[] args){ Square_n sn=new Square_n(); Scanner
 * scan=new Scanner(System.in); System.out.println("Enter no ::");
 * System.out.print(sn.n_squares(scan.nextInt()));
 * 
 * } }
 */

package com.hackerrank;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone {
	static String n_squares(int n) {
		StringBuffer s = new StringBuffer("0");
		n = n / 1000;
		int n_squared = n * n;
		n_squared = n_squared / n;
		for (int i = 0; i <= n_squared; i++) {
			s.append(", " + i);
		}
		char val = (s.charAt(s.length() - 1));
		return val + " second";
	}

	public static void main(String[] args) throws java.lang.Exception {

		System.out.println(n_squares(1500));
	}
}