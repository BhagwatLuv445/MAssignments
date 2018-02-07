
public class SumOfTwoNumbersInAnArray {

		
		 
		    public static void printDistinctElements(int[] arr,int k){
		         int count=0;
		        for(int i=0;i<arr.length;i++){		           
		            for(int j=1;j<arr.length;j++){
		                if(arr[i] + arr[j]==k){	
		                	count++;
		                    break;
		                }
		            }		            
		        }
		        System.out.println(count);
		    }
		     
		    public static void main(String a[]){
		         
		        int[] nums = {5,2,7,2,4,7,8,2,3};
		        int n=4;
		        SumOfTwoNumbersInAnArray.printDistinctElements(nums,n);
		    }
		}



