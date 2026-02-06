import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        //소문자로 변경
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        
        //두글자씩 만들고 특수문자,공백,숫자 포함 원소 버림
        List<String> list= new ArrayList<>();
        for(int i=0;i<str1.length()-1;i++){
            String s=str1.substring(i,i+2);
            if(s.matches("[a-zA-Z]+")) list.add(s);
        }
        List<String> list2= new ArrayList<>();
        for(int i=0;i<str2.length()-1;i++){
            String s=str2.substring(i,i+2);
            if(s.matches("[a-z]{2}")) list2.add(s);
        }
        
        //교집합, 합집합 개수 구하기
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        for(String s : list) map1.put(s, map1.getOrDefault(s,0)+1);
        for(String s : list2) map2.put(s, map2.getOrDefault(s,0)+1);
        
        int intersection=0;
        int union=0;

        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);

            intersection += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }
        
        if (union == 0) return 65536;
        double answer = (double)intersection/union * 65536;
        return (int)answer;
    }
}