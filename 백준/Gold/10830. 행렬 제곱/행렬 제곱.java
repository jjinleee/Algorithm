import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        long b= Long.parseLong(st.nextToken());

        A=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                A[i][j]=Integer.parseInt(st.nextToken())%1000;
            }
        }

        int[][] result=pow(A,b);

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    } 

    public static int[][] pow(int[][] A, long exp){
        if(exp==1) return A;
        int[][] temp=pow(A,exp/2);
        temp=multi(temp, temp);

        if(exp%2!=0){
            temp=multi(temp, A);
        }
        return temp;
    }

    public static int[][] multi(int[][] A1, int[][] A2){
        int[][] mul=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int t=0;t<n;t++){
                    mul[i][j]+=A1[i][t]*A2[t][j]%1000;
                    mul[i][j]%=1000;
                }
            }
        }
        return mul;
    }
}