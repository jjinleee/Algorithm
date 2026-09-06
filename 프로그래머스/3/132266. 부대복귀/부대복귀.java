import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer=new int[sources.length];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        
        for(int[] r : roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        
        
        Queue<Integer> q=new LinkedList<>();        
        int[] dist=new int[n+1];
        Arrays.fill(dist,-1);
        
        q.offer(destination);
        dist[destination]=0;
        
        while(!q.isEmpty()){
            int cur=q.poll();
            
            for(int next : graph.get(cur)){
                if(dist[next]!=-1) continue;
                
                dist[next]=dist[cur]+1;
                q.offer(next);
            }
        }
        
        for(int i=0;i<sources.length;i++){
            answer[i]=dist[sources[i]];
        }
        
        return answer;
    }
}