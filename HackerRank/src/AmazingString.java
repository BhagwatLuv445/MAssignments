
public class AmazingString {
	 static int[] minimalOperations(String[] words) {
		    int []cnt=new int[words.length];
		    for(int i=0;i<words.length;i++)
		    {
		    	int count=0;
		        int j;
		        for(j=1;j<words[i].length();j++)
		        {
		            if(words[i].charAt(j) == words[i].charAt(j-1))
		            {
		                count++;
		            }
		        }
		        //if(j==arr[i].length())
		       // System.out.println(count);		        
		        	if(count==1){
			          	  cnt[i]=1;
			          }
			          else {
			        	  cnt[i]=count;
			          }		          
		    }
			return cnt;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		int[]res;
		String[] words = new String[5];
        words[0]="ab";
        words[1]="aab";
        words[2]="abb";
        words[3]="abab";
        words[4]="abaaaba";
        		

        res = minimalOperations(words);
        for(int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(res[res_i]);
            
        }

	}

}
