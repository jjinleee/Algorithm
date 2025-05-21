import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<wires.length;i++){
            //트리 초기화
            List<List<Integer>> tree= new ArrayList<>();
            for(int j=0;j<=n;j++){
                tree.add(new ArrayList<>());
            }
            //간선 하나씩 제거
            for(int j=0;j<wires.length;j++){
                if(i==j) continue;
                int a=wires[j][0];
                int b=wires[j][1];
                
                tree.get(a).add(b);
                tree.get(b).add(a);
            }
            
            int cnt=bfs(1,tree,n);
            int diff=Math.abs(n-2*cnt);
            answer=Math.min(answer, diff);
        }        
        return answer;
    }
    //한쪽 네트워크에 연결된 노드 수를 셈
    static int bfs(int start, List<List<Integer>> tree,int n){
        //외부에 전달할 필요없이 내부에서 독립적으로 세면되니까 내부에서 visited 정의
        boolean[] visited=new boolean[n+1];
        Queue<Integer> queue=new LinkedList<>();
        
        queue.offer(start); //시작노드삽입
        visited[start]=true; 
        
        int cnt=1;
        
        while(!queue.isEmpty()){
            int current=queue.poll();
            for(int next : tree.get(current)){
                if(!visited[next]){
                    visited[next]=true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}