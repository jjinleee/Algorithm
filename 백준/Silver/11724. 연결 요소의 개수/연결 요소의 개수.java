import java.io.*;
import java.util.*;


public class Main { 
    static boolean[] visited;
    static int n,m;
    static int[] node;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        visited= new boolean[n+1];
        node=new int[n+1];
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        //덩어리개수 세면됨
        int count=0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    static void dfs(int n){
        visited[n]=true;

        for(int node:graph[n]){
            if(!visited[node]){
                dfs(node);
            }
        }
    }
}