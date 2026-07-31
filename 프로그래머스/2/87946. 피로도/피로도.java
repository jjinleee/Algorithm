import java.util.*;

class Solution {
    int answer=0;
    public int solution(int k, int[][] dungeons) {
        int n=dungeons.length;
        boolean[] visited=new boolean[n];
        
        dfs(k,0,dungeons, visited);
        
        return answer;
    }
    void dfs(int k, int cnt, int[][] dungeons, boolean[] visited){
        answer=Math.max(answer, cnt);
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i]=true;
                dfs(k-dungeons[i][1], cnt+1, dungeons, visited);
                visited[i]=false;
            }
        }
    }
}