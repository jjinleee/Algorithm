import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<number.length();i++){
            char current=number.charAt(i);
            
            while(!stack.isEmpty() && stack.peek()<current && k>0){
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb= new StringBuilder();
        for(char r : stack){
            sb.append(r);
        }
        
        return sb.toString();
        
    }
}