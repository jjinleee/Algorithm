import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int cnt=0;
    static int[] queens;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        queens= new int[n];
        
        backtrack(0);
        System.out.println(cnt);

        
    }

    public static void backtrack(int row){
        if(row==n){
            cnt++;
            return;
        }

        for(int col=0;col<n;col++){
            if(isok(row,col)){
                queens[row]=col;
                backtrack(row+1);
            }
        }
        
    }  
    public static boolean isok(int row, int col){
        for(int i=0;i<row;i++){
            if(queens[i]==col || Math.abs(row-i)==Math.abs(col-queens[i])){
                return false;
            }
        }
        return true;
    }  
}