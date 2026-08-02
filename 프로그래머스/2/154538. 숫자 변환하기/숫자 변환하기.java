import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<int[]> q=new LinkedList<>();
        boolean[] visited=new boolean[y+1];
        
        q.offer(new int[]{x,0});
        visited[x]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int num=cur[0];
            int cnt=cur[1];
            
            if(num==y) return cnt;
            
            int c1=num+n;
            int c2=num*2;
            int c3=num*3;
            
            if(c1<=y && !visited[c1]){
                q.offer(new int[]{c1,cnt+1});
                visited[c1]=true;
            }
            if(c2<=y && !visited[c2]){
                q.offer(new int[]{c2,cnt+1});
                visited[c2]=true;
            }
            if(c3<=y && !visited[c3]){
                q.offer(new int[]{c3,cnt+1});
                visited[c3]=true;
            }
        }   
            
        return -1;
    }
}