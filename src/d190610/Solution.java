package d190610;

import java.util.LinkedList;
import java.util.Scanner;

// 1226 미로 1
public class Solution {

    static int[][] MAP = new int[18][18];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int testCase = 1; testCase <= 10; testCase++) {
            boolean[][] visited = new boolean[18][18];
            String t = sc.next();
            int[] start = new int[2];
            int ans = 0;
            for(int i=0; i<18; i++) {
                if(i!=0 && i!=17){
                    String str = sc.next();
                    String[] strArr = str.split("");
                    for(int j=0; j<strArr.length; j++) {
                        MAP[i][j+1] = Integer.parseInt(strArr[j]);
                        if(MAP[i][j+1]==2) {
                            start[0] = j+1;
                            start[1] = i;
                        }
                    }
                }
                MAP[0][i] = 8;
                MAP[i][0] = 8;
                MAP[i][17] = 8;
                MAP[17][i] = 8;
            }

            System.out.println("====="+testCase);
            for(int i=0; i<18; i++) {
                for(int j=0; j<18; j++) {
                    System.out.print(MAP[i][j]+"");
                }
                System.out.println();
            }
            System.out.println("====="+testCase);

            LinkedList<Cord_1226> que = new LinkedList<>();
            que.add(new Cord_1226(start[0], start[1]));
            while(!que.isEmpty()) {
                if(ans==1) break;
                Cord_1226 cd = que.get(0);
                que.removeFirst();
                int x = cd.getX();
                int y = cd.getY();
                for(int dir=0; dir<4; dir++){
                    if(MAP[y+dy[dir]][x+dx[dir]]==0 && !visited[y+dy[dir]][x+dx[dir]]) {
                        que.add(new Cord_1226(x+dx[dir], y+dy[dir]));
                        visited[y+dy[dir]][x+dx[dir]] = true;
                    } else if(MAP[y+dy[dir]][x+dx[dir]]==3 && !visited[y+dy[dir]][x+dx[dir]]) ans = 1;
                }
            }

            System.out.println("#"+testCase+" "+ans);
        }
        sc.close();
    }

}

class Cord_1226{
    private int x;
    private int y;

    Cord_1226(){}

    Cord_1226(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

}
