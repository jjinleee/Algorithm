import java.util.*;

class Solution {
    int n;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n=n;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    void dfs(int[][] computers, boolean[] visited, int idx ){
        if(!visited[idx]){
            visited[idx]=true;
            for(int i=0;i<n;i++){
                if(computers[idx][i]==1){
                    dfs(computers, visited, i);
                }
            }
        }
        
    }
}