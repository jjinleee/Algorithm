import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q=new LinkedList<>();
        int[] freq=new int[10];
        for(int i=0;i<priorities.length;i++){
            q.offer(new int[]{i,priorities[i]});
            freq[priorities[i]]++;
        }
        int cnt = 0;
        int max= 9;
        
        while(max>0 && freq[max]==0) max--;
        
        
    while(!q.isEmpty()){
        int[] cur=q.peek();
        int p=cur[1];
        
        if(p<max){
            q.offer(q.poll());
        } else{
            q.poll();
            cnt++;
            freq[p]--;
            
            if(cur[0]==location) return cnt;
            while(max>0 && freq[max]==0) max--;
        }
    }
        return cnt;
    }
}