import java.io.*;
import java.util.*;


public class Main{
    public static boolean[][] arr;
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        String s=br.readLine();

        StringTokenizer st=new StringTokenizer(s);
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        arr=new boolean[N][M];

        for(int i=0;i<N;i++){
            s=br.readLine();
            for(int j=0;j<M;j++){
                if(s.charAt(j)=='W'){
                    arr[i][j]=true;
                } else arr[i][j]=false;
            }
        }  

        
        for(int i=0;i<N-7;i++){
            for(int j=0;j<M-7;j++){
                find(i,j);
            }
        }
        System.out.println(min);
    
    }
    public static void find(int x,int y){
        int cnt=0;

        boolean check=arr[x][y];
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if(arr[i][j]!=check) cnt++;
                check=!check;
            }
            check=!check;
        }
        cnt=Math.min(cnt,64-cnt);
        min=Math.min(min,cnt);

    }
}