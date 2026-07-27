import java.util.*;

class Solution {
    class Node{
        int village;
        int distance;
        
        Node(int village, int distance){
            this.village=village;
            this.distance=distance;
        }
    }
    public int solution(int N, int[][] road, int K) {
        //그래프 초기화
        List<Node>[] graph=new ArrayList[N+1];
        for(int i=0;i<=N;i++) graph[i]=new ArrayList<>();
    
        //도로 정보 저장
        for(int[] r : road){
            int from=r[0];
            int to=r[1];
            int dist=r[2];
            
            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from,dist));
        }
        
        PriorityQueue<Node> pq=new PriorityQueue<>(
            (a,b)-> Integer.compare(a.distance, b.distance)
        );
        pq.offer(new Node(1,0));
        
        int[] dist=new int[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1]=0;
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            
            int curVillage=cur.village;
            int curDistance=cur.distance;
            
            if(curDistance>dist[curVillage]) continue;
            
            for(Node next : graph[curVillage]){
                int newDistance=curDistance+next.distance;
                
                //더짧은거리 발견
                if(newDistance<dist[next.village]){
                    dist[next.village]=newDistance;
                    pq.offer(new Node(next.village, newDistance));
                }
            }
        }
        
        int answer=0;
        for(int i=1;i<=N;i++){
            if(dist[i]<=K) answer++;
        }
        

        return answer;
    }
}