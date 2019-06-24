package d190624;

import java.util.Scanner;

// SWEA 4112 이상한 피라미드
public class Solution {

    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int temp;
            if(A<B) {           // A가 B보다 커야한다.
                temp = A;
                A = B;
                B = temp;
            }
            int ans = 0;
            if(A!=B) {
                int[] cordA = whereIsIt(A);
                int[] cordB = whereIsIt(B);

                int gapY = cordA[1]-cordB[1];
                int gapX = Math.abs(cordA[0]-cordB[0]);
                if (cordA[0]>cordB[0]){
                    if(gapX>gapY) {
                        ans = gapX;
                    } else {
                        ans = gapY;
                    }
                } else ans = gapX + gapY;
                ans = ans==0?1:ans;
            }
            System.out.println("#"+testCase + " "+ans);
        }
        sc.close();
    }

    static int[] whereIsIt(int n) {
        int[] cord = new int[2];
        for (int i = 1; i <= 141; i++) {
            if (i * (i + 1) >= 2 * n) {
                cord[1] = i;
                cord[0] = i-((i*(i+1))/2)+n;
                break;
            }
        }
        return cord;
    }
}
