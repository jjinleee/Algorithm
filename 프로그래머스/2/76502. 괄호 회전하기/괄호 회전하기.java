import java.util.*;

class Solution {
    public int solution(String s) {        
        int n=s.length();
        int cnt=0;
        
        for(int i=0;i<n;i++){
            if(isValid(s)) cnt++;
            s=rotateLeft(s);
        }
        
        return cnt;
    }
    
    public boolean isValid(String s){
        Stack<Character> stack= new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            } else{
                if(stack.isEmpty()) return false;
                
                char top=stack.pop();
                if((c==')' && top!='(') ||
                  (c==']' && top!='[') ||
                  (c=='}' && top!='{')) return false;
            }
        }
        return stack.isEmpty();
    }
    public String rotateLeft(String s){
        return s.substring(1)+s.charAt(0);
    }
}