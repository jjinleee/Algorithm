import java.util.*;

class Solution {
    static char[] dict={'A','E','I','O','U'};
    static List<String> list=new ArrayList<>();
    static int cnt=0;
    public int solution(String word) {
        
        find("",0);
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(word)) return i;
        }
        return 0;
    }
    static void find( String cur, int depth){
        list.add(cur);
        if(depth==5) return;
        
        for(int i=0;i<5;i++){
            find( cur+dict[i], depth+1);
        }
    }
}