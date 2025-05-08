import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer=0;
    public int solution(int k, int[][] dungeons) {
        visited=new boolean[dungeons.length];
        dfs(k,dungeons,0);
        
        return answer;
    }
    static void dfs(int tired, int[][] dungeons, int ans){
        answer=Math.max(ans, answer);
        
        if(ans==dungeons.length) return;
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && dungeons[i][0]<=tired){
                visited[i]=true;
                dfs(tired-dungeons[i][1], dungeons, ans+1);
                visited[i]=false;
            }
        }
    }
}