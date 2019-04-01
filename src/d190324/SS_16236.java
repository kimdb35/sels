package d190324;

import java.util.ArrayList;
import java.util.Scanner;

public class SS_16236 {
	
	static boolean[][] visited;
	static boolean finished = false;
	static int N;
	static int ans = 0;
	static int size = 2;				// 생선 크
	static int count = 2;				// 먹어야 하는 회
	
	static int[] dx = {0,-1,0,1};
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
		N = sc.nextInt();
		int iniX=0, iniY=0;
		visited = new boolean[N][N];
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					iniX = j;
					iniY = i;
					visited[i][j] = true;
				}
			}
		}
		ArrayList<Cord> que = new ArrayList<>();
		
		Cord c = new Cord(iniX, iniY);
		que.add(c);
		int dept = 1;
		int nowX=0, nowY=0;
		while(!finished) {
			Cord food = new Cord(-1,-1,100);
			while(!que.isEmpty()) {
				Cord cd = que.get(0);
				que.remove(0);
				nowX = cd.getX();
				nowY = cd.getY();
				for(int i=0; i<4; i++) {
					move(nowX, nowY, map, i, que, dept, food);
				}
				dept++;
			}
			if(food.getDept()!=100) {
				eating();
				ans += food.getDept();
				dept = 1;
				que.clear();
				que.add(new Cord(food.getX(), food.getY()));
				map[nowY][nowX] = 0;
				map[food.getY()][food.getX()] = 9;
				visited[food.getY()][food.getX()] = true;
			} else finished = true;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
	
	static void move(int x, int y, int[][] map, int dir, ArrayList<Cord> que, int dept, Cord food) {
		if(map[y+dy[dir]][x+dx[dir]]<=size && !visited[y+dy[dir]][x+dx[dir]]) {
			visited[y+dy[dir]][x+dx[dir]] = true;
			if(map[y+dy[dir]][x+dx[dir]]<size && map[y+dy[dir]][x+dx[dir]]!=0) {
				if((food.getY()<y+dy[dir]) || (food.getY()==y+dy[dir]&&food.getX()>x+dx[dir])) {
					food.setX(x);
					food.setY(y);
					food.setDept(dept);
				}
			} else {
				Cord cord = new Cord(x+dx[dir], y+dy[dir], dept);
				que.add(cord);
			}
		}
	}
	
	static void eating() {
		
		if(--count==0) {
			size++;
			count = size;
		}
		visited = new boolean[N][N];
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