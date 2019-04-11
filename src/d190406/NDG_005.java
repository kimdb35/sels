package d190406;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NDG_005 {

   static int N, ans = 0;
   static boolean[][] arr;
   static boolean[] visit;
   static Set<String> set = new HashSet<String>();
   static int count = 0;

   static void solve(int n, List<Integer> a, List<Integer> b) throws NumberFormatException, IOException {
      N = n;
      arr = new boolean[N + 1][N + 1];
      visit = new boolean[N + 1];

      for (int i = 0; i <= N; i++) {
         for (int j = 0; j <= N; j++) {
            arr[i][j] = true;
         }
      }

      for (int i = 0; i < a.size(); i++) {
         arr[a.get(i)][b.get(i)] = false;
         arr[b.get(i)][a.get(i)] = false;
      }

      for (int i = 0; i <= N; i++) {
         arr[i][i] = false;
      }
      for(int i=1; i<=N; i++) {
         for(int j=i; j<=N; j++) {
            boolean flag = true;
            for(int k=i; k<j; k++) {
               if(!arr[k][j]) {
                  flag = false;
                  break;
               }               
            }
            if(flag) {
               count++;
            }else {
               break;
            }
         }
      }
   }

   public static void main(String[] args) throws NumberFormatException, IOException {
      int n = 5;

      int[] ta = { 2, 1, 2 };
      int[] tb = { 2, 3, 5 };

      List<Integer> a = new LinkedList<Integer>();
      List<Integer> b = new LinkedList<Integer>();

      for (int i = 0; i < ta.length; i++) {
         a.add(ta[i]);
         b.add(tb[i]);
      }

      solve(n, a, b);

      System.out.println(count);
   }

}