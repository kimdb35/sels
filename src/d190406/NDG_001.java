package d190406;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NDG_001 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] str = new String[n];
		List<String> strList = new ArrayList<String>();
		String ans = "";
		String ans2 = "";
		
		for(int i=0; i<n; i++) {
			str[i] = sc.nextLine();
			strList.add(str[i]);
		}
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			String tmp = "1";
			for(int j=97; j<=122; j++) {
				int res = str[i].indexOf((char) j);
				if(res==-1) {
					tmp = "0";
					break;
				}
			}
			ans += tmp;
		}
		ans2 = isPangram(strList);
		System.out.println(ans);
		System.out.println(ans2);
		
		sc.close();
	}
	
	static String isPangram(List<String> strings) {
		String ans = "";
		for(int i=0; i<strings.size(); i++) {
			String tmp = "1";
			for(int j=97; j<=122; j++) {
				int res = strings.get(i).indexOf((char) j);
				if(res == -1) {
					tmp = "0";
					break;
				}
			}
			ans += tmp;
		}
		return ans;
	}

}
