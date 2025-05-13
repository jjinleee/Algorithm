import java.util.*;

class Solution {
    List<String> list= new ArrayList<>();
    String[] vowels={"A","E","I","O","U"};
    
    public int solution(String word) {
        int cnt = 0;
        dfs("",0);
        
        return list.indexOf(word)+1;
    }
    void dfs(String current, int d){
        if(d>5) return;
        
        if(!current.isEmpty()) list.add(current);
        for(String s : vowels){
            dfs(current+s, d+1);
        }
    }

}