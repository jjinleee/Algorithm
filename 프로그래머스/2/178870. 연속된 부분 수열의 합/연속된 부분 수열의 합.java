import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        
        int left = 0;
        int right = 0;
        int sum = 0;
        
        int start = 0;
        int end = n - 1;
        int minLen = n;
        
        while (true) {
            if (sum >= k) {
                if (sum == k) {
                    int len = right - left;
                    
                    if (len < minLen) {
                        minLen = len;
                        start = left;
                        end = right - 1;
                    }
                }
                
                sum -= sequence[left];
                left++;
            } else {
                if (right == n) break;
                
                sum += sequence[right];
                right++;
            }
        }
        
        return new int[]{start, end};
    }
}