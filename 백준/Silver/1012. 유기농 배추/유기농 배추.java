import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static int[][] ground;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());


        for(int test=0;test<t;test++){
            int cnt=0;
            StringTokenizer st=new StringTokenizer(br.readLine());

            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            ground=new int[m][n];
            
            
            for(int i=0;i<k;i++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());

                ground[x][y]=1;
                
            }

            visited=new boolean[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && ground[i][j]==1){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }     
            sb.append(cnt).append('\n');       
        }

        System.out.println(sb.toString());
 
    }    
    
    static void bfs(int x, int y){
       Queue<int[]> q=new LinkedList<>();
       q.offer(new int[]{x,y});
       visited[x][y]=true;

       while(!q.isEmpty()){
            int[] curr=q.poll();

            for(int i=0;i<4;i++){
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];

                if(nx>=0 && ny>=0 && nx<m && ny<n){
                    if(!visited[nx][ny] && ground[nx][ny]==1){
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny]=true;
                    }                   
                }

            }
       }

    }
}