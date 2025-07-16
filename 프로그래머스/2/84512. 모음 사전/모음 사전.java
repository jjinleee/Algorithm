import java.util.*;

class Solution {
    static List<String> list=new ArrayList<>();
    static char[] c={'A','E','I','O','U'};
    public int solution(String word) {
        dfs("",0);
        for(int i=0;i<list.size();i++){
            if(word.equals(list.get(i))){
                return i;
            }
        }
        return 0;
    }
    static void dfs(String str,int dept ){
        list.add(str);
        if(dept==5) return;
        for(int i=0;i<5;i++){
            dfs(str+c[i], dept+1);
        }
        
    }
}