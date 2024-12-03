import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer. parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = arr[i][1];
        }

        int[] dp = new int[n];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1; 
            for (int j = 0; j < i; j++) {
                if (b[j] < b[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(n - maxLength);

    }
}