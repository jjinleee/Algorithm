import java.util.*;

class Solution {
    class Node{
        int to;
        int cost;
        
        Node(int to, int cost){
            this.to=to;
            this.cost=cost;
        }
        
    }
    public int solution(int N, int[][] road, int K) {
        int[] dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<List<Node>> graph=new ArrayList<>();
        for(int i=0;i<=N;i++) graph.add(new ArrayList<>());
        
        for(int[] r: road){
            graph.get(r[0]).add(new Node(r[1],r[2]));
            graph.get(r[1]).add(new Node(r[0],r[2]));
        }
        
        //비용순오름차순
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)-> a.cost-b.cost);
        pq.offer(new Node(1,0));
        dist[1]=0;
        
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            
            if(dist[cur.to]<cur.cost) continue;
            
            for(Node next : graph.get(cur.to)){
                int newCost=next.cost+cur.cost;
                
                if(newCost<dist[next.to]){
                    dist[next.to]=newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }

        int answer=0;
        for(int d : dist){
            if(d<=K) answer++;
        }

        return answer;
    }
}