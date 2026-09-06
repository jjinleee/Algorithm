import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max=0;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        Queue<Integer> q= new LinkedList<>();
        int[] dist=new int[n+1];
        Arrays.fill(dist,-1);
        
        dist[1]=0;
        q.offer(1);
        
        while(!q.isEmpty()){
            int cur=q.poll();
            
            for(int next : graph.get(cur)){
                if(dist[next]!=-1) continue;
                
                q.offer(next);
                dist[next]=dist[cur]+1;
                max=Math.max(dist[next],max);
            }
        }
        
        for(int i=0;i<=n;i++){
            if(dist[i]==max) answer++;
        }
        
        return answer;
    }
}