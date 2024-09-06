import java.util.*;
import java.io.*;


class Solution {
    public String solution(String p) {        
        if(check(p))
			return p;
		return rec(p);
    }
    
    public static String rec(String p){
        //1.빈문자열일 경우 그대로 반환
        if(p.equals("")) return "";
        //2. u,v로 분리
        String u="";
        String v="";
        
        int left=0; 
        int right=0;
        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            if(c=='(') left++;
            else right++;
            
            //left==right일때 u,v로 분리
            if((left==right) && left>0 && right>0){
                u=p.substring(0,i+1);
                v=p.substring(i+1);
                break;
            }
        }
        // 3. 문자열 u가 "올바른 괄호 문자열"이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.        
        if(check(u)) return u+rec(v);
        
        //4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
        else {
            u=u.substring(1,u.length()-1);
            StringBuilder sb= new StringBuilder();
            
            for(int i=0;i<u.length();i++){
                if(u.charAt(i)=='(') sb.append(')');
                else sb.append('(');
            }
          
            return '('+rec(v)+')'+ sb.toString();
        }
    }
        
    
    //올바른 괄호 문자열인지 체크
    public static boolean check(String p) {
		Stack<Character> stack = new Stack<>();
        
		for(int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if(c == '(')
				stack.push(c);
			else {
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
		}

		return true;
	}
}