import java.io.*;
import java.util.*;

public class Main {
    static int[] board;
    static int cnt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        board= new int[n];

        nqueen(0,n);
        System.out.println(cnt);
    }

    static void nqueen(int row, int n){
        if(row==n){
            cnt++;
            return;
        }

        for(int col=0;col<n;col++){
            board[row]=col;
            if(isSafe(row)) nqueen(row+1, n);
        }
    }

    static boolean isSafe(int row){
        for(int i=0;i<row;i++){
            if(board[i]==board[row]|| Math.abs(board[row]-board[i])==row-i){
                return false;
            }
        }
        return true;
    }
    
}