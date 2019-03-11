package etc;

import java.util.Scanner;

public class Q_9095 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();
			System.out.println(ann(n));
		}
		sc.close();
		
	}
	
	static int ann(int n) {
		if(n==0) return 0;
		else if(n==1) return 1;
		else if(n==2) return 2;
		else if(n==3) return 4;
		else return ann(n-3)+ann(n-2)+ann(n-1);
	}

}