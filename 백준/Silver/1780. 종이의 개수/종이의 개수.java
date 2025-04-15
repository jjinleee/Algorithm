import java.io.*;
import java.util.*;


public class Main { 
    static int[][] paper;
    static int c1=0;
    static int c2=0;
    static int c3=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        paper=new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                paper[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        cut(n,0,0);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        
    }

    static void cut(int n, int x, int y){
        if(isSame(n, x, y)) {
            if(paper[x][y]==0){
                c2++;
            } else if(paper[x][y]==-1){
                c1++;
            } else c3++;
            return;
        }

        int newSize=n/3;


        cut(newSize, x, y);
        cut(newSize, x, y+newSize);
        cut(newSize, x, y+newSize*2);
        cut(newSize, x+newSize, y);
        cut(newSize, x+newSize, y+newSize);
        cut(newSize, x+newSize, y+newSize*2);
        cut(newSize, x+newSize*2, y);
        cut(newSize, x+newSize*2, y+newSize);
        cut(newSize, x+newSize*2, y+newSize*2);

    }

    static boolean isSame(int n, int x, int y){
        int color=paper[x][y];

        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(paper[i][j]!=color){
                    return false;
                }
            }
        }

        return true;
    }

}