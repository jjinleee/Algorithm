import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited=new boolean[n];
        
        int answer=0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(visited, computers, i);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(boolean[] visited, int[][] computers,int node ){
        visited[node]=true;
        
        for(int i=0;i<computers.length;i++){
            if(!visited[i] && computers[node][i]==1){
                dfs(visited, computers, i);
            }
        }
    }
    
}