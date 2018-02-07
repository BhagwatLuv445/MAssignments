		import java.io.*;
		import java.util.*;

public class ReverseTheString {

		 public static void main(String[] args) {
			 String name="Bhagwat";
			 String n1="";
			 String n2="";
			 String reverse="";
			 String temp="";
			 char c = 0;
			 //String name="SMRUTI SATAPATHY";
			 for(int k=0;k<name.length();k++){
				  if(name.charAt(k)==' '){
					  c='Y';
				  }else{
					  c='N';
				  }
					  
			 }
				 if(c=='Y'){
					 String str[]=name.split(" ");
					 System.out.println(str.length);
					 n1=str[0];
					 n2=str[1];						 
					 for(int i=(n1.length())-1;i>=0;i--){				 
						 reverse=reverse+n1.charAt(i); 				 
					 }
					 for(int j=(n2.length())-1;j>=0;j--){
						 temp=temp+n2.charAt(j);
					 }
					 System.out.println(reverse+" "+temp);
				 }
				 else{
				 for(int l=name.length()-1;l>=0;l--){
					 reverse=reverse+name.charAt(l);
				 }
				 System.out.println(reverse);
			 }
		 }					 				 
 }			 
	


