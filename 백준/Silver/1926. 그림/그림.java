import java.io.*;
import java.util.*;

public class Main {    
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int[][] picture;
    static boolean[][] visited;
    static int max=0;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        picture=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                picture[i][j]=Integer.parseInt(st.nextToken());
            }
        }
       

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && picture[i][j]==1){
                    max=Math.max(max,dfs(i,j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);

    }
    static int dfs(int x,int y){
    
        visited[x][y]=true;
        int count=1;

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny< m && !visited[nx][ny] && picture[nx][ny]==1){
                    count+=dfs(nx,ny);                
            }

        }

        return count;
        
    }
}