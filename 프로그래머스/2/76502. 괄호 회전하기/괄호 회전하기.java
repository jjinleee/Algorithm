import java.util.*;

class Solution {
    public int solution(String s) {
        int answer=0;
        Queue<Character> q=new LinkedList<>();
        for(char c : s.toCharArray()) q.offer(c);
        int n=s.length();
        
        if(isCorrect(q)) answer++;
        
        for(int i=0;i<n-1;i++){
            q.offer(q.poll());
            if(isCorrect(q)) answer++;
        }
        return answer;
    }
    boolean isCorrect(Queue<Character> q){
        Stack<Character> stack=new Stack<>();
        for(char c : q){
            if(c=='['||c=='{'||c=='(') stack.push(c);
            else{
                if(stack.isEmpty())  return false;
                if(stack.peek()=='(' && c!=')') return false;
                if(stack.peek()=='{' && c!='}') return false;
                if(stack.peek()=='[' && c!=']') return false;  
                stack.pop();
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}