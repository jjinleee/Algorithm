import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        boolean[] visited;
        for(int i=0;i<wires.length;i++){
            List<List<Integer>> graph=new ArrayList<>();
            for(int j=0;j<=n;j++){
                graph.add(new ArrayList<>());
            }
            
            for(int j=0;j<wires.length;j++){
                if(i==j) continue;
                int a=wires[j][0];
                int b=wires[j][1];
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            visited=new boolean[n+1];
            int cnt=bfs(1,visited,graph);
            int diff=Math.abs(n-2*cnt);
            answer=Math.min(diff, answer);
        }
        return answer;
    }
    static int bfs(int start, boolean[] visited, List<List<Integer>> graph){
        int cnt=1;
        
        visited[start]=true;
        Queue<Integer> q=new LinkedList<>();
        
        q.offer(start);
        
        while(!q.isEmpty()){
            int cur=q.poll();
                for(int next: graph.get(cur)){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next]=true;
                        cnt++;
                    }
                }
            }
        return cnt;
        

    }
}