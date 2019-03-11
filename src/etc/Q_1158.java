package etc;

import java.util.LinkedList;
import java.util.Scanner;

public class Q_1158 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<Integer> link = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			link.add(i);
		}
		System.out.print("<");
		jose(0, m, link);
		
		sc.close();
	}
	
	static void jose(int cur, int num, LinkedList<Integer> link) {
		if(link.isEmpty()) return;
		
		int m = (cur+num-1)%link.size();
		if(link.size()==1) System.out.println(link.get(0)+">");
		else System.out.print(link.get(m)+", ");
		link.remove(m);
		jose(m, num, link);
	}

}
