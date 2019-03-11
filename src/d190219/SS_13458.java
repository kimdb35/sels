package d190219;

import java.util.Scanner;

public class SS_13458 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long ans = 0;
		int[] room = new int[N];
		for(int i=0; i<N; i++) {
			room[i] = sc.nextInt();
		}
		int temp;
		int chong = sc.nextInt();
		int boo = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			ans++;
			temp = room[i]-chong;
			if(temp>0) {
				if(temp%boo==0) ans += temp/boo;
				else ans += (temp/boo)+1;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
