import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        StringBuilder sb= new StringBuilder();
        ArrayDeque<Integer> d= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int com= Integer.parseInt(st.nextToken());
            switch (com) {
                case 1:
                    d.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    d.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    sb.append(d.isEmpty()? -1:d.pollFirst()).append('\n');
                    break;  
                case 4:
                    sb.append(d.isEmpty()? -1:d.pollLast()).append('\n');
                    break;
                case 5: 
                    sb.append(d.size()).append('\n');
                    break;
                case 6:
                    sb.append(d.isEmpty()? 1:0).append('\n');
                    break;
                case 7:
                    sb.append(d.isEmpty()? -1:d.peekFirst()).append('\n');
                    break;   
                case 8:
                    sb.append(d.isEmpty()? -1:d.peekLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb);

    }
}