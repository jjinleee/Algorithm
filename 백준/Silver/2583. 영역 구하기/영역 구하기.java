import java.io.*;
import java.util.*;


public class Main { 
    static int m,n,k;
    static boolean[][] visited;
    static int[][] board;
    static List<Integer> extent=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        visited=new boolean[m][n];
        board= new int[m][n];

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            //직사각형 부분을 1로 채움
            for(int x=x1;x<x2;x++){
                for(int y=y1;y<y2;y++){
                    board[y][x]=1;
                }
            }
        }

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && board[i][j]==0){
                    extent.add(dfs(i,j));
                    count++;
                }
                
            }
        }

        Collections.sort(extent);
        System.out.println(count);
        for(int e : extent){
            System.out.print(e+" ");
        }
       
    }
    static int dfs(int x,int y){
        int cnt=1;
        visited[x][y]=true;

        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx>=0 && ny>=0 && nx<m && ny< n){
                if(!visited[nx][ny] && board[nx][ny]==0){
                    cnt+=dfs(nx,ny);
                }
            }
        }

        return cnt;

    }
}