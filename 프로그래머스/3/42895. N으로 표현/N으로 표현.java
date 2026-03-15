import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N==number) return 1;
        
        List<Set<Integer>> dp=new ArrayList<>();//dp[i] : N을 i번ㄴ사용해서만들수있는 수조합
        dp.add(new HashSet<>()); //0번
        
        for(int i=1;i<=8;i++){
            Set<Integer> set=new HashSet<>();
            
            //이어붙인수
            int repeat=0;
            for(int k=0;k<i;k++){
                repeat=repeat*10+N;
            }
            set.add(repeat);
            
            for(int j=1;j<i;j++){
                for(int a : dp.get(j)){
                    for(int b : dp.get(i-j)){
                        set.add(a+b);
                        set.add(a-b);
                        set.add(a*b);
                        if(b!=0) set.add(a/b);
                    }
                }
            }
            if(set.contains(number)) return i;
            dp.add(set);
        }
        
        return -1;
        
    }
}