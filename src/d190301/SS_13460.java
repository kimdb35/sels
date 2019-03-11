package d190301;

import java.util.LinkedList;
import java.util.Scanner;

public class SS_13460 {

	static int V; // 가로
	static int H; // 세로
	static int[] r = new int[2];
	static int[] b = new int[2];
	static int[] goal = new int[2];
	static int ans = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[][] toy;
		LinkedList<QueDir> rQue = new LinkedList<QueDir>();
		LinkedList<QueDir> bQue = new LinkedList<QueDir>();

		QueDir rqd = new QueDir();
		QueDir bqd = new QueDir();
		H = sc.nextInt();
		V = sc.nextInt();

		toy = new String[H][V];

		for (int i = 0; i < H; i++) {
			String str = sc.next();
			String[] arr = str.split("");
			for (int j = 0; j < V; j++) {
				toy[i][j] = arr[j];
				if ("R".equals(arr[j])) {
					rqd = new QueDir(j, i, 99);
				}
				if ("B".equals(arr[j])) {
					bqd = new QueDir(j, i, 99);
				}
				if ("O".equals(arr[j])) {
					goal[0] = j;
					goal[1] = i;
				}
			}
		}
		int cnt = 1;
		while (!rQue.isEmpty()) {
			if (cnt > 10)
				break;
			for (int i = 0; i < 4; i++) {
				if (isValid(rqd, toy, i) || isValid(bqd, toy, i)) {
					addDir(i, rqd, rQue);
					addDir(i, bqd, bQue);
				}
			}
			
			cnt++;
		}

		System.out.println(ans);
		sc.close();
	}

	static boolean isValid(QueDir qd, String[][] toy, int idx) {
		switch(idx) {
			case 0:
				if (!toy[qd.y + 1][qd.x].equals("#") && qd.dir != 2)
					return true;
				break;
			case 1:
				if (!toy[qd.y][qd.x + 1].equals("#") && qd.dir != 3)
					return true;
				break;
			case 2:
				if (!toy[qd.y - 1][qd.x].equals("#") && qd.dir != 0)
					return true;
				break;
			case 3:
				if (!toy[qd.y][qd.x - 1].equals("#") && qd.dir != 1)
					return true;
				break;
		}
		return false;
	}

	static void addDir(int idx, QueDir qd, LinkedList<QueDir> que) {
		switch (idx) {
			case 0:
				que.add(new QueDir(qd.y + 1, qd.x, idx));
				break;
			case 2:
				que.add(new QueDir(qd.y - 1, qd.x, idx));
				break;
			case 1:
				que.add(new QueDir(qd.y, qd.x + 1, idx));
				break;
			case 3:
				que.add(new QueDir(qd.y, qd.x - 1, idx));
				break;
		}
	}
	
	static boolean move(LinkedList<QueDir> que, String[][] toy, String type) {
		QueDir qd = que.poll();
		switch (qd.dir) {
		case 0:
			for (int i = qd.y; i < H; i++) {
				if (toy[i][qd.x].equals("O")) {
					return true;
				} else if (!toy[i][qd.x].equals(".")) {
					toy[qd.y][qd.x] = ".";
					toy[i][qd.x] = type;
					break;
				}
			}
			break;
		case 1:
			for (int i = qd.x; i < V; i++) {
				if (toy[qd.y][i].equals("O")) {
					return true;
				} else if (!toy[qd.y][i].equals(".")) {
					toy[qd.y][qd.x] = ".";
					toy[qd.y][i] = type;
					break;
				}
			}
			break;
		case 2:
			for (int i = qd.y; i > 0; i--) {
				if (toy[i][qd.x].equals("O")) {
					return true;
				} else if (!toy[i][qd.x].equals(".")) {
					toy[qd.y][qd.x] = ".";
					toy[i][qd.x] = type;
					break;
				}
			}
			break;
		case 3:
			for (int i = qd.x; i > 0; i--) {
				if (toy[qd.y][i].equals("O")) {
					return true;
				} else if (!toy[qd.y][i].equals(".")) {
					toy[qd.y][qd.x] = ".";
					toy[qd.y][i] = type;
					break;
				}
			}
			break;
		}
		return false;
	}

}

class QueDir {
	int x;
	int y;
	int dir;

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public QueDir() {
	}

	public QueDir(int y, int x, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
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

}
