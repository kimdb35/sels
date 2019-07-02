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
        doCombi(9, 7, 0, 0, arr, tmpArr);
        for(int num : ans) {
            System.out.println(num);
        }
        sc.close();
    }

    static void doCombi(int n, int r, int index, int target, int[] arr, int[] ansArr) {
        if(!flag) {
            if(r==0) {
                int res = 0;
                for(int atom : ansArr) {
                    res += atom;
                }
                if(res==100) {
                    ans = ansArr;
                    Arrays.sort(ans);
                    flag = true;
                }
                return;
            } else if(n==target) {
                return;
            } else {
                ansArr[index] = arr[target];
                doCombi(n, r-1, index+1, target+1, arr, ansArr);
                doCombi(n, r, index, target+1, arr, ansArr);
            }
        }
    }

}
