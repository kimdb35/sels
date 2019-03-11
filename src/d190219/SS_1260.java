package d190219;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SS_1260 {
	
	static boolean[] visited;
	static int[][] graph;
	static int nodeNum;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		nodeNum = sc.nextInt();
		int edgeNum = sc.nextInt();
		int startNum = sc.nextInt();
		int a,b;
		
		graph = new int[nodeNum+1][nodeNum+1];
		visited = new boolean[nodeNum+1];
		
		for(int idx=0; idx<edgeNum; idx++) {
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		dfs(startNum);
		System.out.println();
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		bfs(startNum);
		
		sc.close();
	}
	
	static void dfs(int curNode) {
		if(visited[curNode]) return;
		visited[curNode] = true;
		System.out.print(curNode+" ");
		for(int idx=1; idx<=nodeNum; idx++) {
			if(graph[curNode][idx]==1 && visited[idx]!=true) {
				dfs(idx);
			}
		}
	}
	
	static void bfs(int curNode) {
		Queue<Integer> que = new LinkedList<>(); 
		visited[curNode] = true;
		que.add(curNode);
		while(!que.isEmpty()) {
			System.out.print(que.peek()+" ");
			for(int i=1; i<=nodeNum; i++) {
				if(graph[que.peek()][i]==1 && visited[i]!=true) {
					que.add(i);
					visited[i] = true;
				}
			}
			que.poll();
		}
	}

}
