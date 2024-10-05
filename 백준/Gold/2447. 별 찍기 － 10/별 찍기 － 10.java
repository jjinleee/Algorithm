import java.io.*;
import java.util.*;

public class Main {
       static  char[][] pattern;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        pattern=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pattern[i][j]=' ';
            }
        }

        star(0,0,n);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(pattern[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void star(int x, int y,int n){
        if(n==3){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(i==1 && j==1) continue;
                    pattern[x+i][y+j]='*';
                }
            }
            return;
        }

        int div=n/3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==1 && j==1) continue;
                star(x+div*i, y+div*j, div);
            }
        }
    }
}