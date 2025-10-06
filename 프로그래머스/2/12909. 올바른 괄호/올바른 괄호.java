import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> q=new Stack<>();
        for(char c : s.toCharArray()){
            if(q.isEmpty()) q.push(c);
            else{
                if(c=='(') q.push(c);
                else{
                    if(q.isEmpty()) return false;
                    q.pop();
                }
            }
        }
        
        return q.isEmpty() ? true: false;
    }
}