
public class BinaryAndCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=77;
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
		System.out.println(count+" "+binary);

	}

}
