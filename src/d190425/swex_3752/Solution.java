package d190425.swex_3752;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static Set<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			set.clear();
			int ans = 0;
			int N = sc.nextInt();
			int[] qArray = new int[N];
			set.add(0);
			for (int i = 0; i < N; i++) {
				qArray[i] = sc.nextInt();
			}
			
			for(int i=0; i<qArray.length; i++) {
				scoreSelect(qArray[i]);
			}
			
			ans = set.size();
			System.out.println("#" + test_case + " " + ans);
		}
		sc.close();
	}
	
	static void scoreSelect(int num) {
		Set<Integer> tmpSet = new HashSet<Integer>(); 
		tmpSet.addAll(set);
		Iterator<Integer> it = tmpSet.iterator();
		while(it.hasNext()) {
			set.add(it.next()+num);
		}
	}
}
