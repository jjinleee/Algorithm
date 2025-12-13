import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N+2];
        int total=stages.length;
        
        for(int s : stages){
            if(s<=N) count[s]++;
        }
        
        double[] fail=new double[N+1];
        for(int i=1;i<=N;i++){
            if(total==0) fail[i]=0.0;
            else{
                fail[i]=(double)count[i]/total;
                total-=count[i];
            }
            
        }
        Integer[] order=new Integer[N];
        for(int i=0;i<N;i++){
            order[i]=i+1;
        }
        
        Arrays.sort(order, (a,b)-> {
            if(fail[b]>fail[a]) return 1;
            else if (fail[b]<fail[a]) return -1;
            else return Integer.compare(a,b);
        });
            
        int[] answer=new int[N];
        for(int i=0;i<N;i++){
            answer[i]=order[i];
        }
            
            
        return answer;
    }
}