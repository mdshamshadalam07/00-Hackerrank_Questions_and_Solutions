package com.Game_of_Thrones;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {
	
    public static String gameOfThrones(String s) {
    // Write your code here
            if(s==null || s.length()==0)
                return "NO";
            int[] a = new int[26];
            char[] c = s.toCharArray();
            int count=0;
            for(int i=0; i<c.length; i++) {
                if(a[c[i]-'a']==0)
                    a[c[i]-'a']++;
                else
                    a[c[i]-'a']=0;
            }
            for(int i=0; i<a.length; i++) {
                if(a[i]!=0)
                    count++;
            }
            if(count>1)
                return "NO";
            return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
