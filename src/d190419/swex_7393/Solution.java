package d190419.swex_7393;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int ans = 0;
            if(n > 10){
            } else if(n==10) ans = 1;
            else ans = 0;

            System.out.println("#"+test_case+" "+ans);
        }

        sc.close();
    }
}