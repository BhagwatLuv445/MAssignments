
public class Recursion {
	/*public static void function(int a){
		if(a==101){
			return;
		}
		System.out.println(a+"\t");
		function(a+1);
	}*/
	/*public static int function(int num){
		if(num==0)
			return 1;
		return num*function(num-1);
	} */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*for(int i=1;i<=100;i++){
			System.out.print(i+"\t");*/
		//System.out.println(function(2));
		String s="1234";
		int a=Integer.parseInt(s);
		System.out.println(a);
		int arr[]=new int[]{1,2,3,4};
		int arrr[];
		arrr=arr;
		for(int a1:arr)
		System.out.println(a1);
		arr[0]=-1;
		for(int a1:arr)
			System.out.println(a1);
	}
		
}


