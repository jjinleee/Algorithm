import java.util.*;

class Solution {
    Set<String> set=new HashSet<>();
    String[] pronoun={"aya","ye","woo","ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        dfs("", "",30);
        for(String s : babbling){
            if(set.contains(s)) answer++;
        }
        
        return answer;
    }
    void dfs(String cur, String prev, int maxLen){
        if(!cur.isEmpty()) set.add(cur);
        
        for(String pro : pronoun){
            if(pro.equals(prev)) continue;
            
            String next=cur+pro;
            if(next.length()<=maxLen){
                dfs(next, pro, maxLen);
            }
        }
    }
}