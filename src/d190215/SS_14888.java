package d190215;
import java.util.Scanner;

public class SS_14888 {
	
	static int[] number;
	static int[] oper = new int[4];
	static int min=1000000000;
	static int max=-1000000000;
	
	public static void main(String[] args) {
	
		char[] op;
		int opCnt = 0;
		int numCnt;
		
		Scanner sc = new Scanner(System.in);
		
		numCnt = sc.nextInt();
		number = new int[numCnt];
		for(int i=0; i<numCnt; i++) {
			number[i] = sc.nextInt();
		}
		for(int i=0; i<4; i++) {
			oper[i] = sc.nextInt();
			opCnt += oper[i];
		}
		op = new char[opCnt];
		int k = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<oper[i]; j++) {
				switch(i) {
				 case 0:
					 op[k] = '+';
					 k++;
					 break;
				 case 1:
					 op[k] = '-';
					 k++;
					 break;
				 case 2:
					 op[k] = '*';
					 k++;
					 break;
				 case 3:
					 op[k] = '/';
					 k++;
					 break;
				}
			}
		}
		
		permutation(op, 0);
		
		System.out.println(max);
		System.out.println(min);
		
		sc.close();
	}
	
	static int calculate(int[] nArr, char[] oArr) {
		int result=nArr[0];
		for(int i=0; i<oArr.length; i++) {
			switch(oArr[i]) {
				case '+':
					result = result + nArr[i+1];
					break;
				case '-':
					result = result - nArr[i+1];
					break;
				case '*':
					result = result * nArr[i+1];
					break;
				case '/':
					result = result / nArr[i+1];
					break;
			}
		}
		return result;
	}
	
	static void permutation(char[] arr, int idx) {
		if(idx==arr.length) {
			int res = calculate(number, arr);
			min = min>res?res:min;
			max = max>res?max:res;
			return;
		}
		for(int i=idx; i<arr.length; i++) {
			swap(arr, i, idx);
			permutation(arr, idx+1);
			swap(arr, i, idx);
		}
	}
	
	static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
