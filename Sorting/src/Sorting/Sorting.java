package Sorting;

public class Sorting {
	
	static void bubbleSort(int []arr){
		System.out.println("Array in unsorted order");
		for(int a:arr){
			System.out.println(a);
		}
		int n=arr.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("Array in sorted order");
		for(int a:arr){
			System.out.println(a);
		}
	}
	
	
	
	
	public static void main(String []args){
	
		int arr[]=new int[5];
		arr[0] = Integer.valueOf(args[0]);
		arr[1] = Integer.valueOf(args[1]);
		arr[2] = Integer.valueOf(args[2]);
		arr[3] = Integer.valueOf(args[3]);
		arr[4] = Integer.valueOf(args[4]);
		
		Sorting.bubbleSort(arr);
	}
}
