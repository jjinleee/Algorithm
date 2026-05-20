import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        if(pq.peek()>=K) return 0;
        
        while(pq.size()>=2 && pq.peek()<K){
            pq.add(pq.poll()+2*pq.poll());
            answer++;
            
            if(pq.peek()>=K) return answer;
        }
        
        return -1;
    }
}