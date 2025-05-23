import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack=new Stack<>();
        
        
        //내 앞에 나보다 작은게 있다면 뺌
        for(int i=0;i<number.length();i++){
            char current=number.charAt(i);
            
            //스택의 탑과 비교해서 더  작다면 뺌
            while(!stack.isEmpty() && stack.peek()<current && k>0){
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        //작은걸 뻈는데 k개가 안된다면 스택의 탑부터 뺌
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb= new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        
        return sb.toString();
    }
}