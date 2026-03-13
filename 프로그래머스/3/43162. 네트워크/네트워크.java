import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited=new boolean[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j]==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, visited,graph );
                answer++;
            }
        }
        return answer;
    }
    void dfs(int node, boolean[] visited, List<List<Integer>> graph){
        if(!visited[node]){
            visited[node]=true;
            for(int next : graph.get(node)){
                dfs(next, visited, graph);
            }
        }
        
        return;
    }
}