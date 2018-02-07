
package Arrays;

import java.util.Random;
import java.util.Scanner;

 
public class RandomPyramid {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length;
		Random rand=new Random();
		Scanner kb=new Scanner(System.in);
		System.out.println("Enter the Length");
		length=kb.nextInt();
		//String []merge=new String[length];
		int len=length/2;
		int []arr=new int[len];
		char []str=new char[length-len];
	for(int i=0;i<len;i++){
			arr[i]=rand.nextInt(100);
		}
		
		 //int m = arr.length;		 	       
	        for (int i = 0; i <len-1; i++)
	        {
	            int k = i;
	            for (int j = i+1; j < len; j++)
	                if (arr[j] > arr[k])
	                    k = j;
	 
	            int temp = arr[k];
	            arr[k] = arr[i];
	            arr[i] = temp;
	        }
		for(int a:arr){
			System.out.print(a+" ");
		}System.out.println( );
		
		for(int i=0;i<str.length;i++){
			char c = (char) (rand.nextInt(26) + 'a');
			str[i]=(char)c;
		}	
		 for(int i=0;i<str.length-1;i++){
			 for(int j=0;j<str.length-i-1;j++){
				 if(str[j]>str[j+1]){
					 char temp=str[j+1];
					 str[j+1]=str[j];
					 str[j]=temp;
				 }
			 }
		 }

		 int level=len-1;
		 int space=len-1;
		 for(int i=1;i<=level+1;i++){
			 for(int j=space;j>=1;j--){
				System.out.print(" ");				
			 }
			 for(int k=0;k<i;k++){
				 System.out.print(arr[k]+" ");
			 }
			 System.out.println(" ");
			 space--;
		 }
		 System.out.println(" ");
		 for(char a:str){
				System.out.print(a+" ");
			}System.out.println( );
			
		 int level1=str.length-1;
		 int space1=str.length-1;
		 for(int i=1;i<=level+1;i++){
			 for(int j=space1;j>=1;j--){
				 System.out.print(" ");
			 }
			 for(int k=0;k<i;k++){
				 System.out.print(str[k]+" ");
			 }
			 System.out.println(" ");
			 space1--;
		 }		
	
	}

}
