import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n=land.length;
        //dp초기화
        int[][] dp=new int[n][4];
        for(int i=0;i<4;i++) dp[0][i]=land[0][i];

        
        for(int i=1;i<n;i++){
            for(int j=0;j<4;j++){
                int max=0;
                for(int k=0;k<4;k++){
                    if(j==k) continue;
                    
                    max=Math.max(max, dp[i-1][k]); //이전열에서 j열 제외한 최댓값
                }
                dp[i][j]=max+land[i][j];
            }
        }
        int answer = 0;

        for (int j = 0; j < 4; j++) {

            answer = Math.max(answer, dp[n - 1][j]);

        }
        return answer;
    }
}