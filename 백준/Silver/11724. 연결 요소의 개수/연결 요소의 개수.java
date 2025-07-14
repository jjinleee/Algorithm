import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static boolean[] visited;
    static List<List<Integer>> graph=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int cnt=0;

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        visited=new boolean[n+1];

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


        for(int i=1;i<=n;i++){
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    static void bfs(int node){
        Queue<Integer> q= new LinkedList<>();
        
        q.offer(node);
        visited[node]=true;

        while(!q.isEmpty()){
            int next=q.poll();
            for(int n : graph.get(next)){
                if(!visited[n]){
                    q.offer(n);
                    visited[n]=true;
                }
            }

        }
        
    }
}