package etc;

import java.util.Scanner;

public class Q_1003 {

	static int[] save = new int[41];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		save[0] = 1;
		save[1] = 1;
		int num;
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			num = sc.nextInt();
			if(num==0) System.out.println("1 0");
			else if(num==1) System.out.println("0 1");
			else {
				fibo(num);
				System.out.println(save[num-2]+" "+save[num-1]);
			}
		}
		

		sc.close();

	}
	
	static int fibo(int n) {
		if(save[n]>0) return save[n];
		return save[n] = fibo(n-1)+fibo(n-2);
	}

}
