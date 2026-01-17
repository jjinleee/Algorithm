import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x==y) return 0;
        
        int[] dist=new int[y+1]; //방문안했으면 -1, 했으면 도달횟수 저장
        Arrays.fill(dist,-1);
        
        ArrayDeque<Integer> q= new ArrayDeque<>(); //방문노드 저장용
        q.offer(x);
        dist[x]=0;
        
        while(!q.isEmpty()){
            int cur=q.poll();
            int d=dist[cur];
            
            int a=cur+n;
            int b=cur*2;
            int c=cur*3;
            
            //목표수보다 작고 아직 방문안했다면
            if(a<=y && dist[a]==-1){
                dist[a]=d+1;
                if(a==y) return d+1;
                q.offer(a);
            }
             //목표수보다 작고 아직 방문안했다면
            if(b<=y && dist[b]==-1){
                dist[b]=d+1;
                if(b==y) return d+1;
                q.offer(b);
            }
             //목표수보다 작고 아직 방문안했다면
            if(c<=y && dist[c]==-1){
                dist[c]=d+1;
                if(c==y) return d+1;
                q.offer(c);
            }
        }
        
        return -1;
    }
}