package d190215;
import java.util.Scanner;

public class SS_14889 {

	static int[][] memStat;
	static int min = 999999999;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		memStat = new int[N][N];
		int[] temp = new int[N/2];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				memStat[i][j] = sc.nextInt();
			}
		}
		
		combination(N, N/2, 0, 0, temp);
		System.out.println(min);
		sc.close();
	}
	
	static void combination(int n, int r, int idx, int mem, int[] temp) {
		if(r==0) {
			insertMember(temp);
			return;
		} else if(r==n){
			temp[idx] = mem;
			insertMember(temp);
			return;
		} else {
			temp[idx] = mem;
			combination(n-1, r-1, idx+1, mem+1,temp);
			combination(n-1, r, idx, mem+1, temp);
		}
	}
	
	static void insertMember(int[] arr) {
		int team1 = 0;
		int team2 = 0;
		int res = 0;
		for(int i=0; i<memStat.length; i++) {
			for(int j=0; j<memStat[i].length; j++) {
				if(isMember(arr, i)&&isMember(arr, j)) team1 += memStat[i][j];
				else if((!isMember(arr,i))&&(!isMember(arr,j))) team2 += memStat[i][j];
			}
		}
		res = Math.abs(team1 - team2);
		min = min>res?res:min;
	}
	
	static boolean isMember(int[] arr, int n) {
		for(int i=0; i<arr.length; i++) {
			if(n==arr[i]) return true;
		}
		return false;
	}
	
}
