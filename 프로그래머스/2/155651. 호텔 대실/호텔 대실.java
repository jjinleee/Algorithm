import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(book_time, (a,b)->a[0].compareTo(b[0]));
        
        for(String[] b : book_time){
            int start=toMin(b[0]);
            int end=toMin(b[1]);
            
            if(!list.isEmpty() && start>=list.get(0)){
                list.remove(0);
            }
            list.add(end+10);
            Collections.sort(list);
        }
        return list.size();
    }
    int toMin(String a){
        String[] tmp=a.split(":");
        int h=Integer.parseInt(tmp[0]);
        int m=Integer.parseInt(tmp[1]);
        
        return 60*h+m;
    }
}