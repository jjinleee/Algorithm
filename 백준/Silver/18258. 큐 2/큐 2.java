import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());


        StringBuilder sb= new StringBuilder();
        Deque<Integer> queue= new ArrayDeque<>();

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String q=st.nextToken();
            switch (q) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    sb.append(queue.isEmpty()? -1:queue.getFirst()).append('\n');
                    break;
                case "pop":
                    sb.append(queue.isEmpty()? -1:queue.pollFirst()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1:0).append('\n');
                    break;
                case "back":
                    sb.append(queue.isEmpty()? -1: queue.getLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);

    }
}