
public class Reflection {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr1[]=new int[]{1,2,3,4,5,6};
		int arr2[]=new int[]{9,8,7,6,5,4};
		int arr3[]=new int[arr1.length+arr2.length];
		int i=0,j=0;
		while(i<arr1.length){
			arr3[j]=arr1[i];
			i++;
			j++;
		}
		int k=0;
		while(k<arr2.length){
			arr3[j]=arr2[k];
			k++;
			j++;
		}
	       	for(int l=0;l<arr3.length-1;l++){
			int k1=l;
			for(int m=l+1;m<arr3.length;m++){
				if(arr3[m]<arr3[k1])
					k1=m;
				
				int temp=arr3[k1];
				arr3[k1]=arr3[l];
				arr3[l]=temp;
			}
		}
		for(int a:arr3){
			System.out.print(a+" ");
		}
	}

}
