import java.util.*;

class Solution {
    class Process{
        int priority;
        int loc;
        
        Process(int priority, int loc){
            this.priority=priority;
            this.loc=loc;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> q=new LinkedList<>();
        int idx=0;
        for(int p : priorities) q.offer(new Process(p,idx++));
        
        int order=1;
        while(!q.isEmpty()){
            Process cur=q.poll();
            //우선순위가 더 높은게 있으면
            if(q.stream().anyMatch(p -> p.priority > cur.priority)){
                q.offer(cur);
            } else{
                if(cur.loc==location) return order; //찾는위치면 바로 return
                order++;
            }
            
        }
        return answer;
    }
}