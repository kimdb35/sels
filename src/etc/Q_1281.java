package etc;

import java.util.Scanner;

public class Q_1281 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] jew = new int [N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				jew[i][j] = sc.nextInt();
			}
		}
		
		
		
		sc.close();
	}

}
