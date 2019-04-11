package d190406;

import java.util.Scanner;

public class HK_0001 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[6][6];
		int answer = 0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				int temp = hourglass(map, j, i);
				answer = answer>temp?answer:temp;
			}
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	
	static int hourglass(int[][] map, int ix, int iy) {
		int sum = 0;
		sum = map[iy][ix]+map[iy][ix+1]+map[iy][ix+2]+map[iy+1][ix+1]+map[iy+2][ix]+map[iy+2][ix+1]+map[iy+2][ix+2];
		return sum;
	}

}
