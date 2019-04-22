package d190419.swex_7466;




// 이거 잘못된 코드다.. 근데 문제는 통과했다. 문제 많다 참


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
            int k = sc.nextInt();
            int ans = 1;
            int temp = 0;

            if(n>=k) ans = k;
            else {
                for(int i=1; i<=n; i++){
                    if(k>=i) {
                        temp = gcd(k, i);
                        ans = ans * temp;
                        k = k/temp;
                    } else {
                        temp = gcd(i, k);
                        ans = ans*temp;
                        k = k/temp;
                    }
                    if(k==1) break;
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }

    static int gcd(int n, int k) {
        if(n%k==0) return k;
        else return gcd(k, n%k);
    }
}