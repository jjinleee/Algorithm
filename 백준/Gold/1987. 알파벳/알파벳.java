import java.io.*;
import java.util.*;

public class Main {
    static int r,c;
    static char[][] board;
    static boolean[] alpha=new boolean[26];
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int answer=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        board=new char[r][c];
        for(int i=0;i<r;i++){
            String s=br.readLine();
            for(int j=0;j<c;j++){
                board[i][j]=s.charAt(j);
            }
        }

        
        alpha[board[0][0]-'A']=true;
        dfs(0,0,1);
        

        System.out.println(answer);
    }
    static void dfs(int x, int y,int depth){
        answer=Math.max(depth, answer);

        
        alpha[board[x][y]-'A']=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx>=0 && nx<r && ny>=0 && ny<c){
                int idx=board[nx][ny]-'A';

                if(alpha[idx]==false){
                    alpha[idx]=true;
                    dfs(nx,ny,depth+1);
                    alpha[idx]=false;
                }
            }

        }
        
    }
}