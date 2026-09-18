import java.util.*;

class Solution {
    List<List<Integer>> orders=new ArrayList<>();
    int n;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        n=dungeons.length;
        boolean[] visited=new boolean[n];
        
        dfs(new ArrayList<>(),visited);
        
        int left=k;
        for(List<Integer> list : orders){
            int cnt=0;
            left=k;
            for(int l : list){
                int need=dungeons[l][0];
                if(left>=need){
                    left-=dungeons[l][1];
                    cnt++;
                } else{
                    break;
                }
            }
            answer=Math.max(answer, cnt);
        }
        
        return answer;
    }
    void dfs(List<Integer> cur, boolean[] visited){
        if(cur.size()==n){
            orders.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                cur.add(i);
                dfs(cur, visited);
                visited[i]=false;
                cur.remove(cur.size()-1);
            }
        }
    }
}