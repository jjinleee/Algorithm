import java.util.*;


class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        for(int i=0;i<wires.length;i++){
            List<List<Integer>> graph=new ArrayList<>();
            for(int j=0;j<=n;j++) graph.add(new ArrayList<>());
            
            for(int j=0;j<wires.length;j++){
                if(i==j) continue;
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            
            boolean[] visited=new boolean[n+1];
            int cnt=dfs(1,graph,visited);
            answer=Math.min(answer, Math.abs(2*cnt-n));
            
        }
    
        return answer;
    }
    int dfs(int node, List<List<Integer>> graph,boolean[] visited){
        int cnt=1;
        
        visited[node]=true;
        
        for(int next : graph.get(node)){
            if(!visited[next]){
                cnt+=dfs(next, graph, visited);
            }
        }
        
        return cnt;
    }
}