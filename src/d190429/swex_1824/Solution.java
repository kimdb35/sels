package d190429.swex_1824;

import java.util.Scanner;

public class Solution {

    static boolean[][][][] log = new boolean[20][20][16][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case=1; test_case<=T; test_case++){
            int ans = 0;
            int R = sc.nextInt();
            int C = sc.nextInt();

            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){

                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
    }

    static boolean isFirst(int x, int y, int mem, int dir){
        return false;
    }
}
