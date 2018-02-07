package StudentsRecord;

public class ConcatTwoCharArray {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char ch1[][]=new char[][]{{'a','1','a'},{'b','2','a'},{'c','3','c'}};
		char ch2[][]=new char[][]{{'a','2','c'},{'b','3','1'},{'c','4','d'}};
		
		String str[][]=new String[3][4];
		for(int i=0;i<ch1.length;i++){
			for(int j=0;j<ch2.length;j++){	
				
				if(Character.isDigit(ch1[i][j]) && Character.isDigit(ch2[i][j])){
					int k=Character.getNumericValue(ch1[i][j])+Character.getNumericValue(ch2[i][j]);
					str[i][j]=""+k;
				}
				else
				{
				str[i][j]=""+ch1[i][j]+ch2[i][j];
				}
			}
		}
		
	for(int i=0;i<str.length;i++){
		for(int j=0;j<str.length;j++){
		System.out.print(str[i][j]+" ");
			}
		System.out.println(" ");
		}
	}

}
