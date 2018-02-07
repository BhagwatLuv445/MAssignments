package Sorting;

public class CountingPairs {

	 static int countPairs(int[] numbers, int p) {
	        int len=numbers.length;
	        int dup[]=new int[numbers.length];
	        int i = 0,j=0,count=0;
	        for(;i<len-1;i++){
	        	if(numbers[i+1]-numbers[i]==p){
	        		count++;
	        		}
	        }
			return count;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[]=new int[]{1,2,3,4,5,6};
		int num=CountingPairs.countPairs(numbers, 2);
		System.out.println(num);
	}

}
