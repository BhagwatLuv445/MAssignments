import java.util.Arrays;
import java.lang.*;
import java.util.Collections;


public class HacklandElections {
	
		static String electionWinner(String[] votes) {
			int k=0;
			//String temp=new String("a");
			String []str=new String[votes.length];
			for(int i=0;i<votes.length-1;i++){
				for(int j=i+1;j<votes.length;j++){
					if(votes[i]==votes[j]){
						str[k]=votes[i];
						k++;
						System.out.println(str[i]);
					}
				}
				//System.out.println(str[i]);
			}		
			String name = null ;
		    // int z=0;
			boolean ans=true;			
				 for(int i=0; i<str.length; i++){ 
				  if(str[i]!=null){
				   ans= false;
				  	}else{
				  		ans= true;	
				  	}
				  }
							
				if(ans==false){					
					int n = 0;
				    for (int i = 0; i < str.length; i++)
				        if (str[i] != null) {
				        	n++;
				        }
				        	String[] str1= new String[n+1];
				        	 int l = 0;
							    for (int i = 0; i < str.length; i++)
							        if (str[i] != null)
							            str1[l++] = str[i];
							    {					
									Arrays.sort(str1);
									int len=str1.length;
									System.out.println(len);
									name=str1[len-1];
							//		System.out.println(str1[z]);									
								}	
				}else{
					Arrays.sort(votes);
					//System.out.println(votes[z]);
					name=votes[votes.length-1];					
				        }			
			return name;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1[]=new String[]{"Victor","Veronica","Ryan","Dave","Dave"};
		String res=HacklandElections.electionWinner(str1);
		System.out.println(res);
	}
}
