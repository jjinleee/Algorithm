import java.io.*;
import java.util.*;


public class Main { 
    static int n;
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        board=new int[n][n];

        int maxHeight=0;
        
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
                maxHeight=Math.max(maxHeight, board[i][j]);
            }
        }

        //높이에 따른 덩어리 개수의 최댓값
        int cnt=0;
        for(int h=0;h<maxHeight;h++){
            int count=0;
            visited= new boolean[n][n]; //방문초기화해줘야함

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && board[i][j]>h){
                        dfs(i,j,h);
                        count++;
                    }
                }
            }
            cnt=Math.max(cnt,count);
        }
        
        System.out.println(cnt);
       
    }
    static void dfs(int x,int y,int height){
        visited[x][y]=true;

        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(!visited[nx][ny] && board[nx][ny]>height){
                    dfs(nx,ny,height);
                }
            } 
        }
    }
}