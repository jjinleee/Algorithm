import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int s:scoville){
            queue.add(s);
        }
        
        while(true){
            if(queue.size()<2 && queue.peek()<K) return -1;
            if(queue.peek()>=K) break;
        
            int change=queue.poll() +2*queue.poll();
            queue.add(change);
            answer++;
        }
        
        
        return answer;
    }
}