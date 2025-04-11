import java.io.*;
import java.util.*;


public class Main { 
    static int cnt=0;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        
        visited=new boolean[n+1];
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        
        dfs(1);
        System.out.println(cnt-1);
    }
    static void dfs(int node){
        visited[node]=true;
        cnt++;

        for(int n:graph[node]){
            if(!visited[n]){
                dfs(n);
            }
        }
    }
}