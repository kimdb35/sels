package etc;

import java.util.Scanner;

public class Q_1065 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();			// n <= 1000	
		sc.close();
		int ans = 99;
		if(n<99) System.out.println(n);
		else {
			for(int i=100; i<=n; i++) {
				if((i/100)-((i/10)%10)==((i/10)%10)-(i%10)) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

}
