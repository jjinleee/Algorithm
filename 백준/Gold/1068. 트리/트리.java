import java.io.*;
import java.util.*;

public class Main {    
    static int n;
    static int remove;
    static int cnt=0;
    static boolean[] visited;
    static List<List<Integer>> graph=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        int[] parent=new int[n];

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        int root=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            parent[i]=Integer.parseInt(st.nextToken());
            if(parent[i]==-1) root=i;
            else graph.get(parent[i]).add(i);
        }


       
        remove=Integer.parseInt(br.readLine());

        //예외처리
        if(root==remove){ //루트노드를 제거하는 경우
            System.out.println(0);
        } else{
            dfs(root);
            System.out.println(cnt);
        }
    }
    
    static void dfs(int node){
        if(node==remove) return;

        boolean isLeaf=true;
        for(int next: graph.get(node)){
            if(next!=remove){
                isLeaf=false;
                dfs(next);
            }
        }

        if(isLeaf) cnt++;
    }

}