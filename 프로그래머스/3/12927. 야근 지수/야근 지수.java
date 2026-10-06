import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) pq.offer(w);
        
        while(n>0 && !pq.isEmpty()){
            int did=pq.poll()-1;
            n--;
            if(did==0) continue;
            
            pq.offer(did);
        }
        
        for(int p : pq){
            answer+=(long)Math.pow(p,2);
        }
        return answer;
    }
}