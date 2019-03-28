package d190324;

import java.util.ArrayList;
import java.util.Scanner;

public class SS_16236 {
	
	static boolean[][] visited;
	static boolean finished = false;
	static int ans = 0;
	static int size = 2;

	public static void main(String[] args) {
		
		
		/*
		 * 다시 작성하는 플랜
		 * 무조건 bfs로 푼다.
		 * 같은 dept면 길이도 같다
		 * 방문한 곳은 true 처리해서 재방문 방지
		 * 먹고 바로 사이즈 확인
		 * 현재 위치에서 다시 서
		 * 
		 */
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int nowX, nowY;
		visited = new boolean[N][N];
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					visited[i][j] = true;
					nowX = j;
					nowY = i;
				}
			}
		}
		ArrayList<FishCord> que = new ArrayList<>();
		
		
		while(!finished) {
			while(!que.isEmpty()) {
				
			}
			if(true) finished = true;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
	
	static void move() {
		
	}
	
	static boolean isEat() {
		return false;
	}

}

class FishCord{
	int x;
	int y;
	
}