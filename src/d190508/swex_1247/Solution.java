package d190508.swex_1247;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int ans = 0;
        for(int test_case=1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int[] start = new int[2];
            int[] end = new int[2];
            boolean[] visited = new boolean[N];
            start[0] = sc.nextInt();      // x
            start[1] = sc.nextInt();      // y
            end[0] = sc.nextInt();      // x
            end[1] = sc.nextInt();      // y
            ArrayList<Cord> cord = new ArrayList<>();
            for(int i=0; i<N; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                Cord c = new Cord(x, y);
                cord.add(c);
            }

            for(int i=0; i<N; i++) {
                int res = 9999;
                for(int j=0; j<N; j++){
                    int ex = cord.get(j).x;
                    int ey = cord.get(j).y;
                    if(res>(Math.abs(start[0]-ex)+Math.abs(start[1]-ey))) {

                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
    }

}
class Cord{
    int x;
    int y;

    Cord(int x, int y){
        this.x = x;
        this.y = y;
    }
}
