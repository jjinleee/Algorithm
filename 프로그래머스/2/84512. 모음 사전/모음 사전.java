import java.util.*;

//dfs로 a,e,i,o,u 들어갈때마다 카운트증가
class Solution {
    static String[] vowels={"A","E","I","O","U"};
    public int solution(String word) {
        //리스트에 순차적으로 담고 해당 단어의 인덱스+1을 가져오면 됨
        List<String> list= new ArrayList<>();
        dfs(list, "",0);
        int answer=list.indexOf(word);
        
        return answer;
    }
    static void dfs(List<String> list, String current, int idx){
        if(idx>5){
            return;
        }
        
        list.add(current);
        for(String s :vowels){
            dfs(list, current+s, idx+1);
        }
    }
}