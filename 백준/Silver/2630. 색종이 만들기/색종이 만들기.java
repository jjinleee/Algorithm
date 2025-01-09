import java.io.*;
import java.lang.invoke.StringConcatFactory;
import java.util.*;

public class Main {
    public static int white;
    public static int blue;
    public static int[][] paper;
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

        partition(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row,int col, int size){
        if(colorCheck(row,col,size)){
            if(paper[row][col]==0) white++;
            else blue++;
            return;
        }

        int newSize=size/2;

        partition(row,col,newSize);
        partition(row, col+newSize, newSize);
        partition(row+newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);

    }
    public static boolean colorCheck(int row, int col, int size){
        int color=paper[row][col];

        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(paper[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }
}