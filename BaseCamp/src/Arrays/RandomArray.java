package Arrays;

import java.util.Random;
import java.util.*;

public class RandomArray {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		char[] chr=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		int mid=n/2;
		int sum=0;
		int count=0;		
		Random rand=new Random();
		//String []str=new String[n];
		List<String> str=new ArrayList<>();
		List<String> chrList=new ArrayList<>();
		for(int i=0;i<mid;i++){
			str.add(rand.nextInt(100)+"");
		}
		for(int i=mid;i<n;i++){
			str.add(chr[rand.nextInt(25)]+"");
		}
		Collections.shuffle(str);
		for(int i=0;i<n; i++){
			System.out.print(str.get(i)+" ");
			if(str.get(i).matches("[a-z]")){
				chrList.add(str.get(i));
				if(str.get(i).matches("['a','e','i','o','u']")){
					count++;
					//System.out.println(count);
				}
				
			}else{
				sum+=Integer.parseInt(str.get(i)+"");
			}
			
		}
		System.out.println(" ");
		for(String a:chrList){
			System.out.print(a);
		}
		System.out.println(" ");
		System.out.print("Sum is: " +sum+ " "+"vowels are: "+count);
	}

}
