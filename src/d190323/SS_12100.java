package d190323;

import java.util.ArrayList;
import java.util.Scanner;

public class SS_12100 {

	static int N; // 입력값.
	static int max = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int[][] map = new int[N][N];


		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<4; i++) {
			move(0, i, map);
		}
		
		System.out.println(max);
		sc.close();
	}
	
	static void move(int dept, int dir, int[][] map) {
		
		if(dept==5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					max = max>map[i][j]?max:map[i][j];
				}
			}
			return;
		}
		
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {	// map 저장
			for (int j = 0; j <N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		ArrayList<Integer> aList = new ArrayList<>();
		switch(dir) {
		case 0:
			for(int j=0; j<N; j++) {
				for(int i=0;i<N;i++) {
					if(temp[i][j]!=0) aList.add(temp[i][j]);
				}
				for(int idx=0; idx<N;idx++) {
					if(!aList.isEmpty()) {
						if(idx==0) temp[idx][j] = aList.get(0);
						else {
							if(temp[idx-1][j]==aList.get(0)) {
								temp[idx-1][j] = temp[idx-1][j]*2;
								temp[idx][j] = 0;
							} else if(temp[idx-1][j]==0) {
								temp[--idx][j] = aList.get(0);
							} else temp[idx][j] = aList.get(0);
						}
						aList.remove(0);
					} else temp[idx][j] = 0;
				}
			}
			break;
		case 1:
			for(int i=0; i<N; i++) {
				for(int j=N-1;j>=0;j--) {
					if(temp[i][j]!=0) aList.add(temp[i][j]);
				}
				for(int idx=N-1; idx>=0;idx--) {
					if(!aList.isEmpty()) {
						if(idx==N-1) temp[i][idx] = aList.get(0);
						else {
							if(temp[i][idx+1]==aList.get(0)) {
								temp[i][idx+1] = temp[i][idx+1] * 2;
								temp[i][idx] = 0;
							} else if(temp[i][idx+1]==0) {
								temp[i][++idx] = aList.get(0);
							} else temp[i][idx] = aList.get(0);
						}
						aList.remove(0);
					} else temp[i][idx] = 0;
				}
			}
			break;
		case 2:
			for(int j=0; j<N; j++) {
				for(int i=N-1;i>=0;i--) {
					if(temp[i][j]!=0) aList.add(temp[i][j]);
				}
				for(int idx=N-1; idx>=0;idx--) {
					if(!aList.isEmpty()) {
						if(idx==N-1) temp[idx][j] = aList.get(0);
						else {
							if(temp[idx+1][j]==aList.get(0)) {
								temp[idx+1][j] = temp[idx+1][j]*2;
								temp[idx][j] = 0;
							} else if(temp[idx+1][j]==0) { 
								temp[++idx][j] = aList.get(0);
							} else temp[idx][j] = aList.get(0);
						}
						aList.remove(0);
					} else temp[idx][j] = 0;
				}
			}
			break;
		case 3:
			for(int i=0; i<N; i++) {
				for(int j=0;j<N;j++) {
					if(temp[i][j]!=0) aList.add(temp[i][j]);
				}
				for(int idx=0; idx<N; idx++) {
					if(!aList.isEmpty()) {
						if(idx==0) temp[i][idx] = aList.get(0);
						else {
							if(temp[i][idx-1]==aList.get(0)) {
								temp[i][idx-1] = temp[i][idx-1] * 2;
								temp[i][idx] = 0;
							} else if(temp[i][idx-1]==0) temp[i][--idx] = aList.get(0);
							else temp[i][idx] = aList.get(0);
						}
						aList.remove(0);
					} else temp[i][idx] = 0;
				}
			}
			break;
		}
		
		for(int i=0; i<4; i++) {
			move(dept+1, i, temp);
		}
	}
	
	static void show(int[][] map, int dir) {
		System.out.println("================ "+dir+" =================");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("====================================");
	}
}