package d190324;

import java.util.ArrayList;
import java.util.Scanner;

public class SS_16236 {
	
	static boolean[][] visited;
	static boolean finished = false;
	static int ans = 0;
	
	/* �� ������ �� �ִ� ��� */
	static int[][] fish1;
	static int[][] fish2;
	static int[][] fish3;
	static int[][] fish4;
	static int[][] fish5;
	static int[][] fish6;

	public static void main(String[] args) {
		
		
		/*
		 * ���� �÷�
		 * 1. ���� Ž���Ѵ�
		 * 2. ���� �� �ִ� ���̵������ �Ÿ� �� �ּҰ� ������ �̵�
		 * 3. �ű⼭ �ٽ� ���� Ž��
		 * 4. �̵��� �� �ִ� ��찡 ���� ��� ���α׷� ����
		 * 
		 * ** ���⼭ ������ ��ġ �� ���� ����� ���� Ŭ������ ���� ����� ArrayList�� ����.. ���� �� ����� ���� ������ remove()
		 * Ž���� ���.. ������ ũ�⵵ üũ�ؼ� ���� ��󰡾���
		 * 
		 * ����Ž�� �÷�
		 * 1. ���� ��ġ �ľ�
		 * 2. ���� ��ġ���� ���� �� �ִ� ��� ���̵��� ��ġ �ľ�
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