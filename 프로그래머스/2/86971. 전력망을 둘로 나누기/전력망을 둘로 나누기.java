import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
    
        //차례대로 하나씩 전선끊음
        for(int i=0;i<wires.length;i++){
            //그래프초기화
            List<List<Integer>> graph=new ArrayList<>();
            for(int j=0;j<=n;j++){
                graph.add(new ArrayList<>());
            }
            for(int j=0;j<wires.length;j++){
                if(i==j) continue; //끊음
                int a=wires[j][0];
                int b=wires[j][1];
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            boolean[] visited=new boolean[n+1];
            
            int cnt=dfs(visited, graph, 1);
            int diff=Math.abs(n-2*cnt);
            
            answer=Math.min(answer, diff);
        }
        return answer;
    }
    
    static int dfs(boolean[] visited, List<List<Integer>> graph, int node){
        visited[node]=true;
        int cnt=1;
        
        for(int next:graph.get(node)){
            if(!visited[next]){
                cnt+=dfs(visited, graph, next);
            }
        }
        return cnt;
    }
}