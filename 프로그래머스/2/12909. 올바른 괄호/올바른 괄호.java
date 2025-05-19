import java.util.*;

//괄호문제는 거의 스택 유형
class Solution {
    boolean solution(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            } else if(!stack.isEmpty() && s.charAt(i)==')'){
                stack.pop();
            } else return false;
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
}