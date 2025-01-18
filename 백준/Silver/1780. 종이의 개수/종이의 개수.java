import java.io.*;
import java.util.*;

public class Main {
    public static int a;
    public static int b;
    public static int c;
    public static int[][] paper;
    public static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        paper=new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);
        System.out.println(a);     
        System.out.println(b);        
        System.out.println(c);        
    }

    public static void divide(int row,int col, int size){
        if(check(row,col,size)){
            if(paper[row][col]==-1) {
                a++;
            }
            else if(paper[row][col]==0){
                b++;
            } else c++;
            return;
        }

        int newSize=size/3;

        divide(row,col,newSize);
        divide(row, col+newSize, newSize);
        divide(row, col+2*newSize, newSize);
        divide(row+newSize, col, newSize);
        divide(row+newSize, col+newSize, newSize);
        divide(row+newSize, col+2*newSize, newSize);
        divide(row+2*newSize, col, newSize);
        divide(row+2*newSize, col+newSize, newSize);
        divide(row+2*newSize, col+2*newSize, newSize);
    }
    
    public static boolean check(int row, int col, int size){
        int num=paper[row][col];

        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(paper[i][j]!=num){
                    return false;
                }
            }
        }
        return true;
    }
}