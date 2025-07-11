import java.io.*;
import java.util.*;

public class Main {
    static int[][] home;
    static boolean[][] visited;
    static int cnt=0;
    static List<Integer> list=new ArrayList<>();
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        home=new int[n][n];
        
        
        for(int i=0;i<n;i++){
            String s=br.readLine();
            for(int j=0;j<n;j++){
                home[i][j]=s.charAt(j)-'0';
            }
        }

        visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && home[i][j]==1){
                    bfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt); 
        Collections.sort(list);
        for(int l : list){
            System.out.println(l);
        }
    }    
    
    static void bfs(int x, int y){
        int c=1;
       Queue<int[]> q=new LinkedList<>();
       q.offer(new int[]{x,y});
       visited[x][y]=true;

       while(!q.isEmpty()){
            int[] curr=q.poll();

            for(int i=0;i<4;i++){
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(!visited[nx][ny] && home[nx][ny]==1){
                        c++;
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny]=true;
                    }                   
                }

            }
       }
       list.add(c);

    }
}