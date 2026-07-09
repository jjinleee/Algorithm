import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i=0;i<wires.length;i++){
            List<List<Integer>> graph=new ArrayList<>();
            for(int j=0;j<=n;j++) graph.add(new ArrayList<>());
            
            boolean[] visited=new boolean[n+1];
            for(int j=0;j<wires.length;j++){
                if(i==j) continue;
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            
            int cnt=bfs(1,visited, graph);
            answer=Math.min(Math.abs(2*cnt-n),answer);
        }
        return answer;
    }
    int bfs(int start, boolean[] visited, List<List<Integer>> graph){
        int cnt=1;
        
        visited[start]=true;
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next]=true;
                    q.offer(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}