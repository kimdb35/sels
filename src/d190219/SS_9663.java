package d190219;
import java.util.Scanner;

public class SS_9663 {
	
	static int N;
	static int ans=0;
	static int[][] queen = new int[15][2]; // 0 : x, 1 : y
	static int idx=0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		queenPos(0, N);
		System.out.println(ans);

		sc.close();
	}
	
	static void queenPos(int y, int n) {
		if(n==0) {
			ans++;
			idx--;
			return;
		}
		for(int j=0; j<N; j++) {
			if(queenCheck(j, y, idx)) {
				queen[idx][0] = j;
				queen[idx][1] = y;
				idx++;
				queenPos(y+1, n-1);
			}
		}
		if(idx>0) idx--;
	}
	
	static boolean queenCheck(int x, int y, int cur) {
		for(int i=0; i<cur; i++) {
			if(x==queen[i][0]) return false;
			if(Math.abs(x-queen[i][0]) == Math.abs(y-queen[i][1])) return false;
		}
		return true;
	}
}
