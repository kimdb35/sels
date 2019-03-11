package etc;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_1325 {

	@SuppressWarnings("unchecked")
	static ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[10001];
	static boolean[] visited = new boolean[10001];
	static int[] ans = new int[10001];
	static int cnt = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();

			a[v1].add(v2);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[10001];
			dfs(i);
		}

		for (int i = 1; i <= n; i++) {
			if (max < ans[i]) {
				max = ans[i];
			}
		}
		for (int i = 1; i <= n; i++) {
			if (max == ans[i]) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb.toString());
		sc.close();

	}

	public static void dfs(int v) {
		visited[v] = true;

		for (int vv : a[v]) {
			if (!visited[vv]) {
				ans[vv]++;
				dfs(vv);
			}
		}
	}

}
