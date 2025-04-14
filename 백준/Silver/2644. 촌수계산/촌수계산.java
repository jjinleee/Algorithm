import java.io.*;
import java.util.*;


public class Main { 
    static int n,p1,p2;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        p1=Integer.parseInt(st.nextToken());
        p2=Integer.parseInt(st.nextToken());

        graph=new ArrayList[n+1];
        dist= new int[n+1];
        //그래프 초기화
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        visited=new boolean[n+1];

        int time=Integer.parseInt(br.readLine());
        for(int i=0;i<time;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            //무방향
            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(p1);

        if(dist[p2]==0) System.out.println(-1);
        else System.out.println(dist[p2]);
       
    }
    static void bfs(int start){
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        visited[start]=true;

        while(!queue.isEmpty()){
            int num=queue.poll();

            for(int n : graph[num]){
                if(!visited[n]){
                    queue.add(n);
                    visited[n]=true;
                    dist[n]=dist[num]+1;
                }
            }

        }

    }
}