import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1=0;
        long sum2=0;
        
        Queue<Integer> q1=new ArrayDeque<>();
        Queue<Integer> q2=new ArrayDeque<>();
        for(int q : queue1){
            q1.offer(q);
            sum1+=q;
        }
        for(int q : queue2){
            q2.offer(q);
            sum2+=q;
        }
        
        if(sum1==sum2) return 0;
        if((sum1+sum2)%2==1) return -1;
        int max=3*queue1.length;
        int cnt=0;
        
        while(true){
            if(sum1==sum2) return cnt;
            if(cnt>=max) break;
            
            if(sum1>sum2){
                sum1-=q1.peek();
                sum2+=q1.peek();
                q2.offer(q1.poll());
            } else if(sum1<sum2){
                sum2-=q2.peek();
                sum1+=q2.peek();
                q1.offer(q2.poll());
            }
            cnt++;
        }
        
        
        return -1;
    }
}