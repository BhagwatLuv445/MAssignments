import java.util.*;
public class Chocolate {
	 static void calculate(int[] arr) {
	       int num=arr.length;
	       int count=0;
	       for(int i=1;i<=num;i++){
	    	   if(i%2==1){
	    		   count+=i;
	    		   System.out.println(count);	    		   
	    	   }
	    	   else{	    		  
	    		   System.out.println(count);
	    	   }
	       }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
	        int arr_size = 5;
	        int[] arr = new int[arr_size];
	        arr[0]=1;
	        arr[1]=2; 
	        arr[2]=3;
	        arr[3]=4;
	        arr[4]=5;
	        calculate(arr);
	        
	}

}