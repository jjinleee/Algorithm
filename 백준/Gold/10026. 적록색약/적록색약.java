import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int normal=0;
        int unnormal=0;

        n=Integer.parseInt(br.readLine());

        visited=new boolean[n][n];
        char[][] pic=new char[n][n];
        char[][] pic2=new char[n][n];

        for(int i=0;i<n;i++){
            String s=br.readLine();
            String s2=s.replace('R', 'G');  //적록색약을 위함
            for(int j=0;j<n;j++){
                pic[i][j]=s.charAt(j);
                pic2[i][j]=s2.charAt(j);
            }
        }

        //정상인
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j,pic);
                    normal++;
                }
            }
        }

        sb.append(normal).append(" ");

        //적록색약
        visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j,pic2);
                    unnormal++;
                }
            }
        }

        sb.append(unnormal);

        System.out.println(sb);    
    }

    static void bfs(int x, int y, char[][] arr){
        Queue<int[]> q= new LinkedList<>();
        char c=arr[x][y];

        q.offer(new int[]{x,y});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();

            for(int i=0;i<4;i++){
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && arr[nx][ny]==c){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }
            }

        }
        
    }
}