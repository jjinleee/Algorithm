import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited= new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
               dfs(computers,n, i, visited);
               answer++;
            }
        }
        return answer;
    }
    static void dfs(int[][] computers,int n, int node, boolean[] visited ){
        visited[node]=true;
        
        for(int i=0;i<n;i++){
            if(computers[node][i]==1 && !visited[i]){
                dfs(computers,n, i, visited);
            }
        }
    }
}