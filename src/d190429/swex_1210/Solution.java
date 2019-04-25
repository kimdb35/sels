package d190429.swex_1210;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int sldkfja=0; sldkfja<10; sldkfja++) {
            int[][] map = new int[102][102];
            int ans = 0;
            int iniX = 0;
            int iniY = 0;
            int test_case = sc.nextInt();
            for(int i=0; i<102; i++){
                for(int j=0; j<102; j++){
                    if(i==0 || j==0 || i==101 || j==101) map[i][j] = 0;
                    else {
                        map[i][j] = sc.nextInt();
                        if(map[i][j] == 2) {
                            iniX = j;
                            iniY = i;
                        }
                    }
                }
            }
            ans = move(map, iniX, iniY);
            System.out.println("#"+test_case+" "+ans);
        }
        sc.close();
    }

    static int move(int[][] map, int x, int y) {
        while(y>=0){
            if(y==0) {
                return x;
            }
            if(map[y][x+1]!=0) {
                while(map[y][++x+1]!=0);
            } else if(map[y][x-1]!=0) {
                while(map[y][--x-1]!=0);
            }
            y--;
        }
        return -1;
    }

}
