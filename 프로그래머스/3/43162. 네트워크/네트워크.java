import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited= new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                dfs(n, visited, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    void dfs(int n, boolean[] visited,int[][] computers, int node){
        if(!visited[node]){
            visited[node]=true;
            for(int i=0;i<n;i++){
                if(computers[node][i]==1 && !visited[i]){
                    dfs(n,visited, computers, i);
                }
            }
        }
        return;
    }
}