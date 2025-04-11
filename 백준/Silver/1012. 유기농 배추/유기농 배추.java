import java.io.*;
import java.util.*;


public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());   

        for(int i=0;i<t;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            //밭 정보
            int[][] ground=new int[n][m];
            boolean[][] visited=new boolean[n][m];
            for(int j=0;j<k;j++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());

                ground[y][x]=1;
            }
            int cnt=0;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (ground[y][x] == 1 && !visited[y][x]) {
                        dfs(n, m, y, x, ground, visited);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void dfs(int n, int m, int x, int y, int[][] ground, boolean[][] visited){
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};

        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{x,y});
        visited[x][y]=true;

        while(!stack.isEmpty()){
            int[] cur=stack.pop();

            for(int d=0;d<4;d++){
                int nx=cur[0]+dx[d];
                int ny=cur[1]+dy[d];

                if(nx>=0 && nx<n && ny>=0 && ny<m ){
                    if(!visited[nx][ny] && ground[nx][ny]==1){
                        visited[nx][ny]=true;
                        stack.push(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}