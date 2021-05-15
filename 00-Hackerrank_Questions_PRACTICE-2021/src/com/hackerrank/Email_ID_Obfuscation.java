package com.hackerrank;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_ID_Obfuscation {
	
	    public static void main(String[] args) {
	         Scanner sc = new Scanner(System.in);

	        String email = sc.nextLine();
	        String regex = "^(.+)@(.+)$";

	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        if(matcher.matches())
	        {
	            String Firstpart;
	            String Lastpart;
	            String[] splitemail=email.split("@");
	            Lastpart=splitemail[1];
	            if(splitemail[0].length()<5)
	            {
	                int len = splitemail[0].length();
	                StringBuilder sb = new StringBuilder(len);
	                for(int i = 0; i < len; i++){
	                    sb.append('*');
	                }
	                Firstpart= sb.toString();
	            }
	            else
	            {
	                int len = splitemail[0].length();
	                StringBuilder sb = new StringBuilder(len);
	                sb.append(splitemail[0].substring(0,3)); 
	                for(int i = 3; i < len; i++){
	                    sb.append('*');
	                }
	                Firstpart= sb.toString();
	                
	            }
	            System.out.println(Firstpart+'@'+Lastpart);
	        }
	        else
	        {
	            System.out.println("Invaild input");
	        }
	    }
}
