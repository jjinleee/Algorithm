import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=1;i<=n;i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            for(int i=0;i<k-1;i++){//뒤로보냄
                queue.offer(queue.poll());
            }
            result.add(queue.poll()); //k번째 빼서 result에 추가
        }

        StringBuilder sb= new StringBuilder();
        sb.append("<");

        for(int i=0;i<n;i++){
            sb.append(result.get(i));
            if(i!=result.size()-1) sb.append(", ");
        }
        sb.append(">");


        System.out.println(sb.toString());
    }
}