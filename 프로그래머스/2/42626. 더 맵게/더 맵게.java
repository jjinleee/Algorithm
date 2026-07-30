import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int s : scoville) pq.add(s);
        
        while(pq.size()>=2 && pq.peek()<K){
            int newfood=pq.poll()+pq.poll()*2;
            pq.offer(newfood);
            answer++;
        }
        
        if(pq.peek()<K) return -1;
        
        return answer;
    }
}