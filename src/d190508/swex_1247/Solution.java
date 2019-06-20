package d190508.swex_1247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 1247 최적 경로
/*

1. 브루트 포스로 풀거임
2. dp 를 살짝 섞었다.
3. 각 점마다 걸리는 거리 체크
4. 팩토리얼의 경우의 수를 체크할 수 있다면 좋겠다.

팩토리얼 체크 방법
1. que를 만들어서 복사해서 쓴다
2. 큐가 있는 동안 반복하는 while문을 만들고 재귀로 계속 들어간다.
3. 이거 메모리 오버 나진 않겠지...?

 */
public class Solution {

    static ArrayList<Cord_1247> cord = new ArrayList<>();
    static int[][] dp;
    static int ans;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            ans = 999999;
            int N = sc.nextInt();
            dp = new int[N+2][N+2];
            boolean[] visited = new boolean[N];
            int[] idxArr = new int[N];
            start[0] = sc.nextInt();         // x
            start[1] = sc.nextInt();         // y
            end[0] = sc.nextInt();           // x
            end[1] = sc.nextInt();           // y

            for(int i=0; i<N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Cord_1247 c = new Cord_1247(x, y);
                cord.add(c);
                idxArr[i] = i;
            }
            perm(idxArr, 0);

            System.out.println("#"+test_case+" "+ans);
            System.out.println(cnt);
        }
        sc.close();
    }

    static void perm(int[] idxArr, int index) {
        if(index == idxArr.length) {
            int res = distance(idxArr);
            ans = ans<res?ans:res;
            return;
        } else {
            for(int i=index; i<idxArr.length; i++) {
                swap(idxArr, index, i);
                perm(idxArr, index+1);
                swap(idxArr, index, i);
            }
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int distance(int[] idxArr) {
        int temp = 0;
        if(dp[0][idxArr[0]+1]==0) {
            dp[0][idxArr[0]+1] = Math.abs(start[0]-cord.get(idxArr[0]).x)+Math.abs(start[1]-cord.get(idxArr[0]).y);
        }
        if(dp[idxArr[idxArr.length-1]+1][dp.length-1]==0) {
            dp[idxArr[idxArr.length-1]+1][dp.length-1] = Math.abs(end[0]-cord.get(idxArr[idxArr.length-1]).x)+Math.abs(end[1]-cord.get(idxArr[idxArr.length-1]).y);
        }
        temp += dp[0][idxArr[0]+1] + dp[idxArr[idxArr.length-1]+1][dp.length-1];
        for(int i=0; i<idxArr.length-1; i++) {
            if(dp[idxArr[i]+1][idxArr[i+1]+1]==0) {
                dp[idxArr[i]+1][idxArr[i+1]+1] = Math.abs(cord.get(idxArr[i]).x - cord.get(idxArr[i+1]).x) + Math.abs(cord.get(idxArr[i]).y - cord.get(idxArr[i+1]).y);
                dp[idxArr[i+1]+1][idxArr[i]+1] = dp[idxArr[i]+1][idxArr[i+1]+1];
            }
            temp += dp[idxArr[i]+1][idxArr[i+1]+1];
        }

        return temp;
    }

}
class Cord_1247{
    int x;
    int y;

    Cord_1247(int x, int y){
        this.x = x;
        this.y = y;
    }
}
