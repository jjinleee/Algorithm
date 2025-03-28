import java.util.*;
class Solution {
    List<String> dict= new ArrayList<>();
    String[] vowels={"A","E","I","O","U"};
    
    public int solution(String word) {
        dfs("",0);
        
        return dict.indexOf(word)+1;
    }
    void dfs(String current, int depth){
        if(depth>5) return;
        
        if(!current.isEmpty()) dict.add(current);
        for(String v:vowels){
            dfs(current+v,depth+1);
        }
    }
}