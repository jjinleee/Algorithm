import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        //오름차순 자동정렬
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        
        int time=0;
        while(true){
            if(pq.peek()>=K) break;
            if(pq.peek()<K && pq.size()==1) return -1; //안만들어질경우
            
            //가장 안매운거 두개 합쳐서 다시 넣기
            int sc=pq.poll()+2*pq.poll();
            pq.add(sc);
            time++;
        }
        
        return time;
    }
}