package leetcode;

public class ReshapeMatrix {

	public void reshape(int[][] mat, int r, int c) {
		int rows = mat.length;
		int cols = mat[0].length;

		int[][] currMat = new int[r][c];
		int currRows = 0;
		int currcol = 0;

		if((rows*cols)!=(r*c)) {
			System.out.println("enter the valid rows and cloumns");
		}
		else {
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					currMat[currRows][currcol] = mat[i][j];
					currcol++;

					if(currcol == c) {
						currcol = 0;
						currRows++;
					}
				}
			}

			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(currMat[i][j]+" ");
				}
				System.out.println();

			}
		}
	}
	public static void main(String[] args) {

		int mat[][]= {{1,3,4},
				{8,9,10}};

		int r=1,c=6;


		int a = mat.length;
		int b = mat[0].length;
		System.out.println("Before reshape: " );
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		ReshapeMatrix r1=new ReshapeMatrix();
		System.out.println("reshape result: ");
		r1.reshape(mat,r,c);
	}
}
