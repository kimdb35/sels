package d190623.baek_8958;

import java.util.Scanner;

public class Main {

    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int testCase = 0; testCase < T; testCase++) {
            String str = sc.next();
            String[] strArr = str.split("");
            int ans = 0;
            int temp = 0;
            for(int i=0; i<strArr.length; i++) {
                if(strArr[i].equals("X")) {
                    temp = 0;
                } else {
                    temp++;
                    ans += temp;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
