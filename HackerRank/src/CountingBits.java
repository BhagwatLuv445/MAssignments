import java.util.*;
public class CountingBits {


    /*
     * Complete the function below.
     */
    static int[] getOneBits(int n) {
    	
		int a,count=0;
		int binary=0,i=1;
		while(n>0){
			a=n%2;
			if(a==1){
				count++;
			}
			binary=binary+(i*a);
			n/=2;
			i=i*10;
		}
        System.out.println(binary);
        int []arr=new int[count+1];                
        arr[0]=count;
        StringBuffer sb=new StringBuffer("");
        sb.append(Integer.toString(binary));  
        System.out.println(sb.toString());
        for(int k=0,j=1;k<sb.length();k++){
            if(sb.charAt(k)=='1'){
                arr[j]=k+1;
                j++;
                }               
            }
     return arr;
    }           


	public static void main(String[] args) {
		int[] res;
        int n;
        n = 161;
		res = getOneBits(n);
        for(int res_i = 0; res_i < res.length; res_i++) {
        	System.out.println(res[res_i]);
        }
	    }


	}

