import java.util.*;

class Solution {
    static int max=0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited=new boolean[dungeons.length];
        dfs(k,dungeons,0);
        
        return max;
    }
    static void dfs(int k, int[][] dungeons, int cnt){
        max=Math.max(cnt, max);
        
        if(cnt==dungeons.length) return;
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i]=true;
                dfs(k-dungeons[i][1],dungeons,cnt+1);
                visited[i]=false;
            }
        }
    }
}