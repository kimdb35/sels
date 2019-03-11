package etc;

import java.util.Scanner;

public class Q_1152 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String[] arr = str.trim().split(" ");
		if(arr[0].equals("")) System.out.println("0");
		else System.out.println(arr.length);
		sc.close();
	}

}
