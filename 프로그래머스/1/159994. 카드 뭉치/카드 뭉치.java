import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1=new ArrayDeque<>();
        Queue<String> c2=new ArrayDeque<>();

        for(int i=0;i<cards1.length;i++){
            c1.add(cards1[i]);
        }
        for(int i=0;i<cards2.length;i++){
            c2.add(cards2[i]);
        } 
        
        String answer="Yes";
        for(int i=0;i<goal.length;i++){
            if(!c1.isEmpty() && c1.peek().equals(goal[i])){
                c1.poll();
            } 
            else if(!c2.isEmpty() && c2.peek().equals(goal[i])){
                c2.poll();
            } else return "No";
        }
        return answer;
    }
}