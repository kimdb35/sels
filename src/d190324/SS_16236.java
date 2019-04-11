package d190324;

import java.util.ArrayList;
import java.util.Scanner;

public class SS_16236 {
	
	static boolean[][] visited;
	static boolean finished = false;	// 더 이상 남은 먹이가 없을때..
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
		 */
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int iniX=0, iniY=0;
		visited = new boolean[N+2][N+2];
		int[][] map = new int[N+2][N+2];
		for(int i=0; i<N+2; i++) {
			for(int j=0; j<N+2; j++) {
				if(i==0||j==0||i==N+1||j==N+1) {
					map[i][j]=9999;
				} else {
					map[i][j] = sc.nextInt();
					if(map[i][j]==9) {
						iniX = j;
						iniY = i;
						visited[i][j] = true;
					}
				}
			}
		}
		
		ArrayList<Cord> que = new ArrayList<>();
		Cord c = new Cord(iniX, iniY, 0);
		que.add(c);
		while(!finished) {
			Cord food = new Cord(1000,1000,1000);
			while(!que.isEmpty()) {
				Cord cd = que.get(0);
				que.remove(0);					// 큐 하나 빼기
				int nowX = cd.getX();
				int nowY = cd.getY();
				int dept = cd.getDept();
				for(int i=0; i<4; i++) {
					move(nowX, nowY, map, i, que, dept+1, food);
					// depth는 하나 더해서
				}
			}
			if(food.getDept()!=1000) {
				// food 초기값에서 변동이 없으면.. 즉 먹이가 없었을 경우
				eating();
				ans += food.getDept();
				que.clear();
				que.add(new Cord(food.getX(), food.getY(), 0));	// que empty 방지
				map[iniY][iniX] = 0;							// 상어 이동 전 위치를 0으로
				iniX = food.getX();
				iniY = food.getY();
				map[food.getY()][food.getX()] = 9;				// 상어 이동 후 위치를 9로
				visited[iniY][iniX] = true;						// 이동한 위치 방문처리
			} else finished = true;								// 먹이가 없었을 경우 프로그램 종료를 위해..
		}
		
		System.out.println(ans);
		
		sc.close();
	}
	
	static void move(int x, int y, int[][] map, int dir, ArrayList<Cord> que, int dept, Cord food) {
		if(map[y+dy[dir]][x+dx[dir]]<=size && !visited[y+dy[dir]][x+dx[dir]]) {
			// 작거나 같고(이동 통로), 방문 안한 곳
			visited[y+dy[dir]][x+dx[dir]] = true;
			if(map[y+dy[dir]][x+dx[dir]]<size && map[y+dy[dir]][x+dx[dir]]!=0 && food.getDept()>=dept) {
				// 작은 경우(먹이), 0이 아닌 곳, dept가 작은 곳.
				if((food.getY()>y+dy[dir]) || (food.getY()==y+dy[dir]&&food.getX()>x+dx[dir])) {
					// 먹이가 위에 있으면 or 같은 y 값일때 왼쪽에 있으면 먹이 교체
					food.setX(x+dx[dir]);
					food.setY(y+dy[dir]);
					food.setDept(dept);
				}
			} else {
				Cord cord = new Cord(x+dx[dir], y+dy[dir], dept);
				que.add(cord);
			}
		}
	}
	
	static void eating() {		// 먹고 성장할지 판단
		if(--count==0) {
			size++;
			count = size;
		}
		visited = new boolean[N+2][N+2];	// 방문기록 초기화
	}
	
	static void show(int[][] map) {		// 이동과정 보는 메소드
		System.out.println();
		System.out.println("===============================================");
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("===============================================");
	}
}

class Cord{				// 먹이 위치때문에 클래스 만듦
	int x;
	int y;
	int dept;			// depth 가 사실 상 거리
	
	public Cord() {}
	
	public Cord(int x, int y, int dept) {
		this.x = x;
		this.y = y;
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