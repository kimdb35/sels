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

            if(n>=k) ans = k;
            else {
                for(int i=1; i<=n; i++){
                    if(k>=i) {
                        if(k%i==0){
                            ans = ans * i;
                            k = k/i;
                        }
                    } else break;
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