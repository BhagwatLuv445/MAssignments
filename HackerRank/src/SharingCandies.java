import java.lang.*;
public class SharingCandies {
	static long getCandies(long n, long p) {
        long smallestFactor;
        StringBuffer bs=new StringBuffer("");
        for(long i=n;i>=1;i--){
            if(n/i==0){
                bs.append(n/i);
        }        
    }
        return bs.toString().charAt((int) p) ;       
	}        

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SharingCandies.getCandies(10, 3));
	}

}