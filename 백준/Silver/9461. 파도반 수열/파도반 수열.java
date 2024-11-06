import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        int[] test= new int[n];
        int max=0;

        for(int i=0;i<n;i++){
            test[i]=Integer.parseInt(br.readLine());
            max=Math.max(max, test[i]);
        }

        long[] dp= new long[Math.max(5, max+1)];
        dp[1]=dp[2]=dp[3]=1;
        dp[4]=dp[5]=2;

        for(int i=6;i<=max;i++){
            dp[i]=dp[i-1]+dp[i-5];
        }
        for(int i=0;i<n;i++){
            sb.append(dp[test[i]]).append('\n');
        }

        System.out.println(sb);
    }
}