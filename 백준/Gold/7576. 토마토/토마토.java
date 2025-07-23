import java.io.*;
import java.util.*;

public class Main {
    static int m,n;
    static int[][] tomato;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
    
        Queue<int[]> q= new LinkedList<>();

        tomato=new int[m][n];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                tomato[i][j]=Integer.parseInt(st.nextToken());
                if(tomato[i][j]==1){
                    q.offer(new int[]{i,j}); //익은 토마토 모두 시작점으로, 동시에 BFS
                }
            }
        }

       
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx>=0 && nx<m && ny>=0 && ny<n && tomato[nx][ny]==0){
                    tomato[nx][ny]=tomato[x][y]+1; //토마토익힘
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);  // 못 익은 토마토 있음
                    return;
                }
                result = Math.max(result, tomato[i][j]);
            }
        }

        System.out.println(result - 1);  // 1일부터 시작했으므로 -1

    }
}