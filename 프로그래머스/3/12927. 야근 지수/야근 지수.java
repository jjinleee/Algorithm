import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long sum = 0;
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works) {
            sum+=w;
            q.offer(w);
        }
        if(sum<=n) return 0; //작업모두마침
        
        while(n>0){
            q.offer(q.poll()-1);
            n--;
        }
        
        long answer=0;
        for(int m:q) {
            answer+=(long)m*m;
            System.out.println(m);
        }
        
        
        
        return answer;
    }
}