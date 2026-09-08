import java.util.*;

class Solution {
    int n;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n=n;
        visited= new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int node, int[][] computers){
        visited[node]=true;
        
        for(int i=0;i<n;i++){
            if(!visited[i]&& computers[node][i]==1){
                dfs(i, computers);
            }
        }
        
        
        return;
    }
}