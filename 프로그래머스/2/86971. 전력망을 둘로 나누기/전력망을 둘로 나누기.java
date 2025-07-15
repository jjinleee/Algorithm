import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer=n;
        boolean[] visited=new boolean[n+1];
        
        for(int i=0;i<wires.length;i++){
            List<List<Integer>> graph=new ArrayList<>();
            for(int j=0;j<=n;j++){
                graph.add(new ArrayList<>());
            }
            //하나씩 끊어봄 
            for(int j=0;j< wires.length;j++){
                if(i==j) continue;
                int a=wires[j][0];
                int b=wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            visited=new boolean[n+1];
            int cnt=bfs(1,visited,graph);
            int diff=Math.abs(n-2*cnt);
            answer=Math.min(answer, diff);
        }
        return answer;
    
    }
    //송전탑몇개인지 카운트
    static int bfs(int start,boolean[] visited, List<List<Integer>> graph){
        int count=1;
        Queue<Integer> q= new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int n : graph.get(curr)){
                if(!visited[n]){
                    q.offer(n);
                    visited[n]=true;
                    count++;
                }
            }
        }
        return count;
    }

}