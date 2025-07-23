import java.io.*;
import java.util.*;

public class Main {
    static int m,n,h;
    static int[][][] tomato;
    static int[] dx={-1,1,0,0,0,0};
    static int[] dy={0,0,-1,1,0,0};
    static int[] dz={0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());

        tomato=new int[h][n][m];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    tomato[i][j][k]=Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k]==1) q.offer(new int[]{i,j,k});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[2];
            int y=cur[1];
            int z=cur[0];

            for(int i=0;i<6;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                int nz=z+dz[i];

                if(nz>=0 && nz<h && nx>=0 && nx<m && ny>=0 && ny<n ){
                    if(tomato[nz][ny][nx]==0){
                        tomato[nz][ny][nx]=tomato[z][y][x]+1; //토마토익히기
                        q.offer(new int[]{nz,ny,nx});
                    }

                } 
            }
        }

        int result=0;
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(tomato[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    result=Math.max(result, tomato[i][j][k]);
                }

            }
        }

        System.out.println(result-1);
    }
}