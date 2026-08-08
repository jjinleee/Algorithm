import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        List<List<Integer>> list=new ArrayList<>();
        int n=data.length;
        int m=data[0].length;
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.get(i).add(data[i][j]);
            }
        }
        
        //튜플정렬
        list.sort((a,b)-> a.get(col-1).equals(b.get(col-1)) ? Integer.compare(b.get(0),a.get(0)) : Integer.compare(a.get(col-1),b.get(col-1)));
        
        int answer=0;
        for(int i=row_begin;i<=row_end;i++){
            int sum=0;
            List<Integer> tuple=list.get(i-1);
            for(int t : tuple) sum+=(t%i);
            
            answer^=sum;
        }
        
        
        
        
        return answer;
    }
}