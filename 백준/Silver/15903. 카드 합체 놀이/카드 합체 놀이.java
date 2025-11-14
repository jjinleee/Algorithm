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
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }   
        
        int cnt=0;
        while(cnt<m){
            long sum=pq.poll()+pq.poll();

            pq.offer(sum);
            pq.offer(sum);

            cnt++;
        }

        long total=0;
        for(long i : pq){
            total+=i;
        }

        System.out.println(total);
    }
}