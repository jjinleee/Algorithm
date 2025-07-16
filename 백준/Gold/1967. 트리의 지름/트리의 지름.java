import java.io.*;
import java.util.*;

public class Main {    
    static int n;
    static int maxDist=0;
    static int farNode=0;
    static boolean[] visited;
    static List<List<int[]>> graph=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            //양방향연결
            graph.get(a).add(new int[]{b,v});
            graph.get(b).add(new int[]{a,v});
        }
       
        visited=new boolean[n+1];
        //루트노드에서 가장 먼 노드 찾고
        visited[1]=true;
        dfs(1,0);

        //다시 초기화
        visited=new boolean[n+1];
        maxDist=0;
        //위에서 찾은 노드에서 가장 먼 노드 찾기
        visited[farNode]=true;
        dfs(farNode,0);
        

        System.out.println(maxDist);
    }
    static void dfs(int node, int dist){
        if(dist> maxDist){
            maxDist=dist;
            farNode=node;
        }
        
        for(int[] next: graph.get(node)){
            if(!visited[next[0]]){
                visited[next[0]]=true;
                dfs(next[0],dist+next[1]);
            }
        }
        
    }
}