package d190425.swex_2819;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] graph = new int[6][6];
	static HashSet<String> set = new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int ans = 0;
			for(int i=0; i<6; i++) {
				for(int j=0; j<6; j++) {
					if(i!=0 && j!=0 && i!=5 && j!=5){
						graph[i][j] = sc.nextInt();
					} else graph[i][j] = -1;
				}
			}
			for(int i=1; i<=4; i++){
				for(int j=1; j<=4; j++){
					move(0, "", j,i);
				}
			}
			ans = set.size();
			System.out.println("#"+test_case+" "+ans);
			set.clear();
		}
		sc.close();
	}
	static void move(int depth, String str, int x, int y) {
		if(depth==7) {
			set.add(str);
			return;
		}
		str = str+""+graph[y][x];
		for(int i=0; i<4; i++) {
			if(graph[y+dy[i]][x+dx[i]]!=-1) {
				move(depth+1, str, x+dx[i], y+dy[i]);
			}
		}
	}
}