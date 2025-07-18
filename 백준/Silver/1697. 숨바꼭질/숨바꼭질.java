import java.io.*;
import java.util.*;

public class Main {    
    static int n,k;
    static boolean[] visited=new boolean[100001];
    static int[] time=new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        
        bfs(n);

        
    }
    static void bfs(int node){
        Queue<Integer> q= new LinkedList<>();
        q.add(node);
        visited[node]=true;

        while(!q.isEmpty()){
            int curr=q.poll();

            if(curr==k){
                System.out.println(time[curr]);
                return;
            }


            for(int next : new int[]{curr+1, curr-1, 2*curr}){
                if(next>=0 && next<=100000 && !visited[next]){
                    q.offer(next);
                    visited[next]=true;
                    time[next]=time[curr]+1;
                }
            }
        }
    }
}