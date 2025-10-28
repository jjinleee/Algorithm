import java.util.*;

class Solution {
    static char[] dict={'A','E','I','O','U'};
    static List<String> list=new ArrayList<>();
    public int solution(String word) {
        
        find("",0);
        for(int i=0;i<list.size();i++){
            if(word.equals(list.get(i))){
                return i;
            }
        }
        return 0;
    }
    static void find(String current, int depth){
        list.add(current);
        if(depth==5) return;
        
        for(int i=0;i<dict.length;i++){
            find(current+dict[i], depth+1);
        }
    }
}