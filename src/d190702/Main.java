package d190702;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] table = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                table[i][j] = sc.nextInt();
            }
        }

        int[] rMax = new int[N];
        int[] cMax = new int[M];

        Arrays.fill(rMax, 0);
        Arrays.fill(cMax, 0);
        int sum = 0;

        if(N < M){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    int maximum = table[i][j];
                    if(maximum > rMax[i]) rMax[i] = maximum;
                }
                sum += rMax[i];
            }
        }else if(N >= M){
            for(int j=0; j<M; j++){
                for(int i=0; i<N; i++){
                    int maximum = table[i][j];
                    if(maximum > cMax[i]) cMax[i] = maximum;
                }
                sum += rMax[j];
            }
        }

        System.out.println(sum);
        sc.close();
    }
}