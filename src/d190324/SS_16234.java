package d190324;

import java.util.Scanner;

public class SS_16234 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
//		int L = sc.nextInt();
//		int R = sc.nextInt();
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
	}
	
	static void union() {
		
	}
}
