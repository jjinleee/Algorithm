import java.util.*;

class Solution {
    static class File{
        String head;
        int number;
        String original;
    
        File(String head, int number, String original){
            this.head=head;
            this.number=number;
            this.original=original;
        }
    }
    public String[] solution(String[] files) {
        List<File> list= new ArrayList<>();
        
        for(String f : files){
            int idx=0;
            while(idx<f.length() && !Character.isDigit(f.charAt(idx))){
                idx++;
            }
            String h=f.substring(0,idx);

            int start=idx;
            while(idx<f.length() && Character.isDigit(f.charAt(idx)) && idx-start<5){
                idx++;
            }
            
            int n=Integer.parseInt(f.substring(start,idx));

            list.add(new File(h,n,f));
        }
        
        Collections.sort(list, (a, b) -> {
            int headCompare = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if (headCompare != 0) return headCompare;

            return a.number - b.number;
        });

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).original;
        }
        return answer;
    }
}