import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int len=queue1.length;
        long sum1=0;
        long sum2=0;
        
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        
        for(int q : queue1){
            sum1+=q;
            q1.offer(q);
        }
        for(int q : queue2){
            sum2+=q;
            q2.offer(q);
        }
        if((sum1+sum2)%2==1) return -1; //같게만들수없음
        long sum=(sum1+sum2)/2;
        
        while(sum1!=sum){
            int n=0;
            if(sum1>sum2){
                n=q1.poll();
                sum1-=n;
                sum2+=n;
                q2.offer(n); 
            } else {
                n=q2.poll();
                sum2-=n;
                sum1+=n;
                q1.offer(n);
            }
            answer++;  
           
            if(answer>3*len) return -1; 
        }
        
        return answer;
    }
}