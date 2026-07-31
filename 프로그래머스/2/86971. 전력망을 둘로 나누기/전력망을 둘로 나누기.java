import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        int cnt=wires.length;
        for(int i=0;i<cnt;i++){
            List<List<Integer>> graph=new ArrayList<>();
            for(int j=0;j<=n;j++) graph.add(new ArrayList<>());
            for(int j=0;j<cnt;j++){
                if(i==j) continue;
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            boolean[] visited= new boolean[n+1];
            int num=dfs(graph,visited, 1);
            int sub=Math.abs(2*num-n);
            
            answer=Math.min(answer, sub);
        }
        
        return answer;
    }
    int dfs(List<List<Integer>> graph, boolean[] visited, int node){
        int cnt=1;
        visited[node]=true;
        
        for(int next: graph.get(node)){
            if(!visited[next]){
                cnt+=dfs(graph, visited, next);
            }
        }
        
        return cnt;
    }
}