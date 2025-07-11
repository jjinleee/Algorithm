import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb =new StringBuilder();
    static List<List<Integer>> graph=new ArrayList<>();
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        //그래프초기화
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            StringTokenizer  st=new StringTokenizer(br.readLine());
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
        dfs(1,visited);

        System.out.println(cnt-1); //1번컴퓨터 제외
    }    
    static void dfs(int node, boolean[] visited){
        visited[node]=true;
        cnt++;
        for(int next: graph.get(node)){
            if(!visited[next]){
                dfs(next, visited);
            }
        }
    }
  
}