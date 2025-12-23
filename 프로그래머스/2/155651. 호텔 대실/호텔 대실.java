import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(book_time, (a,b)->a[0].compareTo(b[0]));
        
        for(String[] b : book_time){
            int start=totime(b[0]);
            int end=totime(b[1]);
            
            //기존방종료시각<=시작시간이면 있는 방 씀
            if(!list.isEmpty() && start>=list.get(0)){
                list.remove(0); //기존방을 대체
            } 
            list.add(end+10); 
            Collections.sort(list); //종료시각 별로 정렬
                
        }
        return list.size();
    }
    int totime(String s){
        String[] tmp=s.split(":");
        int h=Integer.parseInt(tmp[0]);
        int m=Integer.parseInt(tmp[1]);
        
        return h*60+m;
    }
}