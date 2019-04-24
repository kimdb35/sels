package d190425.swex_2819;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	/*
	 * 1. set에 add 해서 size 구하기
	 * 2. depth 줘서 0일때까지 탐색
	 * 3. 전체 탐색하기
	 * 4. 탐색 시, 가장자리 탐색이 중요하다.. 쉽게 하는 법을 생각해보자
	 */
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] graph = new int[4][4];
	static HashSet<String> set = new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int ans = 0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			ans = set.size();
			System.out.println("#"+test_case+" "+ans);
		}
		sc.close();
	}
	static void move(int depth, String str, int x, int y) {
		if(--depth==0) {
			set.add(str);
			return;
		}
		for(int i=0; i<4; i++) {
			str = ""+graph[y][x];
//			if((x==0&&y==0) || () || () || ()) {
//				
//			}
			if(x!=0 && x!=3 && y!=0 && y!=3) {
				move(depth, str, x+dx[i], y+dy[i]);
			}
		}
	}
}