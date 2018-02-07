import java.util.Arrays;


public class ReverseStringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nameArray={"Bhagwat Prajapati","Smruti Ranjan"};
		
		     String[] t=new String[nameArray.length];

		     for (int i = 0; i < nameArray.length; i++)
		     {
		         t[i] = "";
		         for (int j = nameArray[i].length() - 1; j >= 0; j--)
		             t[i] += nameArray[i].charAt(j);
		     }		     
		System.out.println((Arrays.toString(t))+" "+Arrays.toString(nameArray));
	}

}
