package d190324;

import java.util.ArrayList;
import java.util.Scanner;

public class SS_16236 {
	
	static boolean[][] visited;
	static boolean finished = false;
	static int ans = 0;
	
	/* 곧 지워질 수 있는 목록 */
	static int[][] fish1;
	static int[][] fish2;
	static int[][] fish3;
	static int[][] fish4;
	static int[][] fish5;
	static int[][] fish6;

	public static void main(String[] args) {
		
		
		/*
		 * 나의 플랜
		 * 1. 완전 탐색한다
		 * 2. 먹을 수 있는 먹이들까지의 거리 중 최소값 쪽으로 이동
		 * 3. 거기서 다시 완전 탐색
		 * 4. 이동할 수 있는 경우가 없을 경우 프로그램 종료
		 * 
		 * ** 여기서 먹이의 위치 중 가장 가까운 곳을 클래스를 새로 만들고 ArrayList에 저장.. 만약 더 가까운 곳이 나오면 remove()
		 * 탐색할 경우.. 먹이의 크기도 체크해서 길을 골라가야함
		 * 
		 * 완전탐색 플랜
		 * 1. 현재 위치 파악
		 * 2. 현재 위치에서 먹을 수 있는 모든 먹이들의 위치 파악
		 * 3. 
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
	
}