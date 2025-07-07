import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.offer(new int[]{i,priorities[i]});
        }
        
        int order=1;
        
        while(!queue.isEmpty()){
            int[] next=queue.poll();
            
            boolean hasHigher= queue.stream().anyMatch(p->p[1]>next[1]);
            if(hasHigher){
                queue.offer(next);
            }
            else{
                if(next[0]==location) return order;
                order++;
            }
        }
        
        return 0;
    }
}