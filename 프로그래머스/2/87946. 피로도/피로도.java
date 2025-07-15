import java.util.*;

class Solution {
    static int n;
    static int answer=0;
    public int solution(int k, int[][] dungeons) {
        n=dungeons.length;
        boolean[] visited=new boolean[n];
        
        dfs(k,dungeons,visited,0);
        return answer;
    }
    //던전순서
    static void dfs(int k, int[][] dungeons, boolean[] visited, int cnt ){
        answer=Math.max(answer, cnt);
                
        
        for(int i=0;i<n;i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i]=true;
                dfs(k-dungeons[i][1], dungeons, visited, cnt+1);
                visited[i]=false;
            }
        }
    }
}