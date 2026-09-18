import java.util.*;

class Solution {
    int answer=0;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited=new boolean[dungeons.length];
        
        dfs(k,dungeons,0);
    
        
        return answer;
    }
    void dfs(int left, int[][] dungeons, int cnt){
        answer=Math.max(answer, cnt);
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && left>=dungeons[i][0]){
                visited[i]=true;
                dfs(left-dungeons[i][1],dungeons, cnt+1);
                visited[i]=false;
            }
        }
       
    }
}