import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Isprime {
    
    public static void main(String[] args)  {
  	  int num=0,rem=0,count=1,n=50;
      while(n>0){ 
        
    	rem=n%2;
    	if(rem==0){
            rem=1;
        }else{
            rem=0;
        }
          num+=count*rem;
          count=count*2;
    	n/=2;
    }
        System.out.println(num);
    }
}


	