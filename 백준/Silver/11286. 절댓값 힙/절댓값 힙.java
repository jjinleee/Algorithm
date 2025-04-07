import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        //절댓값이 작은 값 출력, 절댓값 같을때는 가장 작은 수 출력
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->{
            if(Math.abs(a)==Math.abs(b)) return a-b;
            return Math.abs(a)-Math.abs(b);
        });

        StringBuilder sb= new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0) {
                if(pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            }
            else pq.add(num);
        }

        System.out.println(sb);
    }
}