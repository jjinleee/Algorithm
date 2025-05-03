import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        
        while(pq.peek()<K){
            int num=pq.poll()+2*pq.poll();
            pq.add(num);
            answer++;
            
            if(pq.size()==1 && pq.peek()<K) return -1;
        }
        
        return answer;
    }
}