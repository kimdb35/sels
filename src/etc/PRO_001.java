package etc;

import java.util.LinkedList;
import java.util.Scanner;

public class PRO_001 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		ans = returnFunc(n);
		
		System.out.println(n+" "+ans);
		
		sc.close();
	}
	
	static int returnFunc(int n) {
		int res = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=i; j++) {
				if(i%j==0) {
					if(i!=j) break;
					else list.add(i);
				}
			}
		}
		for(int i=0; i<list.size(); i++) {
			for(int j=i+1; j<list.size(); j++) {
				for(int k=j+1; k<list.size(); k++) {
					if(list.get(i)+list.get(j)+list.get(k)==n) res++;
				}
			}
		}
		
		return res;
	}

}
