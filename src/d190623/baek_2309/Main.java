package d190623.baek_2309;
// 백준이 안열려서 아직 확인 못해봄

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] ans = new int[7];
    static boolean flag = false;
    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i=0; i<9; i++) {
            arr[i] = sc.nextInt();
        }
        int[] tmpArr = new int[7];
        for(int idx=0; idx<arr.length; idx++) {
            dfs(0, idx, arr, tmpArr);
        }
        for(int num : ans) {
            System.out.println(num);
        }
        sc.close();
    }

    static void dfs(int dept, int idx, int[] arr, int[] tmp) {
        if(!flag) {
            if (idx == 9) {
                int res = 0;
                for (int ii = 0; ii < tmp.length; ii++) {
                    res += tmp[ii];
                }
                if (res == 100) {
                    ans = tmp;
                    Arrays.sort(ans);
                    flag = true;
                }
                return;
            }
            tmp[dept] = arr[idx];
            for(int i=idx+1; i<=arr.length; i++) {
                if(dept == 6) {
                    dfs(dept, i, arr, tmp);
                } else dfs(dept+1, i, arr, tmp);
            }
        }
    }
}
