package d190301;

import java.util.Scanner;

public class SS_14501 {

	static int[] DAY;
	static int[] PAY;
	static int ans=0;
	static int N;
	static int count=0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		DAY = new int[N];
		PAY = new int[N];
		
		for(int i=0; i<N; i++) {
			DAY[i] = sc.nextInt();
			PAY[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++) {
			int temp = 0;
			workHard(i, temp);
		}
		
		System.out.println(ans);
		System.out.println(count);
		
		sc.close();

	}
	
	static void workHard(int now, int totPay) {
		count++;
		if(now>=N-1) {
			ans=ans>totPay?ans:totPay;
		}
		else if(now+DAY[now]>N) {
			ans=ans>totPay?ans:totPay;
		}
		
		if(isWork(now)) {
			totPay += PAY[now];
			for(int i=now; i<N; i++) {
				workHard(i+DAY[now], totPay);
			}
		}
	}
	
	static boolean isWork(int now) {
		if(now>=N) return false;
		if(now+DAY[now]>N) return false;
		return true;
	}

}
