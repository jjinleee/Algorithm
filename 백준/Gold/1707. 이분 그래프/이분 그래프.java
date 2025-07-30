import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] color; //0:미방문, 1,-1 : 색
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int k=Integer.parseInt(st.nextToken());

        
        for(int t=0;t<k;t++){
            st=new StringTokenizer(br.readLine());
            int V=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());

            graph=new ArrayList[V+1];
            for(int i=1;i<=V; i++){
                graph[i]=new ArrayList<>();
            }

            
            for(int i=0;i<E; i++){
                st=new StringTokenizer(br.readLine());
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            sb.append(isBipartite(V)? "YES" : "NO").append('\n');
        }

        System.out.println(sb.toString());
    }

    public static boolean bfs(int start){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        color[start]=1;

        while(!q.isEmpty()){
            int cur=q.poll();
            for(int next: graph[cur]){
                if(color[next]==0){
                    color[next]=-color[cur];
                    q.add(next);
                } else if(color[next]==color[cur]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int n){
        color=new int[n+1];
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                if(!bfs(i)) return false;
            }
        }

        return true;
    }
}