package SortingMethods;
import java.util.*;

public class BubbleSort {

	public static int[] array(int arr[]){
		
		for(int i=arr.length;i>1;i--){
			for(int j=0;j<i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int arr[]=new int[]{1,4,8,5,3,9,7,4};
		for(int i=arr.length;i>1;i--){
			for(int j=1;j<i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int a:arr){
			System.out.println(a);
		}*/
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Size of Array");
	int sizeOfArray=sc.nextInt();
	int arr[]=new int[sizeOfArray];
	System.out.println("Enter the elements of the array");
	for(int i=0;i<sizeOfArray;i++){
		arr[i]=sc.nextInt();
	}
	int arr1[]=BubbleSort.array(arr);
	for(int a:arr1){
		System.out.print(a+" ");
	}
		
	}

}
