import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int cnt=0;
        for(int s : scoville){
            pq.add(s);
        }
        
        while(pq.size()>=2 && pq.peek()<K){
            cnt++;
            int mix=pq.poll()+2*pq.poll();
            pq.add(mix);
        }
        
        if(pq.peek()<K) return -1;
        
        return cnt;
    }
}