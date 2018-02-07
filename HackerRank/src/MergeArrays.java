import java.util.*;
public class MergeArrays {

	static void mergeArrays(int []arr,int []arr1){
		int len=arr.length+arr1.length;
		int []mergeArr=new int[len];
		int i=0,j=0,k=0;
		while(i<arr.length && j<arr1.length){
			mergeArr[k]=arr[i];
			k++;			
			i++;			
		}
		while(j<arr1.length){
			mergeArr[k]=arr1[j];
			j++;
			k++;
		}
		
		
		int max=mergeArr[0];
		for(int x=0;x<mergeArr.length-1;x++){
			for(int y=0;y<mergeArr.length-x-1;y++){
			if(mergeArr[y]>mergeArr[y+1]){
				int temp=mergeArr[y];
				mergeArr[y]=mergeArr[y+1];
				mergeArr[y+1]=temp;
				}
			}
		}
		
		
		
		for(int a:mergeArr){
			System.out.println(a);
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[]{-5,10,100,8,15};
		int arr1[]=new int[]{200,-5,100,10,3};
		MergeArrays.mergeArrays(arr, arr1);
	}

}
