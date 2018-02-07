package Arrays;

import java.util.Scanner;

public class Dog {

	public static void main(String[] args) {

		int [][]arr = new int[3][3];
		int [][]brr = new int[3][3];
		int [][]crr = new int[3][3];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the element of first Matrix");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter the elemnet of Second Matrix");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				brr[i][j] = sc.nextInt();
			}
		}

		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					crr[i][j]=crr[i][j]+arr[i][k]*brr[k][j];
				}
			}
		}
		System.out.println("Matrix MultiPlication...");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(crr[i][j]+" ");
			}
			System.out.println(" ");
		}
		
	}

}
