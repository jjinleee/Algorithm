import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        
        int n= Integer.parseInt(br.readLine());
        int[][] cost=new int[n][n];
        
        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                cost[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp= new int[n][n];
        for(int i=0;i<n;i++){
            dp[n-1][i]=cost[n-1][i];
        }
    
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=Math.max(dp[i+1][j+1], dp[i+1][j])+cost[i][j];
            }
        }
        
        System.out.println(dp[0][0]);
            
    }
}