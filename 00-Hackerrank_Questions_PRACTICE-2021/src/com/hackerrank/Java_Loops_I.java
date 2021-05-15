package com.hackerrank;

import java.util.Scanner;

public class Java_Loops_I {
	
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int N = scanner.nextInt();
	        for(int i = 1; i <= 10; i++){

	            System.out.printf("%d x %d = %d%n", N, i, N*i);
	        }
	    }
}