import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;
    static long[][] origin={{1,1},{1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n= Long.parseLong(br.readLine());
        long[][] A={{1,1},{1,0}};

        System.out.println(pow(A,n-1)[0][0]);
    } 

    public static long[][] pow(long[][] A, long exp){
        if(exp==1 || exp==0) return A;
        long[][] temp=pow(A,exp/2);
        temp=multiply(temp, temp);

        if(exp%2!=0){
            temp=multiply(temp, A);
        }
        return temp;
    }

    public static long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        result[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD;
        result[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD;
        result[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD;
        result[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD;
        return result;
    }
}