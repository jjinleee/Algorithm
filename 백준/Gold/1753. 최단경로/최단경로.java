import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int to;
    int weight;

    Edge(int to,int weight){
        this.to=to;
        this.weight=weight;
    }

    public int compareTo(Edge o){
        return this.weight-o.weight;
    }
}

public class Main {
    static final int INF=Integer.MAX_VALUE;
    static List<Edge>[] graph;
    static int[] dist; //시작정점으로부터 최단 거리 배열
 
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph=new ArrayList[V+1];
        for(int i=1;i<=V; i++){
            graph[i]=new ArrayList<>();
        }
                    
        for(int i=0;i<E; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        //거리배열 초기화 (모두 무한대로)
        dist=new int[V+1];
        Arrays.fill(dist, INF);

        dijkstra(K);
        
        for(int i=1;i<=V;i++){
            if(dist[i]==INF) System.out.println("INF");
            else System.out.println(dist[i]);

        }
    }

    public static void dijkstra(int start){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        dist[start]=0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge cur=pq.poll();
            int curNode=cur.to;
            int curDist=cur.weight;

            //이미 더 짧은 거리로 방문한 적이 있다면 무시
            if(curDist> dist[curNode]) continue;


            //현재 정점과 연결된 모든 인접 정점 확인
            for(Edge next : graph[curNode]){
                int nextNode=next.to;
                int nextWeight=next.weight;

                int newDist=dist[curNode]+nextWeight;

                //더짧은 경로를 찾았을 경우 갱신
                if(newDist<dist[nextNode]){
                    dist[nextNode]=newDist;
                    pq.add(new Edge(nextNode, newDist));
                }
            }
        }

    }


}