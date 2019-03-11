package etc;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Integer>[] arr = new ArrayList[2];

		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(3);
		
		arr[0] = a1;
	}
}
