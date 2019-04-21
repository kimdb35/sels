package d190419.swex_7465;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] graph = new int[n][n];
            int ans = 0;
            boolean[] visited = new boolean[m];

            for(int i=0; i<m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
                graph[b][a] = 1;
            }

            System.out.println("#"+test_case+" "+ans);
        }

        sc.close();
    }

    static void dfs(){
        int aa = 1;
    }
}