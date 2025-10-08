import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        int cnt=0;
        while(pq.size()>=2 && pq.peek()<K){
            int m1=pq.poll();
            int m2=pq.poll();
            pq.add(m1+2*m2);
            cnt++;
        }
        
        
        return pq.peek()>=K ? cnt : -1;
    }
}