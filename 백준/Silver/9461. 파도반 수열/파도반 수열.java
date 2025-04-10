import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        long[] dp=new long[101];

        dp[1]=dp[2]=dp[3]=1;
        for(int j=4;j<=100;j++){
            dp[j]=dp[j-2]+dp[j-3];
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
        
    }
    
}