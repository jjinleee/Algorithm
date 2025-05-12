import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<wires.length;i++){
            List<List<Integer>> tree= new ArrayList<>();
            for(int j=0;j<=n;j++){
                tree.add(new ArrayList<>());
            } 
                
            //트리구성
            for(int j=0;j<wires.length;j++){
                if(i==j) continue;
                int v1=wires[j][0];
                int v2=wires[j][1];

                tree.get(v1).add(v2);
                tree.get(v2).add(v1);
            }
                
            boolean[] visited= new boolean[n+1];

            int cnt=dfs(tree, visited, 1);
            int diff=Math.abs(n-2*cnt);
            answer=Math.min(answer, diff);
                
        }
        return answer;
    }
    
    
    static int dfs(List<List<Integer>> tree, boolean[] visited, int node){
        visited[node]=true;
        int cnt=1;
        
        for(int next : tree.get(node)){
            if(!visited[next]){
                cnt+=dfs(tree, visited, next);
            }
        }
        return cnt;
    }
      
}