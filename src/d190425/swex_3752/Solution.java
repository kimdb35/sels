package d190425.swex_3752;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            int ans = 0;
            int N = sc.nextInt();
            
            int[] qArray = new int[N];
            
            for(int i=0; i<N; i++) {
            	qArray[i] = sc.nextInt();
            }
            
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
    }
}
