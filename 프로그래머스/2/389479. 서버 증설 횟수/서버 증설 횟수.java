import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q=new ArrayDeque<>();
        for(int time=0;time<=23;time++){
            while(!q.isEmpty() && q.peek()<=time) q.poll();
            
            int cur=q.size();
            int need=players[time]/m;
            if(cur<need){ //서버증설
                int add=need-cur;
                for(int i=0;i<add;i++) q.offer(time+k); 
                answer+=add;
            } 
        }
        return answer;
    }
}