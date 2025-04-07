import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        

        //보석의 무게, 가격
        int[][] jewels=new int[n][2];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            jewels[i][0]=Integer.parseInt(st.nextToken());
            jewels[i][1]=Integer.parseInt(st.nextToken());
        }

        //가방
        long[] bags= new long[k];
        for(int i=0;i<k;i++){
            bags[i]=Long.parseLong(br.readLine());
        }

        //보석: 무게 기준 오름차순
        Arrays.sort(jewels, Comparator.comparing(j->j[0]));

        //가방: 오름차순
        Arrays.sort(bags);


        //가격 기준 내림차순
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        long total=0;
        int jewelIndex=0;

        for(int i=0;i<k;i++){
            long capacity=bags[i];

            //현재 가방에 넣을 수 있는 보석 우선순위 큐에 넣음
            while(jewelIndex<n && jewels[jewelIndex][0]<=capacity){
                pq.add(jewels[jewelIndex][1]);
                jewelIndex++;
            }

            if(!pq.isEmpty()){
                total+=pq.poll();
            }
        }

        System.out.println(total);
       
    }
}