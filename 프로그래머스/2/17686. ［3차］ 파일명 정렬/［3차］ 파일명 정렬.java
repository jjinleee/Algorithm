import java.util.*;

class Solution {
    class File{
        int order;
        String head;
        int number;
        String origin;
        
        File(int order, String head, int number, String origin){
            this.order=order;
            this.head=head;
            this.number=number;
            this.origin=origin;
        }
    }
    public String[] solution(String[] files) {
        List<File> list=new ArrayList<>();
        
        for(int i=0;i<files.length;i++){
            String cur=files[i];
            int j=0;
            
            while(j<cur.length() && !Character.isDigit(cur.charAt(j))){ 
                j++; 
            }
            
            String head=cur.substring(0,j).toLowerCase();
            int k=j;
            while(k<cur.length() && Character.isDigit(cur.charAt(k)) && k-j<5){
                    k++;
            }
            int number=Integer.parseInt(cur.substring(j,k));
            
            
            list.add(new File(i,head, number, cur));
        }
        
        Collections.sort(list, (a,b)-> {
            int cnt=a.head.compareTo(b.head);
            if(cnt==0){
                if(a.number==b.number) return a.order-b.order;
                return a.number-b.number;
            }
            
            return cnt;
        });
        
        String[] answer=new String[files.length];
        int idx=0;
        for(File f : list){
            answer[idx++]=f.origin;
        }
        
        
        return answer;
    }
}