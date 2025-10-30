import java.util.*;

class Solution {
    static List<List<Integer>> graph=new ArrayList<>();
    static int max=0;
    public int solution(int n, int[][] edge) {
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] dist=new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        dist[1]=0;
        
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int next: graph.get(curr)){
                if(dist[next]!=-1) continue;
                dist[next]=dist[curr]+1;
                q.add(next);
            }
        }
       
        int maxDist = 0;
        for (int i = 1; i <= n; i++) maxDist = Math.max(maxDist, dist[i]);

        int answer = 0;
        for (int i = 1; i <= n; i++) if (dist[i] == maxDist) answer++;

        return answer;
    }
}