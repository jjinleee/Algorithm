import java.io.*;
import java.util.*;


public class Main { 
    static boolean[] visited=new boolean[26];
    static int r,c;
    static char[][] board;
    static int cnt=0;
    static List<Character> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        board=new char[r][c];
        
        for(int i=0;i<r;i++){
            String s=br.readLine();
            for(int j=0;j<c;j++){
                board[i][j]=s.charAt(j);
            }
        }

        dfs(0,0,1);
        System.out.println(cnt);
       
    }
    static void dfs(int x,int y, int depth){
        cnt=Math.max(cnt,depth);
        visited[board[x][y]-'A']=true;

        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};

       
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx>=0 && nx<r && ny>=0 && ny<c){
                char next=board[nx][ny];
                if(!visited[next-'A']){
                    dfs(nx,ny,depth+1);
                }
            }

        }
        visited[board[x][y]-'A']=false;


    }
}