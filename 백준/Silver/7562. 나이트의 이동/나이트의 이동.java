import java.io.*;
import java.util.*;

public class Main {
    static int l;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t -->0){
            l=Integer.parseInt(br.readLine());
            board=new int[l][l];
            visited=new boolean[l][l];

            StringTokenizer st= new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            int ex=Integer.parseInt(st.nextToken());
            int ey=Integer.parseInt(st.nextToken());
            
            sb.append(bfs(x,y,ex,ey)).append('\n');
            
        }
        System.out.println(sb);
    }
    static int bfs(int x, int y, int ex, int ey){
        if(x==ex && y==ey) return 0;
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int cx=curr[0];
            int cy=curr[1];

            for(int i=0;i<8;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx>=0 && nx<l && ny>=0 && ny<l && !visited[nx][ny]){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny]=true;
                    board[nx][ny]=board[cx][cy]+1;

                    if(nx==ex && ny==ey){
                        return board[nx][ny];
                    }

                }
            }
        }
        return -1;
    }
}