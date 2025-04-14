import java.io.*;
import java.util.*;


public class Main { 
    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        board=new int[n][m];
        visited= new boolean[n][m];
        
        for(int i=0;i<n;i++){
            String s=br.readLine();
            for(int j=0;j<m;j++){
                board[i][j]=s.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(board[n-1][m-1]);
       
    }
    static void bfs(int x,int y){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;


        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};

       
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            int curx=now[0];
            int cury=now[1];

            for(int i=0;i<4;i++){
                int nx=curx+dx[i];
                int ny=cury+dy[i];

                if(nx>=0 &&  nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny] && board[nx][ny]==1){
                        visited[nx][ny]=true;
                        board[nx][ny]=board[curx][cury]+1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}