import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x=0, y=0;
        
        Map<Character, int[]> map=new HashMap<>();
        map.put('U',new int[]{0,1});
        map.put('D',new int[]{0,-1});
        map.put('R',new int[]{1,0});
        map.put('L',new int[]{-1,0});

        Set<String> set =new HashSet<>(); //from->to를 배열로 담음
        
        for(char c : dirs.toCharArray()){
            int nx=x+map.get(c)[0];
            int ny=y+map.get(c)[1];
            
            //범위안에 있으면 양방향으로 넣어야함
            if(nx>=-5 && nx<=5 && ny>=-5 && ny<=5){
                set.add(x+","+y+"->"+nx+","+ny);
                set.add(nx+","+ny+"->"+x+","+y);
                x=nx;
                y=ny;
            }
            
            
        }
        return set.size()/2;
    }
}