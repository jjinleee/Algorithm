import java.io.*;
import java.util.*;

public class Main {
    static char[][] pattern;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        pattern=new char[n][n];
        
        StringBuilder sb = new StringBuilder();
        toEmpty(n, 0, 0);
        for(char[] r: pattern){
            for(char c: r){
                sb.append(c);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    //재귀적으로 가운데를 공백으로 치환
    static void toEmpty(int n, int x, int y){
        if(n==1){
            pattern[x][y]='*';
            return;
        }
        int size=n/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==1 && j==1){
                    blank(size,x+size*i, y+size*j);
                } else {
                    toEmpty(size, x+size*i, y+size*j);
                }
            }
        }
    }
    static void blank(int n, int x, int y){
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                pattern[i][j]=' ';
            }
        }
    }
}