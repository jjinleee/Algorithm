import java.io.*;
import java.util.*;

public class Main {
    static int[][] board= new int[9][9];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<9;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        solve(0,0);

        
    }

    public static void solve(int row, int col){
        if(row==9) {
            StringBuilder sb= new StringBuilder();
            for(int[] r: board){
                for(int n:r){
                    sb.append(n).append(" ");
                }
                sb.append('\n');
            }
    
            System.out.println(sb);
            System.exit(0); //다채움
        }
        if(col==9){ //다음 행으로 넘어감
            solve(row+1, 0);
            return;
        }


        //빈칸일때 숫자넣어보기
        if(board[row][col]==0){
            for(int n=1;n<=9;n++){
                if(isValid(row, col, n)){
                    board[row][col]=n;
                    solve(row, col+1);
                    board[row][col]=0; //백트래킹
                }
            }
        } else {solve(row, col+1);} //채원진칸은 건너뜀
    }

    static boolean isValid(int row, int col, int num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num) return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==num) return false;
        }

        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }

}