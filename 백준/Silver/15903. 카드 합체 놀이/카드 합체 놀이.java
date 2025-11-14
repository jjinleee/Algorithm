import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        //배열보다 리스트가 효율적 (값 변경이 잦음)
        //int[] a=new int[n];
        List<Long> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(Long.parseLong(st.nextToken()));
        }   
        
        Collections.sort(list);
        int cnt=0;
        while(cnt<m){
            if(list.size()<2) break;
            long sum=list.get(0)+list.get(1);
            

            list.remove(0);
            list.remove(0);
            list.add(sum);
            list.add(sum);

            Collections.sort(list);
            cnt++;
        }

        long total=0;
        for(long i : list){
            total+=i;
        }

        System.out.println(total);
    }
}