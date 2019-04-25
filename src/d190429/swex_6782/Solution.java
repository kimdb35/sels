package d190429.swex_6782;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			long ans = 0;
			long n = Long.parseLong(sc.next());
			while(true) {
				if(n==2) break;
				long tmp = (long) Math.sqrt(n);
				if(tmp*tmp == n) {
					n = tmp;
				} else {
					ans += (tmp+1)*(tmp+1) - n;
					n = tmp+1;
				}
				ans++;
			}
			System.out.println("#"+test_case+" "+ans);
		}
		sc.close();
	}
	
}
