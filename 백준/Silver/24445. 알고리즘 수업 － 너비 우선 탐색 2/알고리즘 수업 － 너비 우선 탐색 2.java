import java.io.*;
import java.util.*;

public class Main {    
    static List<List<Integer>> graph=new ArrayList<>();
    static boolean[] visited;
    static int[] answer;
    static int cnt=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        visited=new boolean[n+1];
        answer=new int[n+1];
    
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs(r);

        for(int i=1;i<=n;i++){
            System.out.println(answer[i]);
        } 
    }
    static void bfs(int node){
        Queue<Integer> q= new LinkedList<>();
        q.add(node);
        visited[node]=true;
        answer[node]=cnt++;

        while(!q.isEmpty()){
            int curr=q.poll();

            List<Integer> nextGroup =graph.get(curr);
            Collections.sort(nextGroup, Collections.reverseOrder());

            for(int next : nextGroup){
                if(!visited[next]){
                    q.offer(next);
                    visited[next]=true;
                    answer[next]=cnt++;

                }
            }
        }
    }
}