import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        boolean[][] square=new boolean[101][101];

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            
            for(int x=w ;x<w+10 ;x++){
                for(int y=h;y<h+10;y++){
                    square[x][y]=true;
                }
            }
        }

        int cnt=0;
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                if(square[i][j]==true) cnt++;
            }
        }

        System.out.println(cnt);

    }
}