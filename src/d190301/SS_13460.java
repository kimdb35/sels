package d190301;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SS_13460 {

	static int V; // 가로
	static int H; // 세로
	static int ans = 100;
	static boolean finished = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[][] map;
		
		Queue<QueDir> que = new LinkedList<>();

		H = sc.nextInt();
		V = sc.nextInt();

		int rx=0, ry=0, bx=0, by=0;
		map = new String[H][V];

		for (int i = 0; i < H; i++) {
			String str = sc.next();
			String[] arr = str.split("");
			for (int j = 0; j < V; j++) {
				map[i][j] = arr[j];
				if ("R".equals(arr[j])) {
					map[i][j] = ".";
					rx = j;
					ry = i;
				}
				if ("B".equals(arr[j])) {
					map[i][j] = ".";
					bx = j;
					by = i;
				}
			}
		}
		que.add(new QueDir(rx, ry, bx, by, -1, 1));
		while (!que.isEmpty()) {
			QueDir nowInfo = que.poll();
			int cnt = nowInfo.cnt;
			int nowRx = nowInfo.getRx();
			int nowRy = nowInfo.getRy();
			int nowBx = nowInfo.getBx();
			int nowBy = nowInfo.getBy();
			int dir = nowInfo.getDir();
			if(cnt>10) break;
			
			for(int i=0; i<4; i++) {
				if(dir%2!=i%2) moveFirst(i,nowRx, nowRy, nowBx, nowBy, map, que, cnt);
			}
		}

		if(ans==100) ans = -1;
		System.out.println(ans);
		sc.close();
	}
	
	static void moveFirst(int dir, int rx, int ry, int bx, int by, String[][] map, Queue<QueDir> que, int cnt) {
		int[] red = move(dir, rx, ry, map);
		int[] blue = move(dir, bx, by, map);
		boolean redBlue = false;
		if(red[0]==blue[0] && red[1]==blue[1]) {
			if(finished) redBlue = true;
			else {
				switch(dir) {
					case 0:
						if(ry>by) blue[1]--;
						else red[1]--;
						break;
					case 1:
						if(rx>bx) blue[0]--;
						else red[0]--;
						break;
					case 2:
						if(ry>by) red[1]++;
						else blue[1]++;
						break;
					case 3:
						if(rx>bx) red[0]++;
						else blue[0]++;
						break;
				}
			}
		}
		if(redBlue) {									// 둘이 같이 빠진 경우
			finished = false;
			return;
		} else if(!finished) {							// 하나도 안빠진 경우
			que.add(new QueDir(red[0], red[1], blue[0], blue[1], dir, cnt+1));
		} else if(finished) {							// 하나만 빠진 경우
			if(map[red[1]][red[0]].equals("O")) {		// 빨강만 빠진 경우
				ans = ans>cnt?cnt:ans;
				return;
			} else finished = false;
		}
	}
	
	static int[] move(int dir, int x, int y, String[][] map) {
		int[] cord = new int[2];
		switch(dir) {
			case 0:
				cord[0] = x;
				for(int i=y; i<H-1; i++) {
					if(!map[i+1][x].equals(".")) {
						cord[1] = i;
						if(map[i+1][x].equals("O")) {
							cord[1] = i+1;
							finished = true;
							return cord;
						}
						break;
					}
				}
				break;
			case 1:
				cord[1] = y;
				for(int i=x; i<V-1; i++) {
					if(!map[y][i+1].equals(".")) {
						cord[0] = i;
						if(map[y][i+1].equals("O")) {
							cord[0] = i+1;
							finished = true;
							return cord;
						}
						break;
					}
				}
				break;
			case 2:
				cord[0] = x;
				for(int i=y; i>0; i--) {
					if(!map[i-1][x].equals(".")) {
						cord[1] = i;
						if (map[i-1][x].equals("O")) {
							cord[1] = i-1;
							finished = true;
							return cord;
						}
						break;
					}
				}
				break;
			case 3:
				cord[1] = y;
				for (int i = x; i > 0; i--) {
					if (!map[y][i-1].equals(".")) {
						cord[0] = i;
						if (map[y][i-1].equals("O")) {
							cord[0] = i-1;
							finished = true;
							return cord;
						}
						break;
					}
				}
				break;
		}
		return cord;
	}

}

class QueDir {
	int rx;
	int ry;
	int bx;
	int by;
	int dir;
	int cnt;
	
	QueDir(){}
	QueDir(int rx, int ry, int bx, int by, int dir, int cnt) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.dir = dir;
		this.cnt = cnt;
	}
	
	

	public int getRx() {
		return rx;
	}

	public void setRx(int rx) {
		this.rx = rx;
	}

	public int getRy() {
		return ry;
	}

	public void setRy(int ry) {
		this.ry = ry;
	}

	public int getBx() {
		return bx;
	}

	public void setBx(int bx) {
		this.bx = bx;
	}

	public int getBy() {
		return by;
	}

	public void setBy(int by) {
		this.by = by;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

}
