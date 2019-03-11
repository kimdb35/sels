package etc;

import java.util.Scanner;

public class Q_1012 {
	
	static int[][] gnd;
	static boolean[][] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			gnd = new int[N+2][M+2];
			visited = new boolean[N+2][M+2];
			
			int tot = sc.nextInt();
			int ans = 0;
			
			for(int i=0; i<tot; i++) {
				gnd[sc.nextInt()+1][sc.nextInt()+1] = 1;
			}
			
			for(int j=1; j<M+1; j++) {
				for(int i=1; i<N+1; i++) {
					if(gnd[i][j]==1&&!visited[i][j]) {
						check(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
		
		sc.close();
	}
	
	static void check(int x, int y) {
		if(visited[x][y]) return;
		visited[x][y] = true;
		if(gnd[x-1][y]==1) check(x-1, y);
		if(gnd[x][y-1]==1) check(x, y-1);
		if(gnd[x+1][y]==1) check(x+1, y);
		if(gnd[x][y+1]==1) check(x, y+1);
	}

}
