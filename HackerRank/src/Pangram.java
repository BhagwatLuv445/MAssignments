
public class Pangram {

	
	static String isPangram(String[] strings) {

		int length=strings.length;
		char ch=97;
		int i=0;
		StringBuffer sb=new StringBuffer();

		for(i=0;i<length;i++){
			int count=0;
			for(int j='a';j<='z';j++){				
				for(int k=0;k<strings[i].length();k++){
					if(strings[i].charAt(k)==j){
						count+=1;
						//k++;
						break;
					}
				}
			//System.out.println(count);
			
		}if(count==26){
			sb.append(1);
		}else{
			sb.append(0);
		}
	}
		String s=sb.toString();
		return s;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] strings=new String[]{"the quick brown fox jumps over the lazy dog","asdasd"};
		String ss=Pangram.isPangram(strings);
		System.out.println(ss);
	}

}
