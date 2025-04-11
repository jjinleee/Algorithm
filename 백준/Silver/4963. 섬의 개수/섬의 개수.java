import java.io.*;
import java.util.*;


public class Main { 
    static int w,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st= new StringTokenizer(br.readLine());

            w=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;
            
            int[][] island=new int[h][w];
            boolean[][] visited= new boolean[h][w];

            for(int i=0;i<h;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    island[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            int cnt=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visited[i][j] && island[i][j]==1){
                        dfs(i,j,visited,island);
                        cnt++;
                    }

                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int x,int y, boolean[][] visited, int[][] island){
        //대각선까지포함
        int[] dx={-1,1,0,0,1,-1,-1,1};
        int[] dy={0,0,1,-1,1,-1,1,-1};
        

        visited[x][y]=true;

        for(int i=0;i<8;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx>=0 && nx<h && ny>=0 && ny<w){
                if(!visited[nx][ny] && island[nx][ny]==1){
                    visited[nx][ny]=true;
                    dfs(nx,ny,visited, island);
                }
            }
        }


    }
}