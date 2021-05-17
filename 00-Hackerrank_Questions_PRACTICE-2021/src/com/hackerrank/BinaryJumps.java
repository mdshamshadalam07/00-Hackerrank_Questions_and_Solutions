package com.hackerrank;

import java.util.*;
public class BinaryJumps {

	static int minJumps(int arr[], int l, int h) {
		int count = 0;
		for (int i = 0; i < h; i++) {
			if (arr[i] == 1) {
				continue;
			} else {
				count = count + 2;
				continue;
			}
		}

		ArrayList<Integer> m = new ArrayList<Integer>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		ArrayList<Integer> t = new ArrayList<Integer>();
		s.add(1);
		t.add(0);
		for (int j = 0; j < h; j++) {
			m.add(arr[j]);
		}
		if (m.containsAll(t)) {
			return count;
		} else {
			m.containsAll(s);
			return 1;
		}
	}

	public static void main(String args[]) {
		int arr[] = { 1, 1, 1, 1, 0, 1, 1, 0, 1 };
		int n = arr.length;
		System.out.println(minJumps(arr, 0, n - 1));
	}
}