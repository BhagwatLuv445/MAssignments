package Arrays;

public class EmployeeDetailsManipulation {


	public static void searchByName(String str[][],String name){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(str[i][j].equalsIgnoreCase(name)){
					for(int k=0;k<4;k++){
						System.out.print(str[i][k]+" ");							
					}
					System.out.println( );
				}
			}			
		}
	}
	public static void searchByDept(String str[][],String dept){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(str[i][j].contains(dept)){
					for(int k=0;k<4;k++){
						System.out.print(str[i][k]+" ");	
					}
					System.out.println( );
				}
			}
		}
		
	}
	public static void searchByPhone(String str[][],String dept){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(str[i][j].contains(dept)){
					for(int k=0;k<4;k++){
						System.out.print(str[i][k]+" ");	
					}
					System.out.println( );
				}
			}
		}
		
	}
	public static void searchByAddress(String str[][],String dept){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(str[i][j].contains(dept)){
					for(int k=0;k<4;k++){
						System.out.print(str[i][k]+" ");	
					}
					System.out.println( );
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	


	public static void deleteByName(String str[][],String name){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(str[i][j].equalsIgnoreCase(name)){
					for(int k=0;k<4;k++){
						str[i][k]="\0";											
					}System.out.println("Record Deleted");
					System.out.println( );
				}
			}			
		}
	}
	public static void deleteByDept(String str[][],String dept){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(str[i][j].equalsIgnoreCase(dept)){
					for(int k=0;k<4;k++){
						str[i][k]="\0";
					}					
				}
			}
		}
		System.out.println("Record Deleted");
	}
	public static void deleteByPhone(String str[][],String phone){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(str[i][j].equals(phone)){
					for(int k=0;k<4;k++){
						str[i][k]="\0";	
					}System.out.println("Record Deleted");
					System.out.println( );
				}
			}
		}
		
	}
	public static void deleteByAddress(String str[][],String add){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				if(str[i][j].contains(add)){
					for(int k=0;k<4;k++){
						str[i][k]="\0";	
					}System.out.println("Record Deleted");
					System.out.println( );
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
