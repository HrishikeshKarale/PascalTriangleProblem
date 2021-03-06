/**
Pascal Triangle
(http://blog.smartbear.com/programming/7-silly-programming-challenges-to-do-for-fun/)

You may remember the Pascal triangle from your childhood math classes. It starts with a single 1 at the top, then each row after that is built from the previous one, where the first and last number on the row are the first and last number of the previous row, and each number in-between is the sum of the two numbers a little to the right of it, and a little to the left of it, on the previous row. The nth row has n numbers on it. It looks like this:
					
												 1									1										1
											1	 1								1		1									1  1
									1 	2	 1	[OR]				1		2		1				[OR]		1  2  1
							1		3		3	 1						1		3		3		1							1  3  3  1  
					 1	4		6		4	 1					1		4		6		4		1						1  4  6  4  1  
				1  5  10  10  5  1		 		1		5		10	10	5		1					1  5  10 10 5  1

*/

import java.util.Scanner;

class PascalTriangleProblem {
	private int matrix[][]= null;
	private static int count= 0;
	
	PascalTriangleProblem() {
		matrix= new int[count][count];
		for(int i= 0; i<count; i++) {
			matrix[i][0]= 1;
			for(int j= 1; j<count; j++) {
				if(i!= j) {
					matrix[i][j]= 0;
				}
			}
			matrix[i][i]= 1;
		}
	}
	
	private void pascalTriangle() {
		int counter= 0;
		if(count>= 1) {
			for( int i= 2; i<count; i++) {
				for( int j= 1; j<i; j++){
						matrix[i][j]= matrix[i-1][j]+matrix[i-1][j-1];
				} 
			}
		}
	}
	
	private void print() {
		for(int i= 0; i<count; i++) {
			for(int j=0; j<count-i; j++) {
				System.out.print("\t");
			}
			for(int j= 0; j<i+1; j++) {
				if(matrix[i][j]!= 0) {
					System.out.print(matrix[i][j]+"\t\t");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		Scanner scrObject= new Scanner(System.in);
		System.out.println("\n\n**********Pascal Triangle**********");
		System.out.print("\nEnter height of Pascal Triangle: ");
		try {
			count= scrObject.nextInt();
		}
		catch (Exception e) {
			System.out.println("Wrong Input\n");
			System.exit(0);
		}
		PascalTriangleProblem psclTrglPblmObject= new PascalTriangleProblem();
		psclTrglPblmObject.pascalTriangle();
		psclTrglPblmObject.print();
		System.out.println("\n\n");
	}
}
