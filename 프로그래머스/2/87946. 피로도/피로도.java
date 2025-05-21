import java.util.*;

class Solution {
    static int max=0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited=new boolean[dungeons.length];
        dfs(k,dungeons,visited,0);
        
        return max;
    }
    //모든경로를 탐색하는 dfs에 오류있음
    static void dfs(int k, int[][] dungeons, boolean[] visited,int cnt){   
        max=Math.max(max, cnt);
            
        for(int i=0;i<dungeons.length;i++){
            //방문하지 않았고 최소필요도 만족하면
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i]=true;
                dfs(k-dungeons[i][1], dungeons, visited,cnt+1);
                visited[i]=false;
                
            }
        }
    }
}