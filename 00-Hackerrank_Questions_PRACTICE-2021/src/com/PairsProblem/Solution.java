/*Sample Input
STDIN       Function
-----       --------
5 2         arr[] size n = 5, k =2
1 5 3 4 2   arr = [1, 5, 3, 4, 2]
---------------------------------------------
Sample Output
3
*/

package com.PairsProblem;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int counter = 0;
        Set<Integer> nums = new HashSet<Integer>();
        for (int i =0; i < n; i++) {
            int m = scanner.nextInt();
            if (nums.contains(m-k))
                counter++;
            if (nums.contains(m+k))
                counter++;
            nums.add(m);
        }
        System.out.println(counter);
    }
}