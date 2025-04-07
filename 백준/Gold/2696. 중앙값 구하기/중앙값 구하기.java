import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int size=Integer.parseInt(br.readLine());
            int cnt=0;
            List<Integer> result=new ArrayList<>();

            //두개의 우선순위 큐 사용
            PriorityQueue<Integer> left= new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right= new PriorityQueue<>();
        
            int numCnt=0;
            while(numCnt<size){
                StringTokenizer st= new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()){
                    int num=Integer.parseInt(st.nextToken());
                    numCnt++;

                    left.offer(num);

                    //left의 최대가 right의 최소보다 크면 right에 넣음
                    if(!right.isEmpty() && left.peek()>right.peek()){
                        right.offer(left.poll());
                    }

                    //사이즈 조정
                    if(left.size()>right.size()+1){
                        right.offer(left.poll());
                    } else if (right.size()> left.size()){
                        left.offer(right.poll());
                    }

                    //홀수일때 중앙값 넣기
                    if(numCnt%2==1){
                        result.add(left.peek());
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
            for(int k=0;k<result.size();k++){
                sb.append(result.get(k)).append(" ");
                if((k+1)%10==0) sb.append('\n');
            }
            if(result.size()%10!=0) sb.append('\n');
            
        }

        System.out.println(sb);
    }
}