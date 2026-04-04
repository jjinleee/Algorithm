import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited, computers,n);
                answer++;
            }
        }
        
        
        for(int i=0;i<n;i++){
            if(!visited[i]) dfs(i,visited,computers,n);
        }
        
        return answer;
    }
    
    void dfs(int node,boolean[] visited,int[][] computers,int n){
        visited[node]=true;
        
        for(int i=0;i<n;i++){
            if(!visited[i] && computers[node][i]==1){
                dfs(i,visited,computers,n);
            }
        }
        
        return;
    }
}