package d190406;

import java.util.Scanner;
import java.util.Stack;

public class NDG_002 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String[] strList = new String[n];
		
		for(int i=0; i<n; i++) {
			strList[i] = sc.nextLine();
		}
		
		String[] ans = isYes(strList);
		
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
		
		sc.close();
	}
	
	static String[] isYes(String[] strArray) {
		String[] ans = new String[strArray.length];
		for(int i=0; i<ans.length; i++) {
			ans[i] = isValid(strArray[i]);
		}
		
		
		return ans;
	}
	
	static String isValid(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = '1';
			switch(str.charAt(i)) {
				case '(':
				case '{':
				case '[':
					stack.push(str.charAt(i));
					break;
				case ')':
					if(stack.isEmpty()) {
						return "NO";
					} else {
						ch = stack.pop();
						if(ch!='(') return "NO";
						break;
					}
				case '}':
					if(stack.isEmpty()) {
						return "NO";
					} else {
						ch = stack.pop();
						if(ch!='{') return "NO";
						break;
					}
				case ']':
					if(stack.isEmpty()) {
						return "NO";
					} else {
						ch = stack.pop();
						if(ch!='[') return "NO";
						break;
					}
			}
		}

		if(stack.isEmpty()) return "YES";
		else return "NO";
	}
}



/*
 *  public boolean testPair(String exp){
        this.exp = exp;
        LinkedStack stack = new LinkedStack();
        expSize = this.exp.length();
 
        for(int i=0; i<expSize; i++){
            testCh = exp.charAt(i);
 
            switch(testCh){
            case '(' :
            case '[' :
            case '{' :
                stack.push(testCh);
                break;
            case ')' :
            case ']' :
            case '}' :
                if(stack.isEmpty()){
                    return false;
                }else{
                    openPair = stack.pop();
                    if((openPair==')') && (testCh!='(') || 
                       (openPair==']') && (testCh!='[') || 
                       (openPair=='}') && (testCh!='{')){
                        return false;
 
                    }else{
                        break;
                    }
                }
            }
        }
 
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
 * */