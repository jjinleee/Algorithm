import java.util.*;

class Solution {
    char[] dict={'A','E','I','O','U'};
    List<String> list=new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
    
        dfs(0, "");
        
        for(int i=0;i<list.size();i++){
            if(word.equals(list.get(i))) return i;
        }
        return 0;
    }
    void dfs(int len,String cur){
        list.add(cur);
        if(len==5) return;
        
        for(int i=0;i<5;i++){
            dfs(len+1, cur+dict[i]);
        }
    }
}