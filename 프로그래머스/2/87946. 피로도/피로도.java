import java.util.*;

class Solution {
    static int max=0;
    public int solution(int k, int[][] dungeons) {        
        boolean[] visited=new boolean[dungeons.length];
        dfs(dungeons, 0, visited, k);
        return max;
    }
    static void dfs(int[][] dungeons, int cnt, boolean[] visited, int cur){

        max=Math.max(max,cnt);
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && cur>=dungeons[i][0]){
                visited[i]=true;
                dfs(dungeons, cnt+1, visited, cur-dungeons[i][1]);
                visited[i]=false;
            }
        }
    }
}