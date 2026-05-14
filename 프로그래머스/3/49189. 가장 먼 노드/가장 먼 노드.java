import java.util.*;

class Solution {
    List<List<Integer>> graph=new ArrayList<>();
    int max=0;
    public int solution(int n, int[][] edge) {
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        
        //양방향 연결
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] dist= new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        dist[1]=0;
        
        while(!q.isEmpty()){
            int cur=q.poll();
            
            for(int next : graph.get(cur)){
                if(dist[next]==-1){
                    dist[next]=dist[cur]+1;
                    q.add(next);
                }
            }
        }
        
        int max=0;
        for(int i=1;i<=n;i++) max=Math.max(max, dist[i]);
        
        int answer=0;
        for(int i=1;i<=n;i++) if(dist[i]==max) answer++;
        
        
        return answer;
    }
    
}