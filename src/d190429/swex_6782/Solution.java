package d190429.swex_6782;

import java.util.Scanner;

public class Solution {

	/*
	 * 1. 루트할 수 있으면 무조건 루트 해야한다. 안하면 손해
	 * 2. 4나 16이나 이런거 노려볼까 했는데 걍 루트때려
	 * 3. DP로 푸는 건 어떨까..
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int ans = 0;
			int n = sc.nextInt();
			while(true) {
				if(isTwo(n)) break;
				
			}
			System.out.println("#"+test_case+" "+ans);
		}
		sc.close();
	}
	
	static boolean isTwo(int num) {
		return num==2;
	}
}
