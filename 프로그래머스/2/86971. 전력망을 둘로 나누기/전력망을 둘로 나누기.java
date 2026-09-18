import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        for(int i=0;i<wires.length;i++){
            //초기화
            List<List<Integer>> list=new ArrayList<>();
            for(int j=0;j<=n;j++) list.add(new ArrayList<>());
            
            for(int j=0;j<wires.length;j++){
                if(i==j) continue; //하나씩 건너뜀
                list.get(wires[j][0]).add(wires[j][1]);
                list.get(wires[j][1]).add(wires[j][0]);
            }
            
            boolean[] visited=new boolean[n+1];
            int cnt=dfs(1,list,visited);
            answer=Math.min(answer, Math.abs(n-2*cnt));//최소차이갱신
        }
        return answer;
    }
    int dfs(int node,List<List<Integer>> list, boolean[] visited){
        visited[node]=true;
        int cnt=1;
        
        for(int next : list.get(node)){
            if(!visited[next]){
                visited[next]=true;
                cnt+=dfs(next, list, visited);
            }
        }
        
        return cnt;
    }
}