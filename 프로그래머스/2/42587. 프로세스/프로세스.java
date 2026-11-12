import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q=new ArrayDeque<>();//위치,우선순위
        int n=priorities.length;
        for(int i=0;i<n;i++){
            q.offer(new int[]{i,priorities[i]});
        }
        
        
        int order=1;
        while(order<=n) {
            int[] cur=q.poll();
            
            boolean isBig=true;
            for(int[] f : q){
                if(cur[1]<f[1]){
                    q.offer(cur); //우선순위 더높은거있음
                    isBig=false;
                    //System.out.println(cur[0]+" "+"뒤로감");
                    break;
                }
            }
            
            
            if(isBig){
                if(cur[0]==location) return order;
                order++;
            }
        }
        
        return 0;
    }
}