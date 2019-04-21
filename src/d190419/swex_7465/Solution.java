package d190419.swex_7465;

import java.util.Scanner;

class Solution
{
    static int[][] graph;
    static boolean[] visited;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            graph = new int[n+1][n+1];
            int ans = 1;
            visited = new boolean[n+1];
            for(int i=0; i<m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
                graph[b][a] = 1;
            }
            for(int i=1; i<n+1; i++){
                if(!visited[i]){
                    dfs(i, n+1);
                    for(int j=1; j<n+1; j++) {
                        if(!visited[j]) {
                            ans++;
                            break;
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
    }

    static void dfs(int n, int tot){
        if(!visited[n]) {
           visited[n] = true;
           for(int i=1; i<tot; i++){
               if(graph[n][i]==1 && !visited[i]) dfs(i, tot);
           }
        }
    }
}