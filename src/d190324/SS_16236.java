package d190324;

import java.util.ArrayList;
import java.util.Scanner;

public class SS_16236 {
	
	static boolean[][] visited;
	static boolean finished = false;
	static int ans = 0;
	static int size = 2;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) {
		
		
		/*
		 * 다시 작성하는 플랜
		 * 무조건 bfs로 푼다.
		 * 같은 dept면 길이도 같다
		 * 방문한 곳은 true 처리해서 재방문 방지
		 * 전체 스캔할 필요 없이 뎁스 내에서 같으면 된다
		 * 최소 뎁스에서 위 또는 좌측 값을 넣자.. 그것이 최소값!
		 * 오늘 놀고 와서 풀어도 될듯
		 * 먹고 바로 사이즈 확인
		 * 현재 위치에서 다시 서
		 * 
		 */
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int iniX=0, iniY=0;
		visited = new boolean[N][N];
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					iniX = j;
					iniY = i;
				}
			}
		}
		ArrayList<Cord> que = new ArrayList<>();
		Cord c = new Cord(iniX, iniY);
		que.add(c);
		while(!finished) {
			while(!que.isEmpty()) {
				Cord cd = que.get(0);
				que.remove(0);
				int nowX = cd.getX();
				int nowY = cd.getY();
				for(int i=0; i<4; i++) {
					isOk(nowX, nowY, map, i, que);
				}
			}
			if(true) finished = true;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
	
	static void isOk(int x, int y, int[][] map, int dir, ArrayList<Cord> que) {
		if(map[y+dy[dir]][x+dx[dir]]<=size && !visited[y+dy[dir]][x+dx[dir]]) {
			visited[y+dy[dir]][x+dx[dir]] = true;
			Cord cord = new Cord(x+dx[dir], y+dy[dir]);
			que.add(cord);
		}
	}
	
	static void move() {
		
	}
	
	static boolean isEat() {
		return false;
	}

}

class Cord{
	int x;
	int y;
	int dept;
	
	public Cord() {}
	
	public Cord(int x, int y, int dept) {
		new Cord(x, y);
		this.dept = dept;
	}
	
	public Cord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}
	
	
	
}