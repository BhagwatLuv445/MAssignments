
public class MaximizingXor {
	static int maximum_XOR(int a, int b) {
        int max=0,xor;
        for(int i=a;i<=b;i++){
            for(int j=i;j<=b;j++){
                xor=i^j;
                if(xor>max){
                	max=xor;
                }
                System.out.println(max);
            }
        }
		return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximizingXor.maximum_XOR(10, 15);
	}

}
