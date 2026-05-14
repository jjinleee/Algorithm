import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        
        
        for(int i=0;i<wires.length;i++){
            //그래프초기화
            List<List<Integer>> graph=new ArrayList<>();
            for(int j=0;j<=n;j++) graph.add(new ArrayList<>());
            
            boolean[] visited=new boolean[n+1];
            for(int j=0;j<wires.length;j++){
                if(i==j) continue; //하나씩 끊기
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            
            //두개 차이 구하기
            int cnt=bfs(1, visited, graph );
            int diff=Math.abs(cnt*2-n);
            answer=Math.min(diff, answer);
        }
        
        return answer;
    }
    int bfs(int start, boolean[] visited, List<List<Integer>> graph){
        int cnt=1;
        
        visited[start]=true;
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next : graph.get(cur)){
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