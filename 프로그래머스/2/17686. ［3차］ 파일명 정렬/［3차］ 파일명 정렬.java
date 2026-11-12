import java.util.*;

class Solution {
    class File{
        String head;
        int number;
        int order;
        String origin;
        
        File(String head, int number, int order, String origin){
            this.head=head;
            this.number=number;
            this.order=order;
            this.origin=origin;
        }
    }
    public String[] solution(String[] files) {
        List<File> list=new ArrayList<>();
        
        for(int idx=0;idx<files.length;idx++){
            String f=files[idx];
            int i=0;
            while(i<f.length() && !Character.isDigit(f.charAt(i)) ) i++;
            String head=f.substring(0,i).toLowerCase();
            
            int j=i;
            while(j<f.length() && Character.isDigit(f.charAt(j)) ) j++;
            int num=Integer.parseInt(f.substring(i,j));
            
            list.add(new File(head, num, idx, f));
        }
        
        list.sort((a,b)-> {
            if(a.head.equals(b.head)){
                if(a.number==b.number){
                    return a.order-b.order;
                } else return a.number-b.number;
            } else return a.head.compareTo(b.head);
        });
        
        String[] answer=new String[list.size()];
        int o=0;
        for(File l : list){
            answer[o++]=l.origin;
        }
            
        return answer;
    }
}