import java.util.*;

class Solution {
    class File{
        String head;
        int number;
        String origin;
        
        File(String head, int number, String origin){
            this.head=head;
            this.number=number;
            this.origin=origin;
        }
    }
    public String[] solution(String[] files) {
        List<File> list=new ArrayList<>();
        
        for(String f : files){
            int idx=0;
            while(idx<f.length() && !Character.isDigit(f.charAt(idx))){
                idx++;
            }
            String head=f.substring(0,idx);
            int idx2=idx;
            while(idx2<f.length() && Character.isDigit(f.charAt(idx2))){
                idx2++;
            }
            String number=f.substring(idx,idx2 );
            
            list.add(new File(head, Integer.parseInt(number),f));
        }
        
        Collections.sort(list, (a,b)-> {
            int headc=a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if(headc!=0) return headc;
            
            return a.number-b.number;
            }
        );
            
        String[] answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i).origin;
        }
        
        return answer;
    }
}