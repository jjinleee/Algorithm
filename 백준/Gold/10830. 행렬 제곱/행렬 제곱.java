import java.io.*;
import java.util.*;


public class Main { 
    static long b;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        b=Long.parseLong(st.nextToken());
        int[][] matrix=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int[][] result=power(matrix, b);

        StringBuilder sb= new StringBuilder();
        for(int[] row: result){
            for(int num : row){
                sb.append(num%1000).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        
    }
    //행렬 거듭제곱
    static int[][] power(int[][] matrix, long exp){
        if(exp==1L){
            return matrix;
        }

        int[][] half=power(matrix, exp/2);
        int[][] res=multiply(half, half);

        if(exp%2==1L){
            res=multiply(res, matrix);
        }
        return res;
    }

    static int[][] multiply(int[][] a, int[][] b){
        int[][] result=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum=0;
                for(int k=0;k<n;k++){
                    sum+=(a[i][k]*b[k][j]);
                }
                result[i][j]=sum%1000;
            }
        }

        return result;
    }
   
}