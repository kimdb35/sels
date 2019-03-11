package etc;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_1325_bak {
	
	static int N;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		int[] node = new int[N+1];
		int max = 0;
		boolean[] visited;
		visited = new boolean[N+1];
		
		
		int cnt = 0;
		int a = 0;
		int b= 0;
		
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			arr[b].add(a);
		}
		for(int i=1; i<N+1; i++) {
			cnt = dfs(i,arr,cnt,visited);
			node[i] = cnt;
			System.out.println(i+". : "+cnt);
			max = max>cnt?max:cnt;
			visited = new boolean[N+1];
			cnt=0;
		}
		for(int i=0; i<N+1; i++) {
			if(node[i]==max) System.out.print(i+" ");
		}
		
		
		sc.close();
	}
	
	static int dfs(int curNode, ArrayList<Integer>[] arr, int cnt, boolean[] visited) {
		if(visited[curNode]) return cnt;
		for(int i=0; i<arr[curNode].size(); i++) {
			if(!visited[arr[curNode].get(i)]) {
				visited[curNode] = true;
				cnt++;
				cnt=dfs(arr[curNode].get(i), arr, cnt, visited);
			}
			
		}
		return cnt;
	}

}