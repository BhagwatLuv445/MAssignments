
public class Replace {

	public static void main(String[] args) 
		{
			
		    String arr[]=new String[7];
		    arr[0]="ab";
		    arr[1]="aab";
		    arr[2]="abb";
		    arr[3]="abab";
		    arr[4]="abaaaba";
		    arr[5]="abaaaaba";
		    arr[6]="abbbbbbbbbba";
		    int []cnt=new int[arr.length];
		    for(int i=0;i<arr.length;i++)
		    {
		    	int count=1;
		        int j;
		        for(j=1;j<arr[i].length();j++)
		        {
		            if(arr[i].charAt(j) == arr[i].charAt(j-1))
		            {
		                count++;
		            }
		        }
		        //if(j==arr[i].length())
		       // System.out.println(count);		        
		        	if(count/2==1){
			          	  cnt[i]=1;
			          }
			          else {
			        	  cnt[i]=count/2;
			          }		          
		    }
		    for(int a:cnt){
		    	System.out.println(a);
		    }
		}
	
	}


