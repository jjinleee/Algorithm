import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb =new StringBuilder();
    static List<List<Integer>> graph=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());


        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int v=Integer.parseInt(st.nextToken());

        //그래프초기화
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            //양방향 연결
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (List<Integer> neighbors : graph) {
            Collections.sort(neighbors);
        }

        boolean[] visited=new boolean[n+1];

        
        dfs(v, visited);
        sb.append('\n');

        visited=new boolean[n+1];
        bfs(v, visited);
        
        System.out.println(sb.toString());
    }    
    static void dfs(int node, boolean[] visited){
        sb.append(node).append(" ");

        visited[node]=true;
        for(int next: graph.get(node)){
            if(!visited[next]){
                dfs(next, visited);
            }
        }
    }
    static void bfs(int start, boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        sb.append(start).append(" ");

        while(!q.isEmpty()){
            int next=q.poll();
            for(int n : graph.get(next)){
                if(!visited[n]){
                    q.offer(n);
                    visited[n]=true;
                    sb.append(n).append(" ");
                }
            }
        }
    }
}