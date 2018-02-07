package SortingMethods;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*		int arr[]=new int[]{23,45,21,76,87,54,42};
		for(int i=1;i<arr.length;i++){
			int x=arr[i];
			int j=i-1;
			
			while(j>=0 && arr[j]>x){
				arr[j+1]=arr[j];
				j=j-1;
			}
		arr[j+1]=x;
		}
		for(int a:arr){
			System.out.println(a);
		}*/
		
		/*int arr[]=new int[]{1,2,3,4,5,6,7,8,9,10};
		
		for(int i=1;i<arr.length;i++){
			int x=arr[i];
			int j=i-1;
			
			while(j>=0 && arr[j]<x){
				arr[j+1]=arr[j];
				j=j-1;			
			}
			arr[j+1]=x;
		}
		for(int a:arr){
			System.out.println(a);
		}*/
		
		int arr[]=new int[]{1,12,123,1234,12345,123456,1234567,12345678,123456789,1234567890};
		for(int i=1;i<arr.length;i++){
			int temp=arr[i];
			int j=i-1;
			
			while(j>=0 && arr[j]<temp){
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=temp;
		}
		for(int a:arr){
			System.out.print(a+" ");
		}
	}

}
